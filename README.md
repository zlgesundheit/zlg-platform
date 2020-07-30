# zlg-ehrbase

### Step 1 - Archetyp erstellen (Archetype Editor + CKM)

Hinzufügen von Attributen / Modellieren des klinischen Konzepts

Composition_encounter

Section vital signs

Observation_Heart Rate, Evaluation_Diagnosis und   Observation_Blood Pressure



### Step 2 - Template erstellen (Template Editor)

Template mit Composition Encounter und einer Section mit den drei Archetypen komplett hinzugefügt.

Export des Templates mit der EXPORT FUNKTION -> FULL OPT not OET

Video wie man den Template Editor nutzt: 

https://www.youtube.com/watch?v=B-W5c3qwpFE



### Step 3 - Upload Template to Server (Postman)

Send it to 

- {{ehrUrl}}/definition/template/adl1.4
- Content-Type application/xml
- Prefer  return=representation
- Body

```xml
FULL OPT XML
```



### Step 4 - Generate java classes / entitys for the building of compositions

Use some tool for that

- https://toolkit.cabolabs.com/app/features   Instance Generator

  - Registration does not function....

- EhrBase Client Functions

  - Build it (java version = 11; mvn -version; java 1.8 needed anyway)

  - Generate Entitiy Classes

    - Befehl

      java -jar generator-0.3.1-SNAPSHOT.jar -opt /mnt/c/Users/richter122/git-projects/zlg-ehrbase/Templates/ORBDAset.opt -out /mnt/c/Users/richter122/git-projects/zlg-ehrbase/Templates/ -package test

  - Have a package with definition-classes ("archetypes") and Composition-Class (composition) to use in your java project.

### Step 5 - Build a composition using java

- Load the java-composition classes package into your project.

- Start implementing something that is generating an instance of that composition

  - ```java
    public static ORBDAsetComposition buildExample() {
        ORBDAsetComposition dto = new ORBDAsetComposition();
    	//.-.-.-.-.-.-
    }
    ```

- Fill the composition according to its structure

### Step 6 - Send it or print it and send it wo openEHR-SDK

- Einbindung des TemplateProviders in RestClient nötig

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

### Step 7x - Create EHR at the server and get EHRid via 

### SUBJECTid

- create an ehr and get the ehr-id

  - http://141.5.100.99:8080/ehrbase = {{host}} +
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
  ```

  

- Headers:

  - Content-Type   application/json
  - Accept       \*/*
  - Accept-Encoding      gzip, deflate, br
  - Prefer     return=representation



### Step 6 - Send and "create" Composition at the server using EHRid

Endpoint: {{ehrUrl}}/ehr/:ehrId/composition?Prefer=return=representation

Params: 

- Prefer              return=representation
- ehrId                {{ehrId}}

See if it works or you get a bad request like i am atm