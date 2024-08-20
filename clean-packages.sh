#!/bin/bash

cleanProjects () {
    echo "Cleaning all projects"
    cd cloud-gateway
    ./mvnw clean package
    cd ..
    cd eurekaserver
    ./mvnw clean package
    cd ..
    cd ms-books
    ./mvnw clean package
    cd ..
    cd ms-writer
    ./mvnw clean package
    cd ..
}

cleanCloudGateway=false;
cleanEurekaServer=false;
cleanAllProjects=false;
cleanMsBooks=false;
cleanMsWriter=false;

while (( $# >= 1 )); do 
    case $1 in
    --only-gateway) cleanCloudGateway=true;;
    --only-eureka) cleanEurekaServer=true;;
    --only-books) cleanMsBooks=true;;
    --only-writer) cleanMsWriter=true;;
    --all) cleanAllProjects=true;;
    *) break;
    esac;
    shift
done

if [ "$cleanAllProjects" = true ]; then
    cleanProjects
    # exit execution
    exit 0;
fi

if [ "$cleanCloudGateway" = true ]; then
    echo "Cleaning cloud gateway project"
    cd cloud-gateway
    ./mvnw clean package
    cd ..
fi

if [ "$cleanEurekaServer" = true ]; then
    echo "Cleaning eureka server project"
    cd eureka-server
    ./mvnw clean package
    cd ..
fi

if [ "$cleanMsBooks" = true ]; then
    echo "Cleaning ms-books project"
    cd ms-books
    ./mvnw clean package
    cd ..
fi

if [ "$cleanMsWriter" = true ]; then
    echo "Cleaning ms-writer project"
    cd ms-writer
    ./mvnw clean package
    cd ..
fi

echo "Projects cleaned successfully"