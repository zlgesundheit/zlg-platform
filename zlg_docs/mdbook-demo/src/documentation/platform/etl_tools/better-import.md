# Better - CSV-Importer

The Better openEHR-Repository/EhrScape is a commercial software solution made by Better. Better was one of the earliest commercial vendors in the openEHR-Field and also did great work towards the further development of the Standard. The CSV-Importer is basically providing the same functionality like the FLAT-Loader - just built-in in the Repository.

If you are communicating with a Better openEHR-Repository you are able to use the `/import`-REST-Endpoint of the Better REST API. This REST API should not be confused with the openEHR REST API since it offers more valuable functionality and differs from the Standard openEHR REST API. If you try to use Code, AQLs and more from persons who developed against a Better Repo you should expect some derivating behaviour and problems when trying to use these artefacts to communicate with for example a EHRBase Repository.

**Endpoint:**
> `https://rest.ehrscape.com/rest/v1/import/csv`
> Content-Type: JSON/XML

**Parameters:**   
(from [EhrScape API Explorer](https://www.ehrscape.com/api-explorer.html))

| Parameter   |  Description | Parameter Type | Data Type |
|------------|:-------------|:--------------:|:---------:|
| templateId  |  Template ID | string |query|
| templateLanguage |    Template Language   |   string |query|
| optional parameters|Other Parameters for Namespace or Composer Info|	string |query|
| csv | Data File ||body|

**Important Notes:**  
(from [EhrScape API Explorer](https://www.ehrscape.com/api-explorer.html))

Data needs to be properly formatted as CSV. The first row needs to contain column names which must match ids (paths) from web template - specified by query parameter templateId.

---
**Warning**  
The column names must match the paths from the Web-Template. These are not the standard AQL-Paths/canonical Paths. Required are the FLAT-Paths, which may look like this:  

```
> vital_signs/body_temperature/any_event/temperature|magnitude vital_signs/  
> body_temperature/any_event/temperature|unit
```

Find more information about the FLAT-Format [here](https://ehrbase.readthedocs.io/en/latest/02_getting_started/05_load_data/index.html#flat-format).

To query an example composition of a Template in FLAT-Format see [Template-Example Endpoint](https://www.ehrscape.com/api-explorer.html).

> `https://rest.ehrscape.com/rest/v1/template/{templateId}/example`

---
EHR matching is possible in 2 ways:
> a column 'ehrId' is present in which case data is added to existing EHRs  
> a column 'subjectId' is present in which case new EHRs will be created as required (in this case query parameter subjectNamespace is mandatory)  

Result will be returned as a CSV file as well with 3 additional columns:

> "compositionUid" - if not empty, row was successfully imported  
> "errors" - if not empty, row was not imported and the message is the reason for the failure  
> "ehrId"

The processing is done asynchronously and responses streamed back to the client, so any request that is not obviously wrong (which will produce a HTTP status 400) will get accepted (HTTP status 202). Partial successes are possible, and the response will contain error descriptions indicating which rows were not imported (if error column is empty, the import of that row was successful).

---
[![Creative Commons Attribution-ShareAlike 4.0 International License](https://i.creativecommons.org/l/by-sa/4.0/88x31.png "Creative Commons Attribution-ShareAlike 4.0 International License")](http://creativecommons.org/licenses/by-sa/4.0/)