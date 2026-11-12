# Deployment architecture

Deploy each independently scalable service as an immutable container. Use separate development, staging and production environments, isolated credentials, private networking, managed databases and Kafka, external secrets, autoscaling, health probes and controlled rollouts.

The supplied Docker Compose file is local development only. Kubernetes and Terraform directories are introduced as future deployment boundaries; production manifests must be environment-specific and reviewed before use.
