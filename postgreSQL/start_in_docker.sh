#!/usr/bin/env bash
#Docker must be running.
#Script that kills running PostgreSQL depends on container name.
docker run --name PostgreSql -d -p=5432:5432/tcp -e POSTGRES_PASSWORD="$POSTGRES_PASSWORD" \
        -e POSTGRES_USER="$POSTGRES_USER" -e POSTGRES_DB="$POSTGRES_DB" postgres:9.6.2