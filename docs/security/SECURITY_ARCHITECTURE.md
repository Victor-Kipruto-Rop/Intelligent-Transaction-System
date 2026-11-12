# Security Architecture

## Security model
Zero-trust workload identity, least privilege, deny-by-default authorization, defense in depth and explicit trust boundaries.

## Identity
OIDC/OAuth 2.1-compatible authorization architecture, MFA for privileged users, short-lived tokens, refresh rotation, revocation, service identities and scoped API credentials. Select and configure a supported identity provider during implementation.

## Authorization
RBAC plus contextual policy where required. Tenant context is derived from authenticated identity and server-side registry. Enforce authorization at API, service, database and object-storage boundaries. Never trust tenant IDs supplied solely by clients.

## Data protection
TLS in transit, encryption at rest, managed key hierarchy, key rotation, field-level encryption/tokenization where risk requires, data minimization, redaction and retention enforcement.

## Application defenses
Strict input validation, parameterized SQL, output encoding, SSRF controls, secure deserialization, CSRF protection where cookie sessions are used, CORS allowlists, request/body limits, rate limits, WAF and DDoS controls.

## Webhook defenses
Raw-body signature verification, timestamp tolerance, replay detection, endpoint ownership verification, secret rotation, IP allowlists only as defense in depth, durable inbox and safe acknowledgement.

## Operations
No secrets in Git, images, logs or telemetry. Use secret manager references, workload identity, privileged access reviews, audit logs, patch SLAs, incident response and tested key compromise procedures.

## Assurance
Threat model, SAST, DAST, SCA, container/IaC scans, SBOM, artifact signing, penetration tests and independent security review. No claim of zero vulnerabilities or certification without evidence.
