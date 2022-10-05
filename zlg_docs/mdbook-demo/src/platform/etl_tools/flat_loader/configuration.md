# Flat_Loader - Configuration

## Requirements / Dependencies
The foolowing tools/dependencies are used/needed when working with the FLAT-Loader.

- openEHR-Server supporting the FLAT-API (e.g. EHRBase)
- Python 3.8 with modules "openpyxl" and "requests"
- openpyxl, Copyright (c) 2010 openpyxl, MIT Licence, https://github.com/fluidware/openpyxl/blob/master/LICENCE
- Pandas / Numpy
- xlsxwriter
- requests
- chardet

## Config-File 'Config.ini'

The `config.ini` File is located in the main folder of the FLAT-Loader. The settings in this file affect the behaviour and function of the different steps in the tool.

#### OPT and Data Files (mandatory)

> `templatename` = Name of the Template-OPT-File

> `inputcsv` = Name of the Input-Data-CSV-File

#### Authentication Information for the Target Repository (mandatory for Step0 and Step2)

The Auth Header is "username:password" in base64-encoding

> `targetauthheader` = e.g. Basic ZWhyYmFzZS11c2VyOlN1cGVyU2VjcmV0UGFzc3dvcmQ=

> `targetrepoadress ` = http://>>IP-Adress<</ehrbase

#### Relevant Attributes to read Input Data from CSV (mandatory for Step2)

> `subjeectidcolumn` = Column-Name of the Colummn that holds the Subject-IDs of the entries/cases in the CSV

> `subjectnamespacecolumn` = Column-Name of the Column that holds the Namespace in which the entries/cases will be stored (in the openEHR-Repository)

#### Other Settings (optional)

> `allindexesareone ` = 0 or 1; To set the Cardinality of all elements in the Compositions to 1 (Cardinality = amount of repetitions of repeatable elements in the template)  

> `createehrs ` =  0 or 1; If you set this to 0 the Step2 of the Tool will NOT create EHRs for each Patient (Can be used when EHRs have been created in an initial upload or you are sure they already exist at the server).

> `directupload ` = 0 or 1; If you set this to 0 the Step2 of the Tool will build the compositions (and store them in the ETLProcess/Output-Folder) but will NOT upload to the repository  

---
[![Creative Commons Attribution-ShareAlike 4.0 International License](https://i.creativecommons.org/l/by-sa/4.0/88x31.png "Creative Commons Attribution-ShareAlike 4.0 International License")](http://creativecommons.org/licenses/by-sa/4.0/)