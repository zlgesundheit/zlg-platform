# NUM-Portal-ZLG

Code, Adaption and Development and CI/CD for docker image for a NUM-Portal version for as a ZLG platform tool

=== Offizielles Image  
- https://hub.docker.com/r/numresearchdataplatform/num-portal

=== Die COFONI bzw. ZLG-Version enthalten Anpassungen und verbesserte Usability
- https://gitlab.gwdg.de/medinf/kvf/kardio/dzhk/cofoni
- https://gitlab.gwdg.de/medinf/ivf/zukunftslabor-gesundheit/num-portal-for-zlg

=== Pull NUM-Portal Image from Gitlab  
Unter [NUMPortal_ZLG](https://gitlab.gwdg.de/medinf/ivf/zukunftslabor-gesundheit/num-portal-for-zlg/-/settings/access_tokens) einen neuen Token mit read_registry rechten erstellen.

Mit den generierten Daten einloggen  
`docker login -u BENUTZERNAME -p "PASSWORD" docker.gitlab.gwdg.de`

=== Startup Docker
docker-compose -f compose.yml up -d

=== Have Ports 80 and 8090 (num-portal), 8443 (keycloak) available from the outer world

=== Initialize DB
Für die Ehrbase muss vorher ein Benutzer und weiteres erstellt werden, die nachfolgenden Befehle laden die SQL Datei in den Container und lad diese in die Postgres Datenbank

`docker cp ./sql/01-ehrbase-cloud-db-setup.sql portal_docker_postgres_1:/docker-entrypoint-initdb.d/dump.sql`  
`docker exec -u postgres portal_docker_postgres_1 psql postgres postgres -f docker-entrypoint-initdb.d/dump.sql`

=== Setup KeyCloak and get CLientSecret
- In der Keycloak [Adminoberfläche](http://1141.5.100.99:8443/auth/) anmelden
- Einen neuen Realm mit der Konfig-Datei im Ordner keycloak ([Alternativ im Gitlab](https://gitlab.gwdg.de/medinf/kvf/kardio/dzhk/cofoni/cofoni-keycloak/-/blob/master/docker/keycloak-dump.json)) anlegen
- In dem neu anlegeten Realm unter dem Client Num-Portal ein neues Secret generieren
    - **Clients -> num-Portal -> Credentials -> Regenerate Secret**
- Das neu generierte Secret in die yml-Datei unter 
`KEYCLOAK_CLIENT_SECRET:` eintragen
- Die externe IP des Keycloak-Servers angeben: `KEYCLOAK_CANONICAL_URL: http://141.5.100.99:8443` (oder 8080)
  - NUM-Portal container NEUERSTELLEN, damit neue Umgebungsvariablen geladen werden (`docker-compose up -d num-portal`)

- Falls ein HTTPS-Fehler auftritt:  
`docker exec -it portal-zlg_portal-keycloak_1 bash`  
`cd opt/jboss/keycloak/bin/`  
`./kcadm.sh config credentials --server http://localhost:8080/auth --realm master --user admin`  
`./kcadm.sh update realms/crr -s sslRequired=NONE` <-- CRR Realm, kann erst deaktiviert werden, wenn CRR erstellt wurde
`./kcadm.sh update realms/master -s sslRequired=NONE`  <--Master-Real
  - Restart Server

=== NUM Webapp starten --> Inzwischen gedockert

- Git repo der WebApp klonen
- In config.dev.json URL des Backends und Keycloak angeben
- Die Datei config.dev.json in den Ordner src\assets\config der WebApp kopieren
- Run ``npm install
- Konfigdatei: src/assets/config/config.dev.json --> Für docker-compose: /usr/share/nginx/html/assets/config
- Run 
ng serve --host 0.0.0.0 --port 4200``
- --disable-host-check
- --public-host URL

=== WebApp Nutzer anlegen

- Unter http://localhost:80/ in der Webapp anmelden und einen neuen Benutzer registrieren

- In der Keycloak Adminoberfläche unter Users -> View all users -> neuen Nutzer editieren -> Role Mapping -> Alle Rollen zuweisen
- In der Keycloak Adminoberfläche unter Users -> View all users -> neuen Nutzer editieren -> Email Verified = ON -> Save (Not working sometimes, try pgadmin/adminer way below or wait some time (after relogging) in the webapp for the user settings to update)
ODER
> - Unter http://localhost:5050/ in pgAdmin einen neuen Server hinzufügen (Check IP des Postgres-Containers per Docker inpect -> Netzwerk db-net), Adresse, Benutzer und Password lauten postgres
> - In der Postgres db unter dem Schema "num" in der Tabelle "user_details" ein update script erstellen und damit von dem neuen Nutzer den approved status auf true setzen `UPDATE num.user_details SET approved=true;`

- In der Webapp neu anmelden
- Fertig!

=== Datei: compose.yml (Beispiel-Passwörter)
```
version: '3'

volumes:
  postgres_data:
      driver: local

services:
  portal-keycloak:
      image: jboss/keycloak:15.0.2
      environment:
        KEYCLOAK_USER: admin
        KEYCLOAK_PASSWORD: qwe321
        DB_VENDOR: h2
      networks:
        - ehrbase-net
      ports:
        - 8180:8080
      #restart: on-failure

  postgres:
      image: postgres
      environment:
        POSTGRES_PASSWORD: postgres
      volumes:
        - ./.pgdata:/var/lib/postgresql/data
      networks:
        - ehrbase-net
        - db-net
      ports:
        - 5432:5432

  portal-pgadmin:
    container_name: pgadmin4
    image: dpage/pgadmin4
    restart: always
    environment:
      PGADMIN_DEFAULT_EMAIL: admin@admin.de
      PGADMIN_DEFAULT_PASSWORD: admin
    networks:
        - db-net
    ports:
        - 5050:80

  portal-ehrbase:
    image: ehrbase/ehrbase:latest
    ports:
      - 8080:8080
    networks:
      - ehrbase-net
    env_file:
      - .env.ehrbase
    environment:
      DB_URL: jdbc:postgresql://postgres:5432/ehrbase
      DB_USER: ehrbase
      DB_PASS: EhrbasePassword
    depends_on:
      - postgres
    restart: on-failure

networks:
  ehrbase-net: {}
  db-net: {}
```

=== Datei: .env.ehrbase (Beispiel-Passwort auszutauschen bei Inbetriebnahme)
```
SERVER_NODENAME=local.ehrbase.org
SECURITY_AUTHTYPE=BASIC
SECURITY_AUTHUSER=ehrbase-user
SECURITY_AUTHPASSWORD=SuperSecretPassword
SECURITY_AUTHADMINUSER=ehrbase-admin
SECURITY_AUTHADMINPASSWORD=EvenMoreSecretPassword
SECURITY_OAUTH2USERROLE=USER
SECURITY_OAUTH2ADMINROLE=ADMIN
SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_ISSUERURI=
MANAGEMENT_ENDPOINTS_WEB_EXPOSURE=env,health,info,metrics,prometheus
MANAGEMENT_ENDPOINTS_WEB_BASEPATH=/management
MANAGEMENT_ENDPOINT_ENV_ENABLED=false
MANAGEMENT_ENDPOINT_HEALTH_ENABLED=false
MANAGEMENT_ENDPOINT_HEALTH_DATASOURCE_ENABLED=false
MANAGEMENT_ENDPOINT_INFO_ENABLED=false
MANAGEMENT_ENDPOINT_METRICS_ENABLED=false
MANAGEMENT_ENDPOINT_PROMETHEUS_ENABLED=false
MANAGEMENT_ENDPOINT_HEALTH_PROBES_ENABLED=false
```

=== Datei: InitDB-Script (Beispiel-Passwörter)
```
-- Use this script following the creation and *migrations* of ehrbase db for CLOUD deployment
-- Since most cloud service providers (AWS, AZURE, Digital Ocean) support managed PostgreSQL server instances
-- they generally don't support current extensions: temporal_tables and jsquery (as of 23/09/2019).
-- create database and roles (you might see an error here, these can be ignored)
-- the first section of the script is similar to createdb.sql
-- See README for more details re required application configuration

CREATE ROLE ehrbase WITH LOGIN PASSWORD 'EhrbasePassword';
CREATE DATABASE ehrbase ENCODING 'UTF-8' TEMPLATE template0;
GRANT ALL PRIVILEGES ON DATABASE ehrbase TO ehrbase;

-- install the extensions
\c ehrbase
CREATE SCHEMA IF NOT EXISTS ehr AUTHORIZATION ehrbase;
CREATE SCHEMA IF NOT EXISTS ext AUTHORIZATION ehrbase;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp" SCHEMA ext;
CREATE EXTENSION IF NOT EXISTS "ltree" SCHEMA ext;

-- setup the search_patch so the extensions can be found
ALTER DATABASE ehrbase SET search_path TO "$user",public,ext;
ALTER DATABASE ehrbase SET intervalstyle TO "iso_8601";
GRANT ALL ON ALL FUNCTIONS IN SCHEMA ext TO ehrbase;

-- load the temporal_tables PLPG/SQL functions to emulate the coded extension
CREATE OR REPLACE FUNCTION ext.versioning()
RETURNS TRIGGER AS $$
DECLARE
sys_period text;
history_table text;
manipulate jsonb;
commonColumns text[];
time_stamp_to_use timestamptz := current_timestamp;
range_lower timestamptz;
transaction_info txid_snapshot;
existing_range tstzrange;
holder record;
holder2 record;
pg_version integer;
BEGIN
-- version 0.2.0

IF TG_WHEN != 'BEFORE' OR TG_LEVEL != 'ROW' THEN
RAISE TRIGGER_PROTOCOL_VIOLATED USING
MESSAGE = 'function "versioning" must be fired BEFORE ROW';
END IF;

IF TG_OP != 'INSERT' AND TG_OP != 'UPDATE' AND TG_OP != 'DELETE' THEN
RAISE TRIGGER_PROTOCOL_VIOLATED USING
MESSAGE = 'function "versioning" must be fired for INSERT or UPDATE or DELETE';
END IF;

IF TG_NARGS != 3 THEN
RAISE INVALID_PARAMETER_VALUE USING
MESSAGE = 'wrong number of parameters for function "versioning"',
HINT = 'expected 3 parameters but got ' || TG_NARGS;
END IF;

sys_period := TG_ARGV[0];
history_table := TG_ARGV[1];

-- check if sys_period exists on original table
SELECT atttypid, attndims INTO holder FROM pg_attribute WHERE attrelid = TG_RELID AND attname = sys_period AND NOT attisdropped;
IF NOT FOUND THEN
RAISE 'column "%" of relation "%" does not exist', sys_period, TG_TABLE_NAME USING
ERRCODE = 'undefined_column';
END IF;
IF holder.atttypid != to_regtype('tstzrange') THEN
IF holder.attndims > 0 THEN
RAISE 'system period column "%" of relation "%" is not a range but an array', sys_period, TG_TABLE_NAME USING
ERRCODE = 'datatype_mismatch';
END IF;

SELECT rngsubtype INTO holder2 FROM pg_range WHERE rngtypid = holder.atttypid;
IF FOUND THEN
RAISE 'system period column "%" of relation "%" is not a range of timestamp with timezone but of type %', sys_period, TG_TABLE_NAME, format_type(holder2.rngsubtype, null) USING
ERRCODE = 'datatype_mismatch';
END IF;

RAISE 'system period column "%" of relation "%" is not a range but type %', sys_period, TG_TABLE_NAME, format_type(holder.atttypid, null) USING
ERRCODE = 'datatype_mismatch';
END IF;

IF TG_OP = 'UPDATE' OR TG_OP = 'DELETE' THEN
-- Ignore rows already modified in this transaction
transaction_info := txid_current_snapshot();
IF OLD.xmin::text >= (txid_snapshot_xmin(transaction_info) % (2^32)::bigint)::text
AND OLD.xmin::text <= (txid_snapshot_xmax(transaction_info) % (2^32)::bigint)::text THEN
IF TG_OP = 'DELETE' THEN
RETURN OLD;
END IF;

RETURN NEW;
END IF;

SELECT current_setting('server_version_num')::integer
INTO pg_version;

-- to support postgres < 9.6
IF pg_version < 90600 THEN
-- check if history table exits
IF to_regclass(history_table::cstring) IS NULL THEN
RAISE 'relation "%" does not exist', history_table;
END IF;
ELSE
IF to_regclass(history_table) IS NULL THEN
RAISE 'relation "%" does not exist', history_table;
END IF;
END IF;

-- check if history table has sys_period
IF NOT EXISTS(SELECT * FROM pg_attribute WHERE attrelid = history_table::regclass AND attname = sys_period AND NOT attisdropped) THEN
RAISE 'history relation "%" does not contain system period column "%"', history_table, sys_period USING
HINT = 'history relation must contain system period column with the same name and data type as the versioned one';
END IF;

EXECUTE format('SELECT $1.%I', sys_period) USING OLD INTO existing_range;

IF existing_range IS NULL THEN
RAISE 'system period column "%" of relation "%" must not be null', sys_period, TG_TABLE_NAME USING
ERRCODE = 'null_value_not_allowed';
END IF;

IF isempty(existing_range) OR NOT upper_inf(existing_range) THEN
RAISE 'system period column "%" of relation "%" contains invalid value', sys_period, TG_TABLE_NAME USING
ERRCODE = 'data_exception',
DETAIL = 'valid ranges must be non-empty and unbounded on the high side';
END IF;

IF TG_ARGV[2] = 'true' THEN
-- mitigate update conflicts
range_lower := lower(existing_range);
IF range_lower >= time_stamp_to_use THEN
time_stamp_to_use := range_lower + interval '1 microseconds';
END IF;
END IF;

WITH history AS
(SELECT attname, atttypid
FROM   pg_attribute
WHERE  attrelid = history_table::regclass
AND    attnum > 0
AND    NOT attisdropped),
main AS
(SELECT attname, atttypid
FROM   pg_attribute
WHERE  attrelid = TG_RELID
AND    attnum > 0
AND    NOT attisdropped)
SELECT
history.attname AS history_name,
main.attname AS main_name,
history.atttypid AS history_type,
main.atttypid AS main_type
INTO holder
FROM history
INNER JOIN main
ON history.attname = main.attname
WHERE
history.atttypid != main.atttypid;

IF FOUND THEN
RAISE 'column "%" of relation "%" is of type % but column "%" of history relation "%" is of type %',
holder.main_name, TG_TABLE_NAME, format_type(holder.main_type, null), holder.history_name, history_table, format_type(holder.history_type, null)
USING ERRCODE = 'datatype_mismatch';
END IF;

WITH history AS
(SELECT attname
FROM   pg_attribute
WHERE  attrelid = history_table::regclass
AND    attnum > 0
AND    NOT attisdropped),
main AS
(SELECT attname
FROM   pg_attribute
WHERE  attrelid = TG_RELID
AND    attnum > 0
AND    NOT attisdropped)
SELECT array_agg(quote_ident(history.attname)) INTO commonColumns
FROM history
INNER JOIN main
ON history.attname = main.attname
AND history.attname != sys_period;

EXECUTE ('INSERT INTO ' ||
CASE split_part(history_table, '.', 2)
WHEN '' THEN
quote_ident(history_table)
ELSE
quote_ident(split_part(history_table, '.', 1)) || '.' || quote_ident(split_part(history_table, '.', 2))
END ||
'(' ||
array_to_string(commonColumns , ',') ||
',' ||
quote_ident(sys_period) ||
') VALUES ($1.' ||
array_to_string(commonColumns, ',$1.') ||
',tstzrange($2, $3, ''[)''))')
USING OLD, range_lower, time_stamp_to_use;
END IF;

IF TG_OP = 'UPDATE' OR TG_OP = 'INSERT' THEN
manipulate := jsonb_set('{}'::jsonb, ('{' || sys_period || '}')::text[], to_jsonb(tstzrange(time_stamp_to_use, null, '[)')));

RETURN jsonb_populate_record(NEW, manipulate);
END IF;

RETURN OLD;
END;
$$ LANGUAGE plpgsql;
```
