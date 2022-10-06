# Security

## Assess context and security needs
The security of data repository and associated tools depends on the (network) environment, accessibility and governance. If you plan to have your CDR in a secure network without any connection to the internet and only access by a small set of people you will not need to worry about mouch. However if you make your repository and your data more accessible you will have to give a thought to security aspects.

## Governance and Access
Together with the government concept you have to define access scenarios, regulations and user roles with suitable access rights. This takes effect mainly in governance processes and for example role based access via keycloak.

## Simple SSL-Security
The NUM-Portal as well as the EHRBase are often exposed to the internet. The traffic of these tools is not encrypted by default. Setting up an NGINX as a Proxy in front of these services and activating SSL-Encryption is an easy way to get a more secure environment.

The FLAT_Loader is a tool that runs locally and performs only data transformation before sending the data to an openEHR-Repository.

### Setting up multiple service with nginx proxy
1. Clone the "zlg-platform" repository from [Gitlab](https://gitlab.gwdg.de/medinf/ivf/zukunftslabor-gesundheit/zlg-platform)
2. 

---
[![Creative Commons Attribution-ShareAlike 4.0 International License](https://i.creativecommons.org/l/by-sa/4.0/88x31.png "Creative Commons Attribution-ShareAlike 4.0 International License")](http://creativecommons.org/licenses/by-sa/4.0/)