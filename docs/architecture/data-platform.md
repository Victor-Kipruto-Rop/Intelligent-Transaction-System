# Data platform and lakehouse

## Layers

- Bronze: immutable raw source events with ingestion metadata.
- Silver: normalized, validated, deduplicated canonical records.
- Gold: tenant-scoped business facts, aggregates and reporting marts.

Use Parquet for columnar storage and Iceberg for table metadata, snapshots, schema evolution and partition management. Choose partition columns based on measured query patterns; avoid high-cardinality partition explosion.

Trino is the interactive SQL layer. Spark is used for large transformations, backfills and maintenance. Operational transaction writes remain in PostgreSQL.
