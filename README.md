# zlg-ehrbase - Branch: zl-prod

## Kontext
This Branch contains all assets to start up an [EHRBase Server](https://github.com/ehrbase/ehrbase) using [Docker](https://www.docker.com/get-started).

EHRbase is an openEHR Clinical Data Repository, providing a standard-based backend for interoperable clinical applications. It implements the latest version of the openEHR Reference Model (RM 1.0.4) and version 1.4 of the Archetype Definition Language (ADL). Applications can use the capabilities of EHRbase through the latest version of the openEHR REST API and model-based queries using the Archetype Query Language.
See the [EHRBase Documentation](https://ehrbase.readthedocs.io/en/latest/).

The servers base adress is `<IP>/ehrbase`.  
The EHRBase [REST API](/ehrbase/swagger-ui.html#/) is available after server start.  
The OpenEHR-Specification also offers an overview of the [OpenEHR REST API](https://specifications.openehr.org/releases/ITS-REST/Release-1.0.0/ehr.html).

## Preparation Steps

### Add Templates on Startup
Templates need to be present to store data (openEHR resources) that are compliant with the Template.
1. Place Templates as Operational Template (.opt) or WEbtemplate (.json)


Skript das beim Startup ausgeführt wird entweder in Dockerfile (oder Docker-Compose?)
//TODO

### Add Templates after Startup
Skript für den Upload (CURL + OPT und WEBTEMPLATE)
//TODO

## Startup
start both containers detached, without blocking the terminal
`docker-compose up -d`


