#!/bin/bash

DOCKER_ENV=`echo ${DOCKER_ENV}`

if [ $# -eq 1 ]; then
  if [ "$DOCKER_ENV" = "development" ]; then
    docker-compose -f docker-compose.yaml -f docker-compose-local.yaml logs $1
  else
    docker-compose -f docker-compose.yaml -f docker-compose-prod.yaml logs $1
  fi
else
  if [ "$DOCKER_ENV" = "development" ]; then
    docker-compose -f docker-compose.yaml -f docker-compose-local.yaml logs
  else
    docker-compose -f docker-compose.yaml -f docker-compose-prod.yaml logs
  fi
fi

