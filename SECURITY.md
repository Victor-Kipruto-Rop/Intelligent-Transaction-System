# Security Policy

## Project status

ITS is under active pre-development design. The repository is not a declaration that the platform is production-ready, certified, or safe to process real financial data. Do not submit real customer records, credentials, secrets, payment card data or production provider payloads as issues or pull-request fixtures.

## Reporting a vulnerability

Do not publish exploitable vulnerability details in a public issue. Use GitHub's private vulnerability reporting feature for this repository if it is enabled. If private reporting is unavailable, contact the repository maintainer through a private channel associated with the GitHub account and request a secure reporting route. Do not include secrets or live customer data in the initial report.

Include, where safe:
- affected component and version/commit;
- impact and preconditions;
- minimal reproduction steps or proof of concept;
- suggested mitigation;
- whether the issue may have been exploited.

## Response expectations

The maintainer should acknowledge a report, assess severity and scope, coordinate a fix, validate the remediation and agree on disclosure timing with the reporter. No fixed response-time SLA is claimed until an operational security team and support process are established.

## Scope

Relevant areas include authentication, authorization, tenant isolation, data exposure, cryptography, webhook verification, dependency and build supply chain, infrastructure configuration, availability and financial-integrity controls.

## Safe harbor

Security research must avoid privacy violations, service disruption, data destruction, persistence, lateral movement and access to data belonging to other users or tenants. Stop testing and report immediately if sensitive data is encountered.
