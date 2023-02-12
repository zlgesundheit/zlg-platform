---
title: Update & Upgrade
sidebar_position: 4
---

# Hints for Updating and Upgrading

## Official NUM Portal
If you use the official NUM Portal Image for testing purpose you will be able to simpyl change the version of the image in the docker-compose.
Available versions can be found on [docker-hub](https://hub.docker.com/r/numresearchdataplatform/num-portal-webapp/tags).

![Version Number in docker-compose](/img/docker-num-portal-version.png)

## Adapted NUM-Portal
If you have forked the official NUM-Git-Repo you have to merge the changes into your code and (re)build the image.

## Upgrading Postgres
To upgrade your postgres version you need to save the data before (includes data from NUM-Portal as well as ehrbase)

- Backup data
- Stop old postgres
- Upgrade
- Migrade Data

e.g. see [Blog with Upgrade-Manual](https://www.endpointdev.com/blog/2022/10/upgrading-postgresql-14-to-15-on-fedora-centos-rocky-alma-linux/)