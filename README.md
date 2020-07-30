# zlg-ehrbase

### Step 1 - Archetyp erstellen (Archetype Editor + CKM)

Name: bloodpressure_m3.v0

Typ: openEHR-EHR-OBSERVATION

Hinzufügen von Attributen / Modellieren des klinischen Konzepts

Dazu noch Observation_Heart Rate, Evaluation_Diagnosis und Composition_encounter



### Step 2 - Template erstellen (Template Editor)

Template mit Composition encounter und den drei archetypen komplett hinzugefügt



### Step 3 - Upload Template to Server (Postman)

View ORBDAset.oet as XML in Template Editor

Copy-Paste



### Step 4 - Generate an example json/xml Composition

Use some tool for that

- https://toolkit.cabolabs.com/app/features   Instance Generator

- EhrBase Client Functions



### Step 5 - Create EHR at the server and get EHRid via SUBJECTid

- create an ehr and get the ehr-id

  - http://141.5.100.99:8080/ehrbase = {{host}} +
  - /rest/openehr/v1                                                +
  - /ehr                                              ist der rest endpoint

- Content:

  {

   "_type": "EHR_STATUS",

   "name": {

    "value": "EHR"

   },

   "subject": {

    "external_ref": {

     "id": {

  ​    "_type": "GENERIC_ID",

  ​    "value": "{{subject_id}}",

  ​    "scheme": "id_scheme"

     },

     "namespace": "{{subject_namespace}}",

     "type": "PERSON"

    }

   },

   "is_modifiable": true,

   "is_queryable": true

  }

- Headers:

  - Content-Type   application/json
  - Accept       \*/*
  - Accept-Encoding      gzip, deflate, br
  - Prefer     return=representation



### Step 6 - Send and "create" Composition at the server usind EHRid

Endpoint: {{ehrUrl}}/ehr/:ehrId/composition?Prefer=return=representation

Params: 

- Prefer              return=representation
- ehrId                {{ehrId}}

See if it works or you get a bad request like i am atm