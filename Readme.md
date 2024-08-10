# StoryShelf Microservices

## Running docker compose locally

Before running docker compose you must need to generate the .jar file of the java services since it is used to generate the base docker image.

Docker compose command.
```shell
docker-compose up -d
```
Note: The Argument `-d` is meant to be for a dettached process execution.

Delete containers
```shell
docker-compose down
```