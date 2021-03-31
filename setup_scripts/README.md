## To run the setup_scripts run the following command:

```docker-compose build && docker-compose run zlg_setup_scripts http://141.5.100.99:8080/ehrbase ehrbase-user SuperSecretPassword```

1. Argument baseadress
2. Argument username
3. Argument password

----
## With the Setup-Scripts we aim to:
1. Upload all Templates from "opts"-Folder to the openEHR-Server
2. Make "opts", "data" and "mapping" Folders accessible for the Java openEHRSDK-Client in Tomcat Webserver (??->Copy them into the project before building with maven?)
3. Run generator.jar on the templates and store files in "classes"-Folder -> Copy classes to webserver-project to include them in the build process
4. Prepare and build .war-File from maven-project in "webserver-project/..." (run maven clean install to get .war-file then use .war file for deployment in Tomcat Docker)

---
Planned:
Docker 1: Setup Skripte (Upload OPTs, generate classes and mvn build)
Docker 2: Tomcat Server
Docker 3: EHRBase

