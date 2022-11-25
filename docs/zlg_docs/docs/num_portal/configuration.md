---
title: Setup & Configuration
sidebar_position: 2
---

# Configuration

Since the platform consists of multiple components / services that will interact with each other we will have to go through a number of setup steps.

There are official docker images for the NUM CODEX platform at the [NUM Docker Repo](https://hub.docker.com/u/numresearchdataplatform). However for your own instance it might be suitable to clone the repos at [Github](https://github.com/num-forschungsdatenplattform) and adapt the platform to your needs (Logos, Texts, Configs). To test and see the platform just use the pre-built images.

## 7 Steps to have containers up and first user configured

**1. Get the Repo**
- Clone the zlg-platform repo from Gitlab.

After you downloaded all files and folders you have to decide which services you want to start. You can start the whole platform (EHRBase, NUMPortal, Documentation) or just start some parts by entering the respective folders.

- Pull the needed docker-images / login to docker.  
> At this point the ZLG version of the NUM Portal is not final.  
> How to access / build the images needs to be concretized at a later point in time.

---
**2. Prepare the server**  

- Manage the ports that are needed to setup the platform

|Service|Port|Endpoint|
|:-------:|:----:|--------|
|num-portal-webapp|80 tcp|/|
|num-portal|8090 tcp|/|
|keycloak|8443 tcp|/auth|
|ehrbase|8080 tcp|/ehhrbase|
|nginx|80,443|/|
|adminer|5050 tcp|/|
|postgres|-|-|

- Locations of hard-coded domain entries (or mail-adresses)

|Service|Location|Line(s)|
|:-------:|:----:|----|
|NUM WebApp|config.deploy.json|'api/baseUrl', 'auth/baseUrl'|
|NGINX|nginx/nginx.conf|'server_name', 'proxy_ssl_name', 'ssl_certificate', 'ssl_certificate_key'
|Certbot|docker-compose.yml|'command'|

- Passwords are stored in .env-File (available as .env-example_rename)

---
**3. Start the service containers**

- Start the containers via docker-compose  

    `docker-compose up -d`

---
**4. Initialize the database**

- Copy the init-file into the postgres container and execute it inside the container

    `docker cp ./sql/01-ehrbase-cloud-db-setup.sql CONTAINER_NAME:/docker-entrypoint-initdb.d/dump.sql`

    `docker exec -u PG_USERNAME CONTAINER_NAME psql PG_USERNAME DATABASE_NAME -f docker-entrypoint-initdb.d/dump.sql`

> The sql-init script contains a line with a password for the ehrbase-user. Since these services will communicate later the password needs to match the password defined in the docker-compose for the EHRBase-DB-User.

---
**5. Setup KeyCloak and get Client Secret**

- Login at the KeyCloak Admin Interface at  

    `https://IP_or_DOMAIN:8443/auth/`

- Create a new realm with the provided keycloak-dump.json.
- Navigate to the secret generation and generate a new secret.

    `Clients -> num-portal -> Credentials -> Regenerate Secret`

- In the .env file that will be used in the docker-compose set the generated secret.

    ENV-Variable: `KEYCLOAK_CLIENT_SECRET`

- Also set the external ip of the keycloak server. 

    ENV-Variable: `KEYCLOAK_CANONICAL_URL: https//IP_or_DOMAIN:8443`

- Restart the num-portal for the changes to take effect.

    `docker-compose up -d num-portal`

---
**6. Configure your first user**

- Access the webapp in your browser.

    `http://IP_or_DOMAIN:80`

- Register a user at the keycloak login-interface.
- After you logged in you need to go to the KeyCloak-Admin Interface and alter the user.

    Go to  
    `"User" -> "View all users" -> "Edit User" -> "Role Mapping" -> Assign all roles`
    
    Also at  
    `"Users" -> "View all users" -> "Edit User" -> Turn "Email Verified" to "ON" -> Save`

- To enable the user in the num portal alter the user in the pg-db.

    - Access Adminer at 
    
        `http://IP_or_DOMAIN:5050`

    - Log into the postgres-db. You may use the PG_CONTAINER_NAME or find the ip of the postgres-db via 
    
        `docker network inspect portal_docker_ehrbase-net`.

    - Under the scheme "num" in the table "user_details" find your user id (matching the KeyCloak User ID) and alter the "approved" status.

        `UPDATE num.user_details SET approved=true;`

---
**7. Relog and finish configuration of first user**

- Relog in the WebApp.

---
## Setup SSL for the platform (needed to avoid CORS related errors)

An SSL-Certificate can be acquired using [Certbot](https://certbot.eff.org). The needed Container is already included in the docker-compose.yml.

`command: certonly --webroot -w /var/www/certbot --force-renewal --email MAIL-ADRESS -d DOMAIN --agree-tos`

If you are actively setting up and testing - and therefore starting and restarting services often - you can set the '--test-cert'-Flag for testing with massively increased rate limits.

---
[![Creative Commons Attribution-ShareAlike 4.0 International License](https://i.creativecommons.org/l/by-sa/4.0/88x31.png "Creative Commons Attribution-ShareAlike 4.0 International License")](http://creativecommons.org/licenses/by-sa/4.0/)