# Local development

## Requirements

- JDK 21
- Maven 3.9+ (or the Maven Wrapper once its JAR/scripts are added)
- Docker Engine and Docker Compose v2

## Start dependencies

```bash
cp .env.example .env
docker compose up -d
docker compose ps
```

## Build and test

```bash
mvn -B verify
```

## Stop dependencies

```bash
docker compose down
```

To remove local volumes as well, use `docker compose down -v`. This permanently deletes local database, Redis and Kafka development data.
