#!/bin/bash

# Enable strict error handling
set -euo pipefail

# Define function to clean a specific project
cleanProject() {
    local project_dir=$1
    echo "Cleaning $project_dir project"
    cd "$project_dir"
    ./mvnw clean package
    cd - > /dev/null
}

# Initialize flags
clean_cloud_gateway=false
clean_eurekaserver=false
clean_msbooks=false
clean_mswriter=false
clean_all_projects=false
projects_to_clean=()
project_map_set=false

# Parse command-line arguments
while (( $# >= 1 )); do 
    case $1 in
        --only-gateway) clean_cloud_gateway=true ;;
        --only-eureka) clean_eurekaserver=true ;;
        --only-books) clean_msbooks=true ;;
        --only-writer) clean_mswriter=true ;;
        --all) clean_all_projects=true ;;
        --projects=*) 
            IFS=',' read -r -a projects_to_clean <<< "${1#*=}" 
            project_map_set=true ;;
        *) echo "Invalid option: $1"; exit 1 ;;
    esac
    shift
done

# Execute cleaning based on the flags
if [ "$clean_all_projects" = true ]; then
    cleanProject "cloud-gateway"
    cleanProject "eurekaserver"
    cleanProject "ms-books"
    cleanProject "ms-writer"
    echo "All projects cleaned successfully"
    exit 0
fi

# Define known project directories
declare -A project_map=(
    [gateway]="cloud-gateway"
    [eureka]="eurekaserver"
    [books]="ms-books"
    [writer]="ms-writer"
)

# Clean projects based on --projects argument
if [ ${#projects_to_clean[@]} -ne 0 ]; then
    for project in "${projects_to_clean[@]}"; do
        if [[ -n "${project_map[$project]}" ]]; then
            cleanProject "${project_map[$project]}"
        else
            echo "Unknown project: $project"
            exit 1
        fi
    done
fi

if [ "$project_map_set" = true ]
then
    echo "Projects cleaned successfully"
    exit 0
fi

if [ "$project_map_set" = true ]; then
    echo "Projects cleaned successfully"
    exit 0
fi

if [ "$clean_cloud_gateway" = true ]; then
    cleanProject "cloud-gateway"
fi

if [ "$clean_eurekaserver" = true ]; then
    cleanProject "eurekaserver"
fi

if [ "$clean_msbooks" = true ]; then
    cleanProject "ms-books"
fi

if [ "$clean_mswriter" = true ]; then
    cleanProject "ms-writer"
fi

# Check if any cleaning operation was performed
if [ "$clean_cloud_gateway" = false ] && [ "$clean_eurekaserver" = false ] && [ "$clean_msbooks" = false ] && [ "$clean_mswriter" = false ]; then
    echo "No valid options provided. Exiting."
    exit 1
fi

echo "Projects cleaned successfully"
