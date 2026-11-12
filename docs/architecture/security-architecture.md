# Security architecture

- Authenticate callers using a supported OIDC/OAuth2 provider or mutually authenticated service identity.
- Authorize tenant, role, source and operation at each service boundary.
- Apply PostgreSQL row-level security where appropriate, but do not rely on RLS alone; set tenant context safely per transaction and test connection-pool reuse.
- Store secrets in a secret manager, never in Git, container images or logs.
- Encrypt network traffic and persistent storage in deployed environments.
- Minimize and classify personal/payment data; tokenize or redact sensitive identifiers.
- Maintain append-only security and financial audit trails with restricted access.
- Rate-limit public APIs and protect against replay, abuse and oversized payloads.
- Define retention, deletion, backup and key-rotation policies before production.
- Complete a threat model and independent security review before processing real financial data.

This scaffold does not establish PCI DSS, CBK, or any other regulatory compliance.
