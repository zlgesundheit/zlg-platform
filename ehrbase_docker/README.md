EHRBase original repo can be found here https://github.com/ehrbase/ehrbase  

EHRBase ist currently running in version 0.20.0 and is constantly updated.
At the moment i am tracking some issues and findings about the ehrbase-environment here: https://pad.gwdg.de/uSeuJQ82R5mstpexESQtig?both  
There is a client library written in java, that is meant to communicate with openEHR-Servers. Name: openEHR_SDK

The environmental variables of the server are located in .env.ehrbase -> this .env-File is used in the docker-compose.yml

"Prod"-Instance is running on .115-Cloud-Server
Swagger API: http://141.5.100.115/ehrbase/swagger-ui.html

Default-Auth:
ehrbase-user:SuperSecretPassword
