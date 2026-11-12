# Connection pooling

Bound application pools against the total database connection budget across all replicas. Consider PgBouncer/managed pooling. Set timeouts and test transaction-pooling compatibility. Autoscaling must not exhaust DB connections.