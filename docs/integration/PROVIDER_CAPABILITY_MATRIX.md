# Provider Capability Registry

Track each provider by verified capability, not by marketing name.

| Provider family | Planned examples | Capabilities to verify |
|---|---|---|
| Mobile money | M-Pesa, Airtel Money, MTN MoMo, Orange Money | C2B, disbursement, status callbacks, reversals, statements |
| Banks | Open Banking, core banking, bank file feeds | Account data, payment status, statements, ISO 20022 |
| Gateways | Stripe, Adyen, PayPal, Flutterwave, Paystack, Pesapal | Payment events, refunds, disputes, settlement reports |
| ERP/accounting | SAP, Oracle, QuickBooks, Xero | Journal exports, invoices, account balances |
| Card ecosystem | Acquirers, processors, issuer feeds | Authorization, clearing, settlement, chargebacks |
| Internal systems | APIs, databases, Kafka, SFTP | Configurable source schemas and checkpoints |

## Registry fields
Provider, product/API version, country/region, legal entity, credential owner, environment, supported operations, data fields, rate limits, webhook behavior, idempotency support, SLA, certification date, test evidence, limitations and review expiry.

Do not store credentials in this registry. Use references to a secrets manager. Mark unknown capabilities as unknown, not supported.
