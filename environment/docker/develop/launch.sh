#!/bin/bash

DOCKER_ENV=`echo ${DOCKER_ENV}`

if [ "$DOCKER_ENV" = "development" ]; then
  docker-compose -f docker-compose.yaml -f docker-compose-local.yaml up -d --build
else
  docker-compose -f docker-compose.yaml -f docker-compose-prod.yaml up -d --build
fi