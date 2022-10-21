---
title: OpenEHR - Details
sidebar_position: 3
---

# Details about the OpenEHR Framework

The openEHR Framework is based on the ISO-Standard [ISO 13606:2019](http://www.en13606.org/information.html) which defines "archetypes" and the Reference Model. With this a dual model architecture (clear separation between information (data) and knowledge (models)) is proposed.

## **Data Modeling / Template Creation**
Templates (and Archetypes) are created by domain experts either by selecting existing archetypes (which represented specific clinical concepts) or creating new archetypes in collaboration with the (openEHR-) Community. 

### **Data Modelling using openEHR in general**
- **openEHR-Specification**  
The [specification of openEHR](https://specifications.openehr.org) holds all important information about openEHR.
This information is best used accompanied by information from [community discussions](https://discourse.openehr.org), examples and available open-source openEHR-Servers (e.g. [EHRBase](https://github.com/ehrbase/ehrbase)).

- **Information Model / Reference Model**  
The openEHR [information model](https://specifications.openehr.org/releases/RM/latest/ehr.html) describes how data is structured in the openEHR-World. Data is organized in EHRs (so it is patient-centered) holding information about the EHR(Access, Status) and the EHR that may contain folders / directorys which contain the compositions that hold the data, in form of defined data types and attributes taken from the Reference Model. The structure of compositions that hold the data is defined by Templates (that use Archetypes, which are the Core of openEHR)

![OpenEHR Information Model](/img/openEHR_Information_Model_High_Level_Structure.jpg)

- **Archetypes**  
[OpenEHR-Archetypes](https://specifications.openehr.org/releases/AM/latest/Overview.html) are defined in Archetype Definition Language (ADL). In the multi-level-modelling approach of openEHR they allow to distinct between domain semantics and the information model / reference model. An Archetype is a reusable definition of a semantic concept from a domain, which correspond to logical data points and groups. Archetypes / Semantic concepts should be designed and maintained by domain experts. Often the archetype and template development takes place in [Clinical Knowledge Managers (CKM)](https://ckm.openehr.org/ckm/).

![OpenEHR Archetypes](/img/openehr_archetype_figure.jpg)

- **Templates**  
An openEHR-Template defines an arrangement of items from one or more archetypes, possibly with further constraints on them (regarding cardinality, inputs, etc.). A Template defines how a composition of data looks like and is used at runtime to create data structures and validate inputs. Further information about the underlying concept can be found in the [specification](https://specifications.openehr.org/releases/AM/latest/Overview.html#_templates).

- **Webtemplates and FLAT-Paths**  
A Webtemplate is an other format of a Template (Operational Template / .opt). Webtemplates are Part of the [FLAT-API](https://ehrbase.readthedocs.io/en/latest/02_getting_started/05_load_data/index.html) at first used by EtherCIS and Better and later EHRBase. The FLAT-API allows to communicate with the server using Compositions in FLAT-Format, which means they are structured a non-hierarchical JSON-Strings using FLAT-Paths to define which data item is assigned which value. This format is easy to read, understand and easy to work with.

![FLAT Composition Example](/img/FLAT_Composition_Example.jpg)

---
[![Creative Commons Attribution-ShareAlike 4.0 International License](https://i.creativecommons.org/l/by-sa/4.0/88x31.png "Creative Commons Attribution-ShareAlike 4.0 International License")](http://creativecommons.org/licenses/by-sa/4.0/)