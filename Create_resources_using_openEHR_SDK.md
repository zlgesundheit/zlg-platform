Intrduction to loading data using the openEHR-SDK

# zlg-ehrbase

### Step 1 - Archetyp erstellen (Ocean Archetype Editor + CKM)

Hinzufügen von Attributen / Modellieren des klinischen Konzepts:

- Composition_Encounter

- Section Vital_Signs

- Observation_Heart Rate, Evaluation_Diagnosis und Observation_Blood Pressure



### Step 2 - Template erstellen (Ocean Template Editor)

1. Template aus den vorhandenen Archetypen erstellt.

2. Export des Templates mit der EXPORT FUNKTION -> FULL OPT not OET

Video wie man den Ocean Template-Editor nutzt: 

https://www.youtube.com/watch?v=B-W5c3qwpFE



### Step 3 - Upload Template to Server (Postman)

Send it

- {{ehrUrl}}/definition/template/adl1.4
- Content-Type application/xml
- Prefer  return=representation
- Body

```xml
FULL OPT XML
```



### (Optional) Step 4 - Generate java classes / entitys for the building of compositions

Use some tool for that

- https://toolkit.cabolabs.com/app/features   Instance Generator

  - Registration does not function....

- EhrBase Client Functions

  - Build it (java version = 11; mvn -version; java 1.8 needed anyway)

  - Generate Entitiy Classes

    - Befehl

      ```
    java -jar generator-0.3.1-SNAPSHOT.jar -opt /mnt/c/Users/richter122/git-projects/zlg-ehrbase/Templates/ORBDAsetV2.opt -out /mnt/c/Users/richter122/git-projects/zlg-ehrbase/Templates/ -package test
      ```
  
  - Have a package with definition-classes ("archetypes") and Composition-Class (composition) to use in your java project.

### Step 4.5 - Setup the RestClient

Hier einfach DefaultRestClientTestHelper gekapert:

- Angabe -> Template-Folder
- Angabe -> Ehrbaseadress

```java
Path templateFolder = Paths.get("C:\\Users\\richter122\\git-projects\\zlg-ehrbase\\Templates\\");
FileBasedTemplateProvider cut = new FileBasedTemplateProvider(templateFolder);
String baseadress = new Ehrbaseadress().getTESTENVGOE();
DefaultRestClient client = new DefaultRestClient(new OpenEhrClientConfig(new URI(baseadress + "/ehrbase/rest/openehr/v1/")), cut);
```

### Step 5 - Build a composition (using java)

- Load the java-composition classes package into your project.

- Start implementing something that is generating an instance of that composition

  - ```java
    public static ORBDAsetV2Composition buildExample() {
        ORBDAsetV2Composition dto = new ORBDAsetV2Composition();
    	//.-.-.-.-.-.-
    }
    ```

- Fill the composition according to its structure

### Step 6 - Send it (openEHR-SDK)

```java
public static void main(String[] args){
    // Setup EhrClient before
    UUID ehr = openEhrClient.ehrEndpoint().createEhr();

    ORBDAsetComposition myComposition = buildExample();
    System.out.println(myComposition);

    CompositionEndpoint compositionEndpoint = openEhrClient.compositionEndpoint(ehr);
    openEhrClient.compositionEndpoint(ehr).mergeCompositionEntity(myComposition);
}
```

### Step 6b - Create EHR at the server and get EHRid via 

### SUBJECTid

- create an ehr and get the ehr-id

  - http://141.5.100.99/ehrbase = {{host}} +
  - /rest/openehr/v1                                                +
  - /ehr                                              ist der rest endpoint

- Content:

  ```json
  {
   "_type": "EHR_STATUS",
   "name": {
    "value": "EHR"
   },
   "subject": {
    "external_ref": {
     "id": {
      "_type": "GENERIC_ID",
      "value": "{{subject_id}}",
      "scheme": "id_scheme"
     },
     "namespace": "{{subject_namespace}}",
     "type": "PERSON"
    }
   },
   "is_modifiable": true,
   "is_queryable": true
  }
  ```
  
  
  
- Headers:

  - Content-Type   application/json
  - Accept       \*/*
  - Accept-Encoding      gzip, deflate, br
  - Prefer     return=representation

### Step 7 - AQL Query: Get the content that is stored on the server to check AND SEE if it has been created

AQL Query POST

- {{ehrUrl}}/query/aql

```
{
    "q": "select distinct a/uid as compId from EHR e contains COMPOSITION a WHERE e/ehr_id/value='c98cd25a-a66c-4485-a641-cb4790e4c2a9'",
    "offset": 0,
    "fetch": 10,
    "query-parameters": {
    
    }
}
```



Oder Abfrage einzelner Abschnitte der Composition

``` AQL
{
    "q": "select a/content[openEHR-EHR-SECTION.vitalsigns_m3.v0] as data from EHR e contains COMPOSITION a[openEHR-EHR-COMPOSITION.encounter.v1] WHERE a/uid/value='bc5b13c1-1c9c-4fbe-b82a-ad7e9bf6038e::local.ehrbase.org::1'",
    "offset": 0,
    "fetch": 10,
    "query-parameters": {
      
    }
}
```

