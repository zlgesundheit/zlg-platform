# zlg-ehrbase

## Context
The ZLG is using the [EHRBase](https://github.com/ehrbase/ehrbase) a Clinical Data Repository to store data in an interopable way using the openEHR-Technology Framework.

EHRbase is an openEHR Clinical Data Repository, providing a standard-based backend for interoperable clinical applications. It implements the latest version of the openEHR Reference Model (RM 1.0.4) and version 1.4 of the Archetype Definition Language (ADL). Applications can use the capabilities of EHRbase through the latest version of the openEHR REST API and model-based queries using the Archetype Query Language.

## Usage
You can start each tool via docker-compose in the respective folder (e.g. ehrbase_docker, portal_docker, zlg_docs).

To start the tools alltogether with SSL Encryption via NGINX you need to use the docker-compose.yml in the main folder of the repo. To create valid certificates use the `before-cert-creation.conf` for nginx first then run the certbot and after that switch to `after-cert-creation.conf` for nginx. Remember to restart nginx after switching configuration files.

Tools
- EHRBase Clinical Data Repository (ehrbase_docker)
- NUM Portal (portal_docker)
- ZLG-Documentation (zlg_docs)

For the data import tool "FLAT_Loader" see [this repo of the FLAT_Loader](https://gitlab.gwdg.de/medinfpub/openehr_flat_loader).

## (External) Documentation
- [openEHR-Specification](https://specifications.openehr.org)
- [openEHR REST API-Documentation](https://specifications.openehr.org/releases/ITS-REST/Release-1.0.0/ehr.html)
- [EHRBase Documentation](https://ehrbase.readthedocs.io/en/latest/01_release_notes/index.html)
- [EHRBase REST API Documentation](http://141.5.100.115/ehrbase/swagger-ui.html)