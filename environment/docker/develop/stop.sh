#!/bin/bash

DOCKER_ENV=`echo ${DOCKER_ENV}`

if [ $# -eq 1 ]; then
    if [ "$DOCKER_ENV" = "development" ]; then
      docker-compose -f docker-compose.yaml -f docker-compose-local.yaml stop $1
      docker-compose -f docker-compose.yaml -f docker-compose-local.yaml rm -f
    else
      docker-compose -f docker-compose.yaml -f docker-compose-prod.yaml stop $1
      docker-compose -f docker-compose.yaml -f docker-compose-prod.yaml rm -f
    fi
else
    if [ "$DOCKER_ENV" = "development" ]; then
      docker-compose -f docker-compose.yaml -f docker-compose-local.yaml stop
      docker-compose -f docker-compose.yaml -f docker-compose-local.yaml rm -f
    else
      docker-compose -f docker-compose.yaml -f docker-compose-prod.yaml stop
      docker-compose -f docker-compose.yaml -f docker-compose-prod.yaml rm -f
    fi
fi