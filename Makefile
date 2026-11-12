.PHONY: help build test verify clean infra-up infra-down

help:
	@echo "build test verify clean infra-up infra-down"

build:
	mvn -B -DskipTests package

test:
	mvn -B test

verify:
	mvn -B verify

clean:
	mvn -B clean

infra-up:
	docker compose up -d

infra-down:
	docker compose down
