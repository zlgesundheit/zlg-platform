---
title: Plain Python ETL
sidebar_position: 1
---

# Plain Python ETL

Using the GUI + SQL-Query Variant (see [HAMSTR-ETL-Builder](../etl_tools/hamstr_loader.md)) or the Mapping in an Excel-File (see [FLAT_Loader](../etl_tools/flat_loader.md)) is an intersting way to let persons supply mapping information and to automate the composition building process.

Nevertheless sometimes it is nice to straight forward build FLAT-Compositions without much overhead. The following lays out an easy way to build those.  

## Basic Idea
- All communication is done via REST.  
- As long as you have a subjectID you can request the ehrID of the patient.  
- To upload information you can use the FLAT-Format that is easy to use. Get an Example Composition and fill in the data that you need.

With these basic steps you should be able to perform all needed communication with the EHRBase.

## Process

1. Query an Example-Composition for your Template from the Repository
2. Per Patient/Entry read the data from the Data-File
3. Build a string with paths and data
4. Send the composition to the FLAT-API Composition Endpoint of your OpenEHR-Repository

For more Information about the FLAT-Format see [EHRBase Documentation about FLAT](https://ehrbase.readthedocs.io/en/latest/02_getting_started/05_load_data/index.html#flat-format).

**Compositin Example:**  
```python
{   "ctx/language": "de",
    "ctx/territory": "DE",
    "ctx/composer_name": "ZLG-Collaborateur",
    "stationärer_versorgungsfall/context/start_time": "2021-06-01",
    "stationärer_versorgungsfall/context/falltyp": "Einrichtungskontakt",
    "stationärer_versorgungsfall/context/fallklasse": "Stationär",
    "stationärer_versorgungsfall/context/fall-kennung": "Fall-Kennung 76",
    "stationärer_versorgungsfall/aufnahmedaten/datum_uhrzeit_der_aufnahme": "2021-06-03T11:30:16.658Z",
    "stationärer_versorgungsfall/entlassungsdaten/datum_uhrzeit_der_entlassung": "2021-06-03T11:30:16.658Z",
    "stationärer_versorgungsfall/aufnahmedaten/aufnahmegrund|code": "01",
    "stationärer_versorgungsfall/aufnahmedaten/aufnahmeanlass|code": "E"
}
```
## Code Example

For a code example see the [next page](./plain_python_etl/example.md).

---
[![Creative Commons Attribution-ShareAlike 4.0 International License](https://i.creativecommons.org/l/by-sa/4.0/88x31.png "Creative Commons Attribution-ShareAlike 4.0 International License")](http://creativecommons.org/licenses/by-sa/4.0/)