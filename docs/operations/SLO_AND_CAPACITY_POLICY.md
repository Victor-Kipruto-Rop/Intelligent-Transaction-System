# SLO and Capacity Engineering Policy

## Measure separately
API acceptance latency, durable write latency, event publication delay, consumer lag, reconciliation completion, provider availability, error rate, queue age, database saturation and tenant fairness.

## Capacity tests
Use representative payload sizes, tenant distributions, hot keys, provider rate limits, realistic data retention and production-like infrastructure. Test sustained, burst, stress, soak and recovery workloads.

## Initial planning envelope
The existing repository's 1,000 sustained API RPS, 5,000 burst RPS, 10,000 concurrent sessions and millions of events/day are planning scenarios only. They are not measured capacity, promises or production SLOs.

## Scaling controls
Bound thread pools, DB pools, queues, payload size, concurrency, retries and per-tenant quotas. Autoscale on meaningful signals such as queue lag and saturation, not CPU alone. Protect the financial write path from analytics and export workloads.

## SLO policy
Define SLI/SLO/error budget by service and customer tier after baselines. Alert on user-visible symptoms and burn rates. Review capacity and cost together.
