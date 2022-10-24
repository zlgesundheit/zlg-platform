---
title: Welcome!
sidebar_position: 1
---

# Documentation of Platform and Tools of the Zukunftslabor Gesundheit!  
_(engl. Future Lab Health)_

## About the Zukunftslabor
The **Zukunftslabor Gesundheit (ZLG)** is a joint project within the umbrella organiztaion 
**Zentrum für digitale Innovationen Niedersachsen (ZDIN)**. The lab consists of three _"part projects"_ in which the scientific employess of all [partner organizations](./misc/partners.md) engage in exciting and highly relevant research.

On the following pages you will find **context information about the project** as well as a **comprehensive guide** on when and how to use the OpenEHR **Tools to establish (or communicate with) a ZLG Reserach Data Platform**.

See [this page](/docs/docs/context/zukunftslabor_gesundheit) to get more information about the ZL-G and our work.

## Manual for OpenEHR-Tools
This manual describes how the **[openEHR_FLAT_Loader](https://gitlab.gwdg.de/medinfpub/openehr_flat_loader)** can be used to transform tabular data into openEHR-Resources / openEHR-Compositions.
The openEHR_FLAT_Loader is a joint development by researchers from these projects:

- Zukunftslabor Gesundheit (ZL-G),
- Covid-19 Forschungsnetzwerk Niedersachsen (COFONI)
- A Learning and Interoperable Smart Expert System for Pediatric Intensive Care Medicine (ELISE)

The above mentioned projects needed researchers and end user to be able to generate valid openEHR-Resources from existing non-openEHR data.
The [HaMSTR-Builder-Tool](https://gitlab.plri.de/tute/HAMSTRETLBuilder) developed by the _Hannover Medical School (MHH)_ already offered this functionality but needed a (commercial) Better / thinkEHR openEHR-Repository to work. The present FLAT_Loader tool, similar to the HaMSTR builder, builds on the idea of a user-supplied mapping. The openEHR_FLAT_Loader allows the user to generate resources using a mapping from data-items to openEHR-Template items. The openEHR-Template items are derived directly from Webtemplates for given Operational Templates.

Webtemplates are part of the FLAT-API as they are used in Better, EHRBase and EtherCIS openEHR-Servers.
In the future this will be adopted into the openEHR-Standard as a so called [Simplified Data Template (simSDT)](https://specifications.openehr.org/releases/ITS-REST/latest/simplified_data_template.html).
We hope to stay (or become) compatible with the standard in the future.
 
## Flat_Loader-Features
- **Extraction of FLAT-Paths** 
  - from Webtemplates
- **Generation of a Mapping-File** 
  - in form of an Excel-File (.xlsx)
- **Build Ressources (Compositions)** 
  - using a provided .csv, .opt and filled Mapping-File
- **Upload Ressources (Compositions)** 
  - using identifier-column in .csv-Data-File 

## Contact

This documentation is currently maintained by 
* [Jendrik Richter](https://orcid.org/0000-0002-3254-7380), 
jendrik.richter@med.uni-goettingen.de, 
University Medical Center Göttingen, [Department of Medical Informatics](http://mi.umg.eu)

---
[![Creative Commons Attribution-ShareAlike 4.0 International License](https://i.creativecommons.org/l/by-sa/4.0/88x31.png "Creative Commons Attribution-ShareAlike 4.0 International License")](http://creativecommons.org/licenses/by-sa/4.0/)