# Secure Development Standard

- Require protected branches and pull-request review.
- Run formatting, static analysis, unit tests and dependency scanning in CI.
- Scan secrets, containers and infrastructure-as-code.
- Generate SBOMs and retain build provenance.
- Pin and review dependencies; define patch SLAs by severity and exploitability.
- Use supported JDK and framework versions; review upgrades regularly.
- Prohibit hard-coded secrets, production dumps and real customer data in tests.
- Require security review for auth, crypto, tenant boundaries, money movement and external connectors.
- Use safe error messages and structured, redacted logs.
- Document vulnerability disclosure and coordinated remediation.
- Release signed immutable artifacts with rollback instructions.
