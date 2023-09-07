# zlg-platform

## Context
The ZLG is using the [EHRBase](https://github.com/ehrbase/ehrbase) a Clinical Data Repository to store data in an interopable way using the openEHR-Technology Framework.

EHRbase is an openEHR Clinical Data Repository, providing a standard-based backend for interoperable clinical applications. It implements the latest version of the openEHR Reference Model (RM 1.0.4) and version 1.4 of the Archetype Definition Language (ADL). Applications can use the capabilities of EHRbase through the latest version of the openEHR REST API and model-based queries using the Archetype Query Language.

## Usage
You can start each tool via docker-compose in the respective folder (e.g. ehrbase_docker, portal_docker, zlg_docs).

Setting up SSL Encryption using NGINX and LetyEncrypt is a [two step process](https://blog.jarrousse.org/2022/04/09/an-elegant-way-to-use-docker-compose-to-obtain-and-renew-a-lets-encrypt-ssl-certificate-with-certbot-and-configure-the-nginx-service-to-use-it/). You need to use the docker-compose.yml in the main folder of the repo. To create valid certificates use the `before-cert-creation.conf` for nginx first then run the certbot and after that switch to `after-cert-creation.conf` for nginx. Remember to restart nginx after switching configuration files (`docker-compose exec nginx nginx -s reload`).

Tools
- EHRBase Clinical Data Repository (ehrbase_docker)
- NUM Portal (portal_docker)
- ZLG-Documentation (zlg_docs)

For the data import tool "FLAT_Loader" see [this repo of the FLAT_Loader](https://gitlab.gwdg.de/medinfpub/openehr_flat_loader).

## Documentation

Documentation at [docusaurus](https://c100-115.cloud.gwdg.de/docs/)

## Startup

### Alter domain settings in nginx-conf and Create SSL-Cert (once at first start)
- `cp ./nginx/before-cert-creation ./nginx/nginx.conf`  
Change Domain in nginx.conf to your Domain.
- `docker-compose up -d`
- `cp ./nginx/after-cert-creation ./nginx/nginx.conf`  
Change Domain in **nginx.conf** to your Domain.
- `docker-compose up -d --force-recreate nginx`

### Alter Domain-Settings
- Change Domains in **config.deploy.json**
- Change Domain and Mail adress in certbot command in **docker-compose.yml** to your Domain.  

### Alter Domain-Settings in Docs
- Change Domain-Occurences and other relevant linkings (e.g. Gitlab Repo) to match your own Setting.
    - Edit **./docs/zlg-docs/docusaurus.config.js**

## Start all containers  
Define passwords in .env file  
- `docker-compose up -d`

### Init DB for EHRBase
Set password in "./portal_docker/sql/01-ehrbase-cloud-db-setup.sql" according to "EB_DB_PASS" in .env file.
- `docker cp ./portal_docker/sql/01-ehrbase-cloud-db-setup.sql FOLDER_NAME_postgres_1:/docker-entrypoint-initdb.d/dump.sql`
- `docker exec -u postgres FOLDER_NAME_postgres_1 psql postgres postgres -f docker-entrypoint-initdb.d/dump.sql`

Mit Version 24 kam ein restricted-user dazu:   
- `docker cp ./portal_docker/sql/add_restricted_user.sql FOLDER_NAME-postgres-1:/add_restricted_user.sql`  
- `docker exec -u postgres FOLDER_NAME-postgres-1 psql postgres postgres -f add_restricted_user.sql`  

Dies wird später in einem Setup-Skript zusammengefasst (see [EHRBase Update Hints](https://github.com/ehrbase/ehrbase/blob/develop/base/db-setup/createdb.sql)).

### Setup backend-auth
- Visit Keycloak Endpoint at https://DOMAIN/auth
- Generate new secret via **Clients -> num-Portal -> Credentials -> Regenerate Secret**
- Copy Secret in Keycloak and set ${KEYCLOAK_CLIENT_SECRET} in docker-compose.yml
- Recreate num-portal container: `docker-compose up -d --force-recreate num-portal`

### Setup First User
- Visit Frontend on https://DOMAIN/home
- CLick on Login and register a new user at the keycloak
- Visit keycloak admin interface at https://DOMAIN/auth
    - Go to Users -> View all users -> Edit -> Role Mapping -> Assign all roles
    - Go to Users -> View all users -> Edit -> Email Verified = ON -> Save
- Re-log in the Frontend
- Enter the database under schema "num" and in table "user_details" set the user to approved (identified by same id like in keycloak)
    - e.g. expose port of adminer/pg_admin and login to the DB
- Re-log in the Frontend 
- **You should have all rights in the portal now** 

## Update Process
- Ugrade of PG-DB ([see](https://www.postgresql.org/docs/13/upgrading.html))
- Newer [release of NUM Portal](https://github.com/NUM-Forschungsdatenplattform/num-portal-webapp/releases) (ToDo: fork and build own image)
- Updating EHRBase ([see Developer Hints for updating a native EHRBase instance](https://github.com/ehrbase/ehrbase/blob/develop/UPDATING.md#ehrbase-0240)) (ToDo: Test using docker and describe process)
- Automate Cert-Renewal:
  Configure a cronjob to run [cert-renewal-script](cron_renew_cert.sh)

## (External) Documentation
- [openEHR-Specification](https://specifications.openehr.org)
- [openEHR REST API-Documentation](https://specifications.openehr.org/releases/ITS-REST/Release-1.0.0/ehr.html)
- [EHRBase Documentation](https://ehrbase.readthedocs.io/en/latest/01_release_notes/index.html)
- [EHRBase REST API Documentation](https://c100-115.cloud.gwdg.de/ehrbase/swagger-ui.html)
- [NUM Portal Benutzerhandbuch](https://num-portal-webapp.readthedocs.io/de/latest/)
