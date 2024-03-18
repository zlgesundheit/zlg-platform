#!/bin/bash

# Change to the directory where your Docker Compose file is located
cd /home/richter122/zlg-platform

# Start the containers using Docker Compose
docker-compose up certbot
sleep 5m # Waits 5 minutes for certbot to run (should take about 8 seconds)
docker-compose exec nginx nginx -s reload
