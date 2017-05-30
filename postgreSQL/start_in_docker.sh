#!/usr/bin/env bash
#Script that kills running PostgreSQL depends on container name.
#Be cautious when renaming or moving this script is may be used somewhere.
docker run --name PostgreSql -d -p=5432:5432/tcp -e POSTGRES_PASSWORD="$POSTGRES_PASSWORD" \
        -e POSTGRES_USER="$POSTGRES_USER" -e POSTGRES_DB="$POSTGRES_DB" postgres:9.5