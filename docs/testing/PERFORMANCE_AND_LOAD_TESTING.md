# Performance and Load Testing

## Workloads
Separate ingress acceptance, transaction normalization, ledger posting, event consumption, reconciliation, analytical queries and exports.

## Scenarios
Baseline; steady-state; burst; ramp; stress beyond capacity; long-duration soak; hot-tenant skew; hot-account contention; large payload; provider throttling; database failover; broker outage; recovery backlog drain.

## Metrics
Throughput, p50/p95/p99 latency, error rate, queue age, consumer lag, DB pool wait, lock contention, CPU/memory, network, storage IOPS, retry rate, duplicate suppression and correctness counters.

## Correctness assertions
Compare accepted source records, canonical records, journal totals, outbox events and consumer outcomes. Verify no missing or duplicate financial effects after each run.

## Reporting
Record commit, build, configuration, cloud region, instance sizes, dataset, tenant distribution, tool version, warm-up, run duration, raw results and limitations. Never publish a benchmark without reproducible evidence.
