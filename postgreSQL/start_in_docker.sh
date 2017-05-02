#!/usr/bin/env bash
#Docker must be running.
#Script that kills running PostgreSQL depends on specified container name.
docker run --name PostgreSql -d postgres:9.6.2
