---
title: EHRBase Setup
sidebar_position: 2
---

# Configuration
The following configuration was used in the Zukunftslabor Gesundheit. The EHRBase version at that time was v0.21.1 by 18th May 2022.

#### Docker
With the help of a [Docker-Compose](https://docs.docker.com/compose/) file, various Docker containers can be set up, harmonized and started. Code management and helpful ReadMe files can be found in the [EHRBase Documentation](https://ehrbase.readthedocs.io/en/latest/03_development/04_docker_images/01_ehrbase/02_use_image/index.html#run-ehrbase-db-with-docker-compose). 

The Docker images relevant for the basic functions are:
- [ehrbase/ehrbase](https://hub.docker.com/r/ehrbase/ehrbase)
- [ehrbase/ehrbase-postgres](https://hub.docker.com/r/ehrbase/ehrbase-postgres)

Depending on the local infrastructure or special requirements, it may be useful to include a proxy server or for example an OAuth authentication server. 

In the following Docker Compose file, the two containers mentioned above are started based on the official images publicly available on Docker Hub and customized by setting environment variables.

#### Network
The linking of ehrbase and ehrbase-postgres database is done via a shared network and the specification of the DB_URL as well as the depositing of the database user's credentials. Via a port mapping the ehrbase will be available at port 80 after startup.

#### Authentication
Setting the environment variable SECURITY_AUTHTYPE = BASIC activates the authentication of the server for all resources. It is recommended to change the default values entered for AUTH_USER and AUTH_PASSWORD before productive use.

The Default-Auth Information is:
- ehrbase-user:SuperSecretPassword

#### Persistence
Database persistence is achieved by mapping the corresponding Postgres folder to a Docker volume.

## Compose File (docker-compose.yml)

```yml
version: '3'

services:
  ehrbase:
    image: ehrbase/ehrbase:latest
    ports:
      - 80:8080
    networks:
      - ehrbase-net
    env_file:
      - .env.ehrbase
    environment:
      DB_URL: jdbc:postgresql://ehrdb:5432/ehrbase
      DB_USER: ehrbase-username
      DB_PASS: ehrbase-password
    restart: always

  ehrdb:
    image: ehrbase/ehrbase-postgres:latest
    ports:
      - 5432:5432
    networks:
      - ehrbase-net
    volumes:
      - ./.pgdata:/var/lib/postgresql/data
    environment:
      POSTGRES_USER: postgres-username
      POSTGRES_PASSWORD: postgres-password
      EHRBASE_USER: ehrbase-username
      EHRBASE_PASSWORD: ehrbase-password
    restart: always

networks:
  ehrbase-net: {}
```

## Environment Variables (.env.ehrbase)
```yml
SYSTEM_NAME=local.ehrbase.org
SECURITY_AUTHTYPE=BASIC
SECURITY_AUTHUSER=ehrbase-user
SECURITY_AUTHPASSWORD=SuperSecretPassword
SECURITY_AUTHADMINUSER=ehrbase-admin
SECURITY_AUTHADMINPASSWORD=EvenMoreSecretPassword
MANAGEMENT_ENDPOINTS_WEB_EXPOSURE=env,health,info,metrics,prometheus
MANAGEMENT_ENDPOINTS_WEB_BASEPATH=/status
MANAGEMENT_ENDPOINT_ENV_ENABLED=false
MANAGEMENT_ENDPOINT_HEALTH_ENABLED=false
MANAGEMENT_ENDPOINT_HEALTH_DATASOURCE_ENABLED=false
MANAGEMENT_ENDPOINT_INFO_ENABLED=false
MANAGEMENT_ENDPOINT_METRICS_ENABLED=false
MANAGEMENT_ENDPOINT_PROMETHEUS_ENABLED=false
MANAGEMENT_ENDPOINT_HEALTH_PROBES_ENABLED=false
ADMINAPI_ACTIVE=true
ADMINAPI_ALLOWDELETEALL=true
#AUTH_USER=ehrbase-user
#AUTH_PASSWORD=SuperSecretPassword
#SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_ISSUERURI=
```

## Communicating with the openEHR Repository

Once started the EHRBase Repository takes REST-Calls defined in the [openEHR REST-API Standard](https://specifications.openehr.org/releases/ITS-REST/latest/ehr.html) in the specification.

With the Header "Prefer: return={representation|minimal}" the server will return the representation of the resource and will i.e return the ehr_id of a created EHR.

See more info about communicating with the openEHR Repo in the ETL-Tools Section under "[REST Calls and Postman](../etl_tools/rest_calls/rest_calls.md)".

---
[![Creative Commons Attribution-ShareAlike 4.0 International License](https://i.creativecommons.org/l/by-sa/4.0/88x31.png "Creative Commons Attribution-ShareAlike 4.0 International License")](http://creativecommons.org/licenses/by-sa/4.0/)
