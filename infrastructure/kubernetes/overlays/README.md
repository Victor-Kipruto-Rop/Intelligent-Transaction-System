# Kubernetes overlays

Separate dev/staging/prod overlays. Production sets explicit resources, autoscaling bounds, secret references, network policies, ingress/WAF, pod security and region configuration. No secrets in manifests.