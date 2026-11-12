# Money and Asset Model

## Status

Pre-implementation specification. This document is not an accounting policy, FX service or implemented monetary library.

## Core representation

A monetary amount must be represented with:
- a signed exact decimal value or integer quantity;
- an explicit currency or asset identifier;
- an explicit scale/precision policy;
- an explicit rounding policy at a named business boundary;
- a documented source and valuation context where applicable.

Binary floating-point values are prohibited for financial amounts.

## Currency and asset metadata

Do not assume every supported instrument is represented completely by java.util.Currency or ISO 4217. Maintain a versioned asset/currency metadata catalogue. Metadata should include code, asset type, validity dates, permitted scale, cash/accounting precision where applicable, and jurisdiction/source provenance.

Unknown or inactive asset codes must be quarantined or rejected according to the operation's policy. Do not silently infer a currency from locale, provider formatting or tenant defaults.

## Scale and rounding

Do not globally reject or round an amount solely because its decimal scale exceeds a generic currency default. Preserve source precision where required, then apply a named operation-specific quantization rule.

Every rounding operation must specify:
- business purpose;
- target scale;
- rounding mode;
- point in the lifecycle where rounding occurs;
- treatment of residuals and rounding differences;
- audit/provenance fields.

## FX

An FX conversion must preserve source amount and asset, target amount and asset, rate, rate direction, rate source, quote identifier, timestamp, fees, rounding mode and rounding delta. Do not combine unlike currencies without an explicit conversion or valuation policy.

## Integer minor units

Integer minor units are appropriate only when the asset's scale and supported magnitude fit the chosen integer representation. Define overflow bounds and schema compatibility. Do not assume a signed 64-bit field covers every future asset, instrument or aggregation.

## Required tests

Test zero-, two- and three-decimal currencies; values with excess source precision; negative values; very large values; rounding boundaries; unknown assets; FX conversion; overflow; serialization round trips; and cross-currency rejection. Test cases must be based on approved asset metadata rather than hard-coded universal assumptions.
