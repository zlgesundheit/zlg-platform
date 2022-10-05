# ETL-Tools

After [modeling concepts](./openehr_details/modelling_and_reviews.md) and [setting up the data repository](./openehr_repository.md) the next thing to do is importing data or integrating the storage solution in other application for data capture or data sources.

With the standardized openEHR-API this is not much of a problem for experienced data transformation agent who know and understand the concepts they are dealing with.

```
Since openEHR is often used in medical settings involving medical concepts and 
interprofessional teams the understandability and maintainability qualifies as a 
core factor for project success. Therefore it should be an important aspect to 
select the right tooling and processes for data integration tasks.
```

---
The basics of using the openEHR-API via REST is briefly described in chapter 7.1.
- [REST Calls and Postman](./etl_tools/rest_calls.md)

---
If you want domain experts (doctors, medical staff, ..) to perform mapping tasks you may consider the FLAT-Loader (Script Collection) that offers Mappings from Source data to Templates in form of an Excel File.  

- [ZLG FLAT-Loader](./etl_tools/flat_loader.md)

> (For the FLAT_Loader we want to implement a graphical user interface or try out the use of [KNIME](https://www.knime.com/getting-started-guide) for more convenient usage in the future)

---
For experienced users with knowledge of ETL-Processes, Programming and the needed models/concepts writing their own scripts is applicable. See the Python Examples using Python and openEHR-FLAT-Format.

- [Plain Python ETL](./etl_tools/plain_python_etl.md)

---
For a Mapping and Resource Creation using a graphical user interface you can check out HaMSTR-Loader from the MHH in Hannover. It is not a finished product but may serve you.

- [HaMSTR-Loader](./etl_tools/hamstr_loader.md)

---
Persons working with a Better Repository might just want to use the Better CSV-Importer that does the same as the HaMSTR-Loader/FLAT-Loader. The user just needs to map the FLAT-Paths of the attributes to the respective columns in his data by renaming the column headers.

- [Better CSV-Importer](./etl_tools/better-import.md)

---
There are other options (i.e. using Java with openEHR-SDK or other tools) but the ones listed above were tested in our work at the Zukunftslabor Gesundheit. See the respective chapters for more detailed information about using these tools.

---
[![Creative Commons Attribution-ShareAlike 4.0 International License](https://i.creativecommons.org/l/by-sa/4.0/88x31.png "Creative Commons Attribution-ShareAlike 4.0 International License")](http://creativecommons.org/licenses/by-sa/4.0/)