Test des Portals mit Keycloak und Co.
nach P.Hufeland angepasst von jendrik

docker-compose -f compose.yml up -d


# NUM-Portal Docker-compose
###### tags: `NUM-Portal` `Docker` `Setup`

## Vorbereitung
### Gitlab registry Login
Für das Herunterladen der Docker images aus dem GWDG-Gitlab muss sich zuerst autorisiert werden.

Unter [NUM-Portal-gitlab](https://gitlab.gwdg.de/medinf/kvf/kardio/dzhk/cofoni/num-portal/-/settings/access_tokens) einen Neuen Token mit read_registry rechten erstellen.
Mit den generierten Daten einloggen
docker login -u BENUTZERNAME -p "PASSWORD" docker.gitlab.gwdg.de```

Installation

Docker compose

`docker compose -f compose.yml up -d`
### Postgres Datenbanken initialisieren
Für die Ehrbase muss vorher ein Benutzer und weiteres erstellt werden, die nachfolgenden Befehle laden die SQL Datei in den Container und lad diese in die Postgres Datenbank

:::Added `ALTER DATABASE ehrbase SET intervalstyle TO "iso_8601";` to init-script.

docker cp ./sql/01-ehrbase-cloud-db-setup.sql portal-zlg_postgres_1:/docker-entrypoint-initdb.d/dump.sql
docker exec -u postgres portal-zlg_postgres_1 psql postgres postgres -f docker-entrypoint-initdb.d/dump.sql


### Keycloak einrichten und NUM-Portal secret eintragen
- In der Keycloak [Adminoberfläche](http://localhost:8180/auth/) anmelden

:::Keycloak requires https -> go into container set admin-user and disable ssl
docker exec -it {contaierID} bash
cd keycloak/bin
./kcadm.sh config credentials --server http://localhost:8080/auth --realm master --user admin
./kcadm.sh update realms/master -s sslRequired=NONE

- Einen neuen Realm mit der Konfig-Datei im Ordner keycloak ([Alternativ im Gitlab](https://gitlab.gwdg.de/medinf/kvf/kardio/dzhk/cofoni/cofoni-keycloak/-/blob/master/docker/keycloak-dump.json)) anlegen
- In dem neu anlegeten Realm unter dem Client Num-Portal ein neues Secret generieren
    - Clients -> Num-Portal -> Credentials -> Regenerate Secret
- Das neu generierte Secret in die yml-Datei unter
KEYCLOAK_CLIENT_SECRET:`` eintragen
- NUM-Portal container neuerstellen, damit neue Umgebungsvariablen geladen werden

NUM Webapp starten

- Git repo der WebApp klonen
- Die Datei config.dev.json in den Ordner src\assets\config der WebApp kopieren
- Run ``npm install
- Konfigdatei: src/assets/config/config.dev.json
- Run
ng serve --host 0.0.0.0 --port 4200``
- --disable-host-check
- --public-host URL

WebApp Nutzer anlegen

- Unter http://localhost:4200/ anmelden und einen neuen Benutzer registrieren
- Unter http://localhost:5050/ einen neuen Server hinzufügen, Adresse, Benutzer und Password lauten postgres
- In der Postgres db unter dem Schema num in der Tabelle user_details ein update script erstellen und damit von dem neuen Nutzer den approved status auf true setzen
- ```UPDATE num.user_details SET approved=true;
- In der Keycloak Adminoberfläche unter Users -> View all users -> neuen Nutzer editieren -> Role Mapping -> Alle Rollen zuweisen
- In der Webapp neu anmelden
- Fertig!
