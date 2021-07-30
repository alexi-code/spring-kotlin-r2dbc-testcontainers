#!/bin/sh
#
# Create extension to use uuid_generate_v4() func
#
psql -v ON_ERROR_STOP=1 -U "$POSTGRES_USER" -d "$POSTGRES_DB" -c "create extension \"uuid-ossp\";"
