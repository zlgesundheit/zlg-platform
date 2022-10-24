---
title: Platform Architecture
sidebar_position: 1
---

# ZLG Platform - Architecture

## Idea of the platform
The ZLG platform concept describes the state of the art for research data platforms on the basis of existing platforms (Of which there are already many). For the ZLG the main research question was to find what is needed in the context of the ZLG and which tools can be used to achieve existing goals and identified needs.

This requirements identification process led to a set of core requirements and relevant components: 
- The platform needs to have a core component like a landing place where researchers access the functionality and get information from (e.g. a Web-Application).
- The platform needs to be low maintenance and consist of existing tools since not only developing but also maintaining and owning an own software product requires a good amount of resources (by product owners and operators).
- The later platform must be characterized by a high degree of automatism, extensibility, adapatbility and user-friendliness accompanied by good documentation.

For the first phase of the platform integration, the goal was to setup the core of the platform while allowing for later adaption and extension. The long-version of the concept explains this and more in greater detail while also giving an intro to openEHR and the different components that need to be present in the platform.

See concept document [PDF: Concept - Long Version (german)](https://owncloud.gwdg.de/index.php/s/0JYgg19e13NrKoU) online or [download it as PDF](https://c100-099.cloud.gwdg.de/docs/assets/TA1.4.2_ZLG_Konzept_Langversion.pdf) directly.

### Features

Features of a platform build upon the ZLG-Concept are:

* Setup and further info about (open-source) openEHR-Environment
* Integration of source data into an openEHR-based respitory
* With NUM-Portal:
  * Management of current research projects
  * Feasibility-Searches on stored data sets

## Usage
The platform concept also describes the first Use Case that was carried out while implementing the paltform iteratively. The "Data Analysis Use-Case" included performing the whole process of preparing data, modelling data, importing data, querying data and using data for analysis. For the first Use Case a data set from the NATARS project at the MHH in Hannover was used.

### Data Modeling
The platform is based on openEHR. Therefore the data needs to be represented by openEHR models calles Aarchetypes and Templates. A Template is used to define a data set that can be imported and queried at the platform. See documentation pages about [openEHR Modelling](./openehr_details.md).

![Nutzungsprozess Modellierung](/img/1_nutzungsprozess_modellierung.png)

### Data Import
The data import is performed using the open API of the openEHR-Standard. Resources can be send to and API endpoint and will be consumed by the server. Building these resources is supported by different tools and libraries ([openEHR_SDK](https://github.com/ehrbase/openEHR_SDK), [ZLG FLAT_Loader](./etl_tools/flat_loader.md), [Better CSV-Import](./etl_tools/better-import.md), [HaMSTR_Loader](./etl_tools/hamstr_loader.md))

![Nutzungsprozess Datenimport](/img/2_nutzungsprozess_datenimport.png)

### Data Storage
In the openEHR-World data is stored by **openEHR-Servers**. These servers offer API-Endpoints to interact with the data base. These API is described in the openEHR-Specification and some servers offer additional functionality described in their documentation. See documentation pages about [openEHR Servers](./openehr_repository.md).

### Data Access/Search
Data from an openEHR-Repository can be queried directly via AQL (a query lanuage similar to SQL). The data access process depends on the governance concept defined by the operator of the platform instance. Legal, ethical and data privacy aspects must be considered! With openEHR the data models are acccessible via the Clinical Knowledge Manager (CKM) which is also used for reviews and version management when modelling.

![Nutzungsprozess Datenexploration](/img/3_nutzungsprozess_datenexploration.png)

### Data Export
Like the Data Access the Data Export depends on the governance concept and defined processes for exporting and analysing data. Defining process steps and contact persons is an important part of a functioning data access process.

![Nutzungsprozess Datenbereitstellung](/img/4_nutzungsprozess_datenbereitstellungexport.png)

### Data Analysis
Data Anaylsis can be performed on a data export that has been queried from the openEHR-Repository. In this case every anaylsis tool may be feasible. Exported Data is most often in a tabular format and can be shared as CSV-File, SQL-DB or similar.

![Nutzungsprozess Datenanalyse](/img/5_nutzungsprozess_datenanalyse-png.png)

## Setup
The platform consists of multiple tools. You may use only individual tools or use all of them depending on your needs.

- [EHRBase](https://gitlab.gwdg.de/medinf/ivf/zukunftslabor-gesundheit/zlg-platform/-/tree/master/ehrbase_docker)
- ["NUM"-Portal](https://gitlab.gwdg.de/medinf/ivf/zukunftslabor-gesundheit/zlg-platform/-/tree/master/portal_docker)
- [ZLG Documentation](https://gitlab.gwdg.de/medinf/ivf/zukunftslabor-gesundheit/zlg-platform/-/tree/master/zlg_docs)

## Security
The security of data repository and associated tools depends on the (network) environment, accessibility and governance. For more info see the [page about security](./platform_security.md).

---
[![Creative Commons Attribution-ShareAlike 4.0 International License](https://i.creativecommons.org/l/by-sa/4.0/88x31.png "Creative Commons Attribution-ShareAlike 4.0 International License")](http://creativecommons.org/licenses/by-sa/4.0/)