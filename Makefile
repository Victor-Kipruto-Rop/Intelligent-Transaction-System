.PHONY: help build test verify clean infra-up infra-down

help:
	@echo "build test verify clean infra-up infra-down"

build:
	./mvnw -B -DskipTests package

test:
	./mvnw -B test

verify:
	./mvnw -B verify

clean:
	./mvnw -B clean

infra-up:
	docker compose up -d

infra-down:
	docker compose down
