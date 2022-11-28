---
title: Usage Examples
sidebar_position: 3
---

# Example
Examples on how the NUM Portal is used. Screenshots of criteria definition, AQL searches, cohort searches, project management, user management.

#### Table of contents
- [Login / Registration](#login--registration)
    - [For Admins](#for-admins)
- [Accessing data as a researcher](#accessing-data-as-a-researcher)
    - [Cohort/Search Criteria](#cohortsearch-criteria)
- [Datenabruf](#datenabruf)
    - [For Governance](#for-governance)
- [Creating and Managing - Projects](#creating-and-managing---projects)
    - [For Admins](#for-admins)
- [Creating and Managing - News](#creating-and-managing---news)
- [Creating and Managing - Search Criteria](#creating-and-managing---search-criteria)
- [Manager-Tools - Pseudonym Resolver](#manager-tools---pseudonym-resolver)
- [User Roles - Short overview](#user-roles---short-overview)

## Login / Registration

1. If you visit the NUM-Portal (e.g. DOMAIN/home) you can login via "Anmelden" on the bottom left.
![anmelden](/img/anmelden.jpg)

2. You are asked to accept necessary Cookies - do so   
![cookies](/img/cookies.jpg)

3. If you already have an account login using username or email and password. If not, register.
![register](/img/register.jpg)

4. If you need to register a new account, fill out the registration form and hit "Register".
![register_form](/img/register_form.jpg)

5. You should be logged in now - you have "Benutzerkonto" and "Abmelden" on the bottom left. On the sidebar on the left you see all functionalities of the Portal that you are allowed to use - if the space is blank, you need to be accepted by an admin user in the platforms user management or be assigned proper roles via keycloak user management by an admin!
![benutzerkonto](/img/benutzerkonto.jpg)

> For changes to take effect the user needs to relog!

#### For Admins

You can accept new users using the "Benutzerverwaltung". Just click on the "Aktion"-Pen-Symbol and select the roles the user should have. Optionally assign the user to an organisation - you can alter settings under the "Genehmigte Benutzer"-Tab or at "Organisationsverwaltung.

For the first user / admin user of the platform you need to assign those roles in the keycloak during setup.

## Accessing data as a researcher

To be able to search and access data you need to be assigned to a specific project that includes data / data definitions.

## Datenabruf

Roles that are able to use search or access and export data are `Researcher` and `Manager`.

Via "Datenabruf" in the sidebar you are able to access the projects that you are registered for. Click on the "Aktion"-Symbol and click on "Daten abrufen" to filter and view data and/or export it.

![datenabruf_uebersicht](/img/datenabruf_uebersicht.jpg)

Select your project and extract data using the following button.

![datenabruf](/img/datenabruf.jpg)

In order to perform searches on the data set that belongs to your project a set of search criteria for that data set must be pre-defined. For details see [documentation below](#creating-and-managing---search-criteria)

> For your own data / platform a pragmatic approach is to have users fulfilling multiple roles and therefore reduce friction by having users with more rights. For bigger projects with clear division of labor an approach with less roles per user might be feasible. 

## Searching Data
The "Suche"-Tab in the sidebar allows the uster to explore the available data sets. The number of total data sets is shown and with using filter criteria a search term can be conducted to search for patients/data sets to build a cohort.

![search_tab](/img/search_tab.jpg)

Depending on your user role and rights you are able to also export the data or to apply to use data in form of a project application. Which may be approved or declined based on the Governance / Use&Access procedure.

## Creating and Managing - Search Criteria
For data to be searchable and retrievable a set of search critera needs to be pre-defined.
Users with the role "Criteria Editor" are able to access the "Kriterien"-Tab on the sidebar.

> To define criteria an understanding of the data set and the data model is helpful.




#### For Governance

Anonymized data sets may be available and downloadable for every user - therefore everyone may have the right to export and download. As soon as some data sets on your platform have restricted usage and access rights you need to have someone in place with dedicated rights to export data. The "Manager"-Role is suited for that task.

## Creating and Managing - Projects

Via "Projekte" in the sidebar you are able to access the project management. Start to register a project and fill in needed information. In the process you also select relevant data models. At last click on "Genehmigung anfragen" (after you supplied all needed information) to register the project. Projects need to be accepted by an Admin. After being accepted the project can be started.

![projekte](/img/projekte.jpg)

#### For Admins

Using the "Aktion"-Three-Dot-Symbol you can access the "Projekt überprüfen"-View. Check the information of a project, supply a comment if needed and if everything is OK accept the project via "Projekt genehmigen"-Button. Deal with the additional pop-up and you are done. Note how the status of the project changes accordingly to your actions in the project overview. After accepting the project it needs to be started so researchers can interact.

![genehhmigen](/img/genehmigen.jpg)

> Projects need to be accepted by an Admin. As an Admin be aware of any measures your plattforms governance has put in place to regulate the process of applying for data.

## Creating and Managing - News
It is possible to post News/Infos on the Welcome-Dashboard Page. Besides info text and partners/sponsors there is information about newest projects and the "Info Board" to be found there.

User with the role "Content-Admin" are able to access the "Inhalts-Editor"-Tab in the sidebar. Simply click on "Info-Kachel erstellen" and suplly the info you want to post.

![content_editor](/img/content_editor.jpg)

## Manager-Tools - Pseudonym Resolver

The "Manager"-Role is used to define a person that has access to the sensitive parts of a project (e.g. pseudonyms).
It allows to export data or access pseudonyms. Therefore the rule is suited for a Trusted Third Party or an ETL Persons that is obligated with handing out data according to Data Usage Applications (e.g. approved by an Use & Access comittee)

WIP - ehr_id to subject_id?

## User Roles - Short overview

|Allowance      |Forscher|Projektleiter|Content-Admin|Organisations-Admin|Super-Admin|Projektprüfer|Manager|Kriterien-Editor|
|:-------------:|:-------:|:-----------:|:-----------:|:-----------------:|:--------:|:-----------:|:-----:|:--------------:|
|Export data    |**yes (own)**|no           |no           |no                 |no        |no           |**yes (all)**|no|
|Use search     |no       |yes          |no           |no                 |no        |no           |no       |no|
|Manage projects|no       |**yes (own)**    |no           |no                 |no        |no           |no       |no|
|Accept projects|no       |no           |no           |no                 |no        |**yes **         |no       |no|
|Start projects |no       |**yes (own)**    |no           |no                 |no        |no           |no       |no|
|Manage criteria|no       |no           |no           |no                 |access;no view/save|no  |no       |**yes**|
|Access Manager Tools |no |no           |no           |no                 |no        |no           |**yes (psn)**|no|
|Access Inhalts-Editor|no |no           |**yes **         |no                 |no        |no           |no       |no|
|Manage Organizations |no |no           |no           |access;no view/edit|**yes  **     |no           |no       |no|
|Manage Users   |no       |no           |no           |access;no view/edit|**yes **      |no           |no       |no|

(own) = is allowed to do this for the users own projects or the projects the user is assigned to  
(all) = access to all data searchable by criteria  
(psn) = access to pseudonym resolver  

---
[![Creative Commons Attribution-ShareAlike 4.0 International License](https://i.creativecommons.org/l/by-sa/4.0/88x31.png "Creative Commons Attribution-ShareAlike 4.0 International License")](http://creativecommons.org/licenses/by-sa/4.0/)