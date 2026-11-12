# ADR 0002: Regional cells and tenant home region

Status: Proposed. Date: 2026-11-12.

Decision: Each tenant has one authoritative home region. Global routing forwards writes there. Recovery replication is asynchronous unless stronger consistency is proven and approved. No default multi-primary ledger writes. Failover requires writer fencing, recovery-point validation and reconciliation.