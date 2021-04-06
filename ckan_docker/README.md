## About CKAN
CKAN is the world’s leading open-source data portal platform. CKAN makes it easy to publish, share and work with data. It's a data management system that provides a powerful platform for cataloging, storing and accessing datasets with a rich front-end, full API (for both data and catalog), visualization tools and more. Read more at ckan.org.

## ZLG-Context
In the Zukunftslabor Gesundheit Environment we utilize CKAN as a data portal to manage data sets that are stored in the ZLG-Platform.  

While ehrbase and etl-pipelines are run locally to get data into the openEHR-World / into the openEHR-Format  
the CKAN-Instance might be run centralized in the longterm to give an overview over the different datasets that exist at the partner sites in the ZLG Verbundprojekt!

## CKAN-Docs
- [Build CKAN with Docker Compose](https://docs.ckan.org/en/2.9/maintaining/installing/install-from-docker-compose.html)
- [CKAN-API Guide to interact with the instance from the ETL-Processes](https://docs.ckan.org/en/2.9/api/#uploading-a-new-version-of-a-resource-file)
(ETL is run by scripts/zlg-webserver/zlg-api)
- [CKAN@Github](https://github.com/ckan/ckan)
- [CKAN Docker-Repo WIP](https://github.com/ckan/ckan-docker)

## Further
- setup a centralized user management like keycloak
- link ckan to user management
- setup nginx in front of the whole zlg-environment
