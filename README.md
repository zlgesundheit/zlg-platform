# zlg-platform

## Context
The ZLG is using the [EHRBase](https://github.com/ehrbase/ehrbase) an openEHR Clinical Data Repository to store data in an interopable way using the openEHR-Technology Framework.

To make the data accessible by endusers the platform incorporates the NUM-Portal as well as NUM WebApp developed by [NUM CODEX project](https://num-codex.de). This allows for data management, data search, user management and more. You may use the official NUM CODEX images or fork/mirror those to build your own image with altered style/texts.

### Data Import
With the openEHR_FLAT_Loader there are python-based scripts available to import/export data using CLI and REST. Those scripts can generate an Excel-Mapping-File that allows you to map your source-data (.csv-File) to an existing openEHR-Template´s data items. With this manual user-supplied mapping you may use the scripts to generate Compositions-Files that can also be uploaded to an openEHR-Repository-Server (like EHRBase or Better Server). See the [github repository of the openEHR_FLAT_Loader](https://github.com/zlgesundheit/openEHR_FLAT_Loader) for more informationen.

There are also other solution available (e.g. see [HaMSTRETLBuilder](https://pdfs.semanticscholar.org/1e77/f83c1d73d5c4d1e1f62db345832b8fb2aca4.pdf)).

### About openEHR
More in depth explanation of the interoperable technology framework "openEHR" at our [Docusaurus-Documentation](https://c100-115.cloud.gwdg.de/docs/) or at the offical [website](https://openehr.org) which also hosts the [standards specification](https://specifications.openehr.org).

## Usage
You can start the different tools via docker-compose.

Tools
- EHRBase Clinical Data Repository (ehrbase_docker)
- NUM Portal (portal_docker)
- ZLG-Documentation (zlg_docs)

For the data import tool "FLAT_Loader" see [FLAT_Loader Github-Repository](https://github.com/zlgesundheit/openEHR_FLAT_Loader).

## Startup

### Create a valid SSL-Cert (once at first start)
See [SSL-Encryption Section](#ssl-encryption)

### Alter Domain-Settings and Environment variables
- Change Domain-Names in `config.deploy.json`
- Define passwords in `.env`
- If you want to also host the docs alter domain-settings in  `./docs/zlg-docs/docusaurus.config.js`

## Start all containers  
Start Container using  

`docker-compose up -d`

### Init Databases
#### Init DB for EHRBase
Set password in `./portal_docker/sql/createdb.sql` according to \$\{EB_DB_PASS\} in .env file.
Alter \$\{CONTAINER-NAME\} which would be "postgres" by default. 
- `docker cp ./portal_docker/sql/createdb.sql ${CONTAINER-NAME}:/docker-entrypoint-initdb.d/createdb.sql`
- `docker exec -u postgres ${CONTAINER-NAME} psql postgres postgres -f docker-entrypoint-initdb.d/createdb.sql`

 (See [EHRBase SQL Init Skript](https://github.com/ehrbase/ehrbase/blob/develop/base/db-setup/createdb.sql)).

---

#### Init NUM-Portal Attachment Database
Alter ${CONTAINER-NAME} which would be "postgres" by default. 
1. `docker cp ./portal_docker/sql/createdb_attachments-db-setup.sql ${CONTAINER-NAME}:/docker-entrypoint-initdb.d/dump.sql`
2. `docker exec -u postgres ${CONTAINER-NAME} psql postgres postgres -f docker-entrypoint-initdb.d/dump.sql`

(See [NUM-Portal SQL Init Skript](https://github.com/NUM-Forschungsdatenplattform/num-portal/blob/develop/attachments-db-setup/createdb.sql))

---

### Setup Keycloak-Auth with NUM-Portal
#### Generate a client-secret
- Visit Keycloak Endpoint at https://DOMAIN/auth
- Generate new secret via **Clients -> num-portal -> Credentials -> Regenerate Secret**
- Copy Secret-Value in Keycloak and set ${KEYCLOAK_CLIENT_SECRET} in .env-File
- Recreate num-portal container: `docker-compose up -d --force-recreate num-portal`

#### Setup First User
- Visit Frontend on https://DOMAIN/home
- CLick on Login and register a new user at the keycloak
- Visit keycloak admin interface at https://DOMAIN/auth
    - Go to Users -> View all users -> Edit -> Role Mapping -> Assign all roles
    - Go to Users -> View all users -> Edit -> Email Verified = ON -> Save
- Re-log in the Frontend
- Enter the database (e.g. using adminer at port :5000) 
    - e.g. expose port of adminer/pg_admin and login to the DB  
    - e.g. Login to server=postgres, user=postgres, pw=${POSTGRES_PASSWORD}, database=ehrbase
    - See schema "num" and in table "user_details" set the user to approved (identified by same id like in keycloak)
- Re-log in the Frontend 
- **You should have all rights in the portal now** 

### SSL-Encryption
Setting up SSL Encryption using NGINX and LetsEncrypt is a [two step process](https://blog.jarrousse.org/2022/04/09/an-elegant-way-to-use-docker-compose-to-obtain-and-renew-a-lets-encrypt-ssl-certificate-with-certbot-and-configure-the-nginx-service-to-use-it/). 
1. At first rename `before-cert-creation.conf` to `nginx.conf`. 
2. Start the applications using docker-compose to create a valid certificate.
3. Set environment variables __\$\{EMAIL\}__ and __\$\{DOMAIN\}__ in `.env`-File
4. Rename  `after-cert-creation.conf` to `nginx.conf`. 
5. Rerun the certbot using docker-compose. 

The `nginx.conf` config-file is picked up by docker-compose when recreating the nginx-container with `docker-compose up -d --force-recreate`

Hint:
> If you choose to copy a new nginx.conf into a running container via `docker cp` you need to reload nginx using `docker-compose exec nginx nginx -s reload`.

## Update Process
For most modules updating can be done by changing the images-version tag. Tags of available images can be found at Docker-Hub. If there are errors after updating you will notice services restarting and/or not working. With the tools we use here it is recommended to use a fixed version-tag instead of :latest-tag to avoid unexpected downtime.

If an update requires additional changes (e.g. NUM-Portal introducing new Environment-Variables or Ehrbase requiring changes on DB-Level) you can use `docker-compose logs -f` or `docker-compose logs -f` ${CONTAINERNAME}to identify the cause of those errors in the log.

See Dockerhub for new versions or Github-pages for changes and changelogs.
- [Dockerhub-Postgres](https://hub.docker.com/_/postgres/tags)
- [Dockerhub-NUM-Researchdataplatform](https://hub.docker.com/u/numresearchdataplatform)
- [Dockerhub-EHRBase](https://hub.docker.com/u/ehrbase)

### Automation of updates
Automate Cert-Renewal:
- Configure a cronjob to run [cert-renewal-script](cron_renew_cert.sh)
  - `crontab -e` e.g. 0 3 1 * * /home/username/zlg-platform/cron_renew_cert.sh
  - make sure the file is executable 
    - check via `ls -l <<path>>/cron_renew_cert.sh`
    - change via `chmod +x <<path>>/cron_renew_cert.sh`

You may consider automating other update processes as well.

Automation of the setup-process is a future-TODO.

## (External) Documentation
- [openEHR-Specification](https://specifications.openehr.org)
- [openEHR REST API-Documentation](https://specifications.openehr.org/releases/ITS-REST/Release-1.0.0/ehr.html)
- [EHRBase Documentation](https://ehrbase.readthedocs.io/en/latest/01_release_notes/index.html)
- [EHRBase REST API Documentation](https://c100-115.cloud.gwdg.de/ehrbase/swagger-ui.html)
- [NUM Portal Benutzerhandbuch](https://num-portal-webapp.readthedocs.io/de/latest/)

## License
This documentation is licensed under Creative Commons license [CC-BY-SA 4.0](https://creativecommons.org/licenses/by-sa/4.0/) unless otherwise stated.

![CC-BY-SA 4.0-Logo](cc_by_logo.png)

The tools utlized by the zlg-platform are available at public sources under their respective licenses.
