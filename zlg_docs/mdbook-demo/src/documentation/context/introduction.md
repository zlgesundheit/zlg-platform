# Introduction

Mit den Arbeiten an einer interoperablen Forschungsplattform wird auf die Kernziele des Zukunftslabor Gesundheit und des organisatorisch übergeordneten Zentrums für digitale Innovationen Niedersachsen (kurz ZDIN) hingearbeitet. Im Fokus des ZDIN und damit der Zukunftslabore steht die Vernetzung von Akteuren, Ideen sowie Kompetenzen aus Forschung und Praxis. Der Standort Niedersachsen soll durch Vernetzung und Digitalisierung von niedersächsischen Spitzenreitern aus Wissenschaft und Wirtschaft gestärkt werden. Die in den Zukunftslaboren beteiligten Partner setzen interdisziplinär und standortübergreifend zukunftsweisende Forschungsprojekte um bzw. initiieren diese gemeinsam.  

Ähnliche Projekte wie z.B. das Projekt HiGHmed zeigten in ihrer Projektlaufzeit bereits die Komplexität und den finanziellen Aufwand für sowohl Personal, als auch Hard- und Software bei der Etablierung von Forschungsdateninfrastrukturen auf. Im HiGHmed-Projekt werden Medizinische Datenintegrationszentren an Universitätsklinika aufgebaut, in denen medizinische Daten interoperabel modelliert und abgespeichert werden und anschließend für den einrichtungsübergreifenden Austausch unter bestimmten Bedingungen bereitgestellt werden.  

Im Rahmen des ZL-G finden Arbeiten statt, welche sowohl die strategischen Ziele des ZL-G und des ZDIN unterstützen, als auch ähnliche Projekte wie z.B. HiGHmed ergänzen und sich so, am derzeitigen wissenschaftlichen Erkenntnisstand orientiert, in die wissenschaftliche Landschaft sinnvoll einfügen. 
Die strategischen Ziele des ZDIN bzw. Zukunftslabors werden auf operativer Ebene in Forschungsvorhaben in einrichtungsübergreifender Kollaboration durch die ZL-G Partner umgesetzt. Im ZL-G finden diese Arbeiten in den drei Teilprojekten statt, welche thematisch mit den Themen Datenaustausch und –Analyse (Teilprojekt 1), Sensorik (Teilprojekt 2) und Aus-, Fort- und Weiterbildung (Teilprojekt 3) befasst sind. Die Erforschung einer interoperablen Forschungsplattform, welche im Fokus dieses Dokuments steht, ist als Arbeitspaket in Teilprojekt 1 angelegt. Korrespondierende Arbeitspakete mit Inhalten zu Datenanalyse und Datenverwaltung bzw. Governance sind ebenfalls im Teilprojekt 1 verortet.  

Auf Arbeitsebene wird in der Projektanfangsphase (Jahr 1 und 2) auf die Erlangung wissenschaftlicher Erkenntnisse in den Bereichen interoperabler Datenaustausch und Analyse von interoperabel modellierten Daten abgezielt. Eine Forschungsplattform mit umfassenden Funktionalitäten setzt sich aus verschiedenen Modulen bzw. Komponenten zusammen, welche eine Vielzahl verschiedener Prozesse für Implementation, Wartung, Betrieb und Nutzung beinhalten bzw. voraussetzen. Die Erforschung derartiger Plattformen kann daher über den Aufbau, Erprobung und Dokumentation von Einzel-Prozessen rund um die Verwendung einer interoperablen Forschungsdatenplattform realisiert werden. Im Konkreten passiert das über die Erarbeitung von Prozessen anhand eines Use Cases, was Governance-Prozesse für das ZL-G, die Erprobung der technischen Umsetzung im Rahmen des ausgewählten Use Case sowie die Translation der gemachten Erfahrungen in Form von wissenschaftlichen Veröffentlichungen, in Form von Lehrinhalten oder Demonstratoren für die ZL-G Lehre und andere öffentlichkeitswirksamen Darstellungen der erfolgten Arbeiten umfasst.  

In den Folgejahren (Jahr 3 - 5) steht die Validierung bzw. Evaluation mit anschließender Weiterentwicklung an.

## ZLG Source Code

Alle Quelldateien sowie zugehörige Dokumentation sind auffindbar im [ZLG GitLab Repository](https://gitlab.gwdg.de/medinf/ivf/zukunftslabor-gesundheit).

### Original/Einzelne Repositories

[//]: <> (![]img/module_icons_1200px.png )

This repository comprises or is linked with the following repos:

* [FLAT-Loader](https://gitlab.gwdg.de/medinfpub/openehr_flat_loader):
 ETL-Tool to transform source data into openEHR-Resources
* [Physio-Tracker TP3-Demonstrator Backend](https://gitlab.gwdg.de/medinf/ivf/zukunftslabor-gesundheit/physio-tracker-backend): 
 Backend des Physio-Trackers aus TP3
* [Physio-Tracker Demo / Proof-of-concept](https://gitlab.gwdg.de/medinf/ivf/zukunftslabor-gesundheit/physio-app_proof-of-concept):
 A proof of concept application with some demo excercises for the Physio Tracker App. 
* [docs-zlg](https://gitlab.gwdg.de/medinf/ivf/zukunftslabor-gesundheit/docs-zlg):
 Quellcode für die Erstellung dieser Dokumentations-Website
* [ZLG EHRBase](https://gitlab.gwdg.de/medinf/ivf/zukunftslabor-gesundheit/zlg-ehrbase):
 Testumgebung und Docker-Compose File für eine [EHRBase](https://ehrbase.org) 


## License

### Website/Documentation

This documentation is created with [mdbook](https://github.com/azerupi/mdBook).

The source code of this website is available at [zlg-docs GitLab Repository](https://gitlab.gwdg.de/medinf/ivf/zukunftslabor-gesundheit/docs-zlg) 

### ZLG Project
Copyright (C) 2019-2021 zlg contributors, see [AUTHORS.md](https://gitlab.gwdg.de/medinf/ivf/zukunftslabor-gesundheit)

[//]: <> (The project source code is licensed)
[//]: <> (under GNU General Public License 3.0https://spdx.org/licenses/GPL-3.0-or-later.html, )
[//]: <> (see license filehttps://gitlab.gwdg.de/....../LICENSE)

### Documentation

This documentation is licensed under Creative Commons license [CC-BY-SA 4.0](http://creativecommons.org/licenses/by-sa/4.0/) unless otherwise stated.

[![Creative Commons Attribution-ShareAlike 4.0 International License](https://i.creativecommons.org/l/by-sa/4.0/88x31.png "Creative Commons Attribution-ShareAlike 4.0 International License")](http://creativecommons.org/licenses/by-sa/4.0/)
