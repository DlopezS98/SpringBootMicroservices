# StoryShelf Microservices

## Cleaning up maven projects and generate .jar files
Run the bash script `clean-packages.sh` with the argument `--all` to generate all the .jar files of the projects.
```bash
sh clean-packages.sh --all
```

Other argumens availables:<br>
`--only-gateway`: clean and generate package for the `cloud-gateway` project, the other projects will not be processed.<br>
`--only-eureka`: clean and generate package for the `eurekaserver` project, the other projects will not be processed.<br>
`--only-books`: clean and generate package for the `ms-books` project, the other projects will not be processed.<br>
`--only-writer`: clean and generate package for the `ms-writer` project, the other projects will not be processed.<br>
`--all`: clean and generate package for all the mentioned projects above.<br>
`--projects`: this argument requires at least one of the following values: `gateway`, `eureka`, `books`, `writer`.<br>

Example:
Single project usage
```bash
sh clean-packages.sh --projects=gateway
```
Define multiple project
```bash
sh clean-packages.sh --projects="gateway,eureka,books"
```

## Running docker compose locally

Before running docker compose you must need to generate the .jar file of the java services since it is used to generate the base docker image. Also, make sure to have a `.env` file in the root directory to define environment variables (docker compose services).

`.env` file template minimun setup.
```settings
#Shared Variables
EUREKA_URL=http://eurekaserver:8761/eureka
# Eureka service name for ms-books microservice
EUREKA_MS_BOOKS_URL=http://ms-books:3500
ELASTICSEARCH_URL=http://elasticsearch:9200

# MYSQL Variables
MYSQL_HOST = mysqldatabase
MYSQL_PORT = 3306
MYSQL_ROOT_PASSWORD = MyStr0ngP@ssw0rd!
MYSQL_DATABASE = storyshelf
MYSQL_USER = adminstoryshelf
MYSQL_PASSWORD = @MySqlUser.Tester17!
```

Docker compose command.
```shell
docker-compose up -d
```
Note: The Argument `-d` is meant to be for a dettached process execution.

Delete containers
```shell
docker-compose down
```

You can also use the bash script `run-docker-compose.sh` for cleaning up projects and run docker compose at once.
```bash
sh run-docker-compose.sh
```
User the argument `--silent` to skip cleanup the projects
```bash
sh run-docker-compose.sh --silent
```