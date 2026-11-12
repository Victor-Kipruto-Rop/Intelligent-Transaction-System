# Data Classification, Privacy and Retention

## Classification
Public; internal; confidential; restricted financial/identity data. Assign classification to every field and dataset.

## Principles
Collect only necessary data; document purpose and legal basis where applicable; mask by default; restrict access; encrypt sensitive fields where appropriate; prevent secrets and personal data from entering logs, traces, metrics or support exports.

## Retention
Define retention by data category, jurisdiction, contractual obligation and legal hold. Apply lifecycle policies to raw payloads, normalized events, audit records, backups, exports and analytics copies. Deletion must account for derived copies and backup expiry while preserving legally required records.

## Residency
Tenant home region and permitted processing locations are explicit configuration. Cross-border transfers require documented legal assessment and approved safeguards. Residency is not guaranteed merely by deploying a database in a region.

## Data subject and customer rights
Design controlled export, correction of inaccurate source metadata, deletion/anonymization where legally permitted, and audit evidence. Immutable ledger records may require compensating entries rather than destructive edits.
