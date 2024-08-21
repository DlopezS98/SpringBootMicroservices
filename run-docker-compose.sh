#!/bin/bash

# Enable strict error handling
set -euo pipefail

clean_projects=true;

while (( $# >= 1 )); do 
    case $1 in
        --silent) clean_projects=false ;;
        *) echo "Invalid option: $1"; exit 1 ;;
    esac
    shift
done

# Define specific services to re-build with docker-compose
# services_to_rebuild=(
#     "api-gateway"
#     "eurekaserver"
#     "books-service"
#     "writer-service"
# )

if [ "$clean_projects" = true ]; then
    sh clean-packages.sh --all

    # docker-compose up -d --no-deps --build "${services_to_rebuild[@]}"

    docker-compose up -d
    echo "All projects cleaned and started successfully"
    exit 0
fi

docker-compose up -d
# docker-compose up -d --no-deps --build "${services_to_rebuild[@]}"
echo "All projects started successfully"