# Identity Management (IDM) API

## Summary
IDM API aims to manage the Identity Lifecycle going from User Creation to Authentication and Authorization in a Zero-Knowledge Architecture.

## Requirements
### Functional Requirements:
1. Support OAuth 2: The system should provide support for the OAuth 2 authentication protocol.
2. Support OpenID (Connect): The system should support the OpenID Connect protocol for authentication and identity management.
3. Support HTTP Basic + JWT: The system should support HTTP Basic authentication and JSON Web Tokens (JWT) for authentication and authorization.

### Non-Functional Requirements:
1. Using REST (HATEOAS) as System Architecture: The system architecture should follow the principles of REST (Representational State Transfer) and HATEOAS (Hypermedia as the Engine of Application State).
2. Zero-Knowledge Architecture (E2E Encryption): The system should implement a zero-knowledge architecture with end-to-end encryption (E2E) for data confidentiality and integrity.

### Specifications:
- Programming Language: Java (17) + Gradle (Kotlin)
- Frameworks:
    - Spring Webflux
    - Spring Data
    - Spring HATEOAS
- Databases: Redis
- Support LDAP as Back-End

## Proof-of-Concept (v1)
### Mandatory Requirements
* HTTP Basic + JWT
* Support LDAP as Back-End
