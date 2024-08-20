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
cleanCloudGateway=false
cleanEurekaServer=false
cleanMsBooks=false
cleanMsWriter=false
cleanAllProjects=false

# Parse command-line arguments
while (( $# >= 1 )); do 
    case $1 in
        --only-gateway) cleanCloudGateway=true ;;
        --only-eureka) cleanEurekaServer=true ;;
        --only-books) cleanMsBooks=true ;;
        --only-writer) cleanMsWriter=true ;;
        --all) cleanAllProjects=true ;;
        *) echo "Invalid option: $1"; exit 1 ;;
    esac
    shift
done

# Execute cleaning based on the flags
if [ "$cleanAllProjects" = true ]; then
    cleanProject "cloud-gateway"
    cleanProject "eurekaserver"
    cleanProject "ms-books"
    cleanProject "ms-writer"
    echo "All projects cleaned successfully"
    exit 0
fi

if [ "$cleanCloudGateway" = true ]; then
    cleanProject "cloud-gateway"
fi

if [ "$cleanEurekaServer" = true ]; then
    cleanProject "eurekaserver"
fi

if [ "$cleanMsBooks" = true ]; then
    cleanProject "ms-books"
fi

if [ "$cleanMsWriter" = true ]; then
    cleanProject "ms-writer"
fi

# Check if any cleaning operation was performed
if [ "$cleanCloudGateway" = false ] && [ "$cleanEurekaServer" = false ] && [ "$cleanMsBooks" = false ] && [ "$cleanMsWriter" = false ]; then
    echo "No valid options provided. Exiting."
    exit 1
fi

echo "Projects cleaned successfully"
