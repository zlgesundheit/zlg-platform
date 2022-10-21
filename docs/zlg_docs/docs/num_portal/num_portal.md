---
title: Web-Portal
sidebar_position: 1
---

# WebPortal NUM-Portal

## About the NUM Portal
The NUM-Portal is a web-based solution for the management and utilisation of (openEHR-based) Research Databases. As a part of the NUM CODEX Project the partners of the "netzwerk universitäts medizin" a cross-institutional platform for covid-19 data was developed. The goal was to connect unversity hospitals from all over germany and offer a platform for the elevation of data and analysis of structured data with high quality. The platform solution was developed as open-source and is available on the [NUM Forschungsdatenplattform Github](https://github.com/num-forschungsdatenplattform).

## Function of the NUM Portal in the ZLG platform
For the ZLG platform the NUM Portal is one option to realize the FAIR Data Access. The Portal allows researchers and project managers to manage data, search data and find data. Other options may include using a [CKAN](https://ckan.org) repository for Metadata or other solutions.

## Components
The following components are part of the num platform:

> **Frontend:**
> - num-portal-webapp [@github](https://github.com/NUM-Forschungsdatenplattform/num-portal-webapp)  

> **Backend:**
> - num-portal [@github](https://github.com/NUM-Forschungsdatenplattform/num-portal)

> **Data Repository:**
> - ehrbase [@githhub](https://github.com/NUM-Forschungsdatenplattform/ehrbase)

> **Database:**
> - postgres [@dockerhub](https://hub.docker.com/_/postgres)

> **Network/Proxy:**
> - NGINX [@dockerhub](https://hub.docker.com/_/nginx/tags)

## Setup of the NUM Portal
For explanation and examples on how to setup a NUM Portal for your platform instance see the next pages.

---
[![Creative Commons Attribution-ShareAlike 4.0 International License](https://i.creativecommons.org/l/by-sa/4.0/88x31.png "Creative Commons Attribution-ShareAlike 4.0 International License")](http://creativecommons.org/licenses/by-sa/4.0/)