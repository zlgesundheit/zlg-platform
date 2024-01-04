#!/bin/bash

# Change to the directory where your Docker Compose file is located
cd /home/richter122/zlg-platform

# Start the containers using Docker Compose
docker-compose up certbot
docker-compose exec nginx nginx -s reload
