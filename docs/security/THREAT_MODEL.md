# Threat Model

## Assets
Financial records, ledger integrity, credentials, signing keys, tenant data, personal data, provider connections, event streams, audit evidence and service availability.

## Trust boundaries
Internet/API edge; provider ingress; connector execution; service-to-service network; tenant data stores; message broker; analytics/lakehouse; control plane; operator access; CI/CD and software supply chain.

## Threat scenarios and controls
- Spoofed webhook: cryptographic signature, timestamp and replay checks.
- Duplicate/replayed event: inbox, idempotency and durable source identity.
- Cross-tenant access: server-derived tenant context, authorization tests and database defense in depth.
- Credential theft: short-lived credentials, secret manager, rotation and revocation.
- SQL/command injection: parameterization, validation and least privilege.
- SSRF: egress allowlists, DNS/IP validation and metadata endpoint blocking.
- Queue poisoning: schema validation, quotas, DLQ and producer authentication.
- Insider misuse: separation of duties, privileged access, immutable audit and alerts.
- Data exfiltration: minimization, encryption, egress controls and access monitoring.
- Supply-chain compromise: pinned dependencies, SBOM, signed artifacts and protected CI.
- Resource exhaustion: quotas, bounded queues, timeouts and admission control.
- Ransomware/data corruption: immutable backups, isolation and restoration drills.
- Regional split brain: single-writer fencing and controlled failover.

## Required artifacts
Data-flow diagrams, abuse cases, risk ratings, control owner, test evidence, residual risk acceptance and periodic reassessment. Threat model changes with each new connector, trust boundary or sensitive data type.
