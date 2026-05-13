# Bank Account Management System

A console-based banking application built with Java 21, demonstrating Agile delivery, clean code principles, modular design, and a CI/CD pipeline.

## Features
- Create and manage Savings and Checking accounts
- Perform deposits, withdrawals, and transfers
- Generate detailed account transaction statements
- Custom exceptions for robust error handling
- Structured application logging via `java.util.logging`
- JUnit 5 test suite with GitHub Actions CI

## Project Structure
```
bank-account-management-system/
├── .github/workflows/ci.yml
├── src/
│   ├── main/java/
│   │   ├── Main.java
│   │   ├── interfaces/
│   │   ├── models/
│   │   ├── exceptions/
│   │   ├── services/
│   │   └── utils/
│   └── test/java/
├── docs/
│   ├── sprint0-planning/
│   ├── sprint1/
│   └── sprint2/
└── pom.xml
```

## How to Run
1. Ensure Java 21 is installed.
2. Run with Maven: `mvn clean compile exec:java -Dexec.mainClass="Main"`

## How to Test
```
mvn test
```

## CI/CD
GitHub Actions runs the build and test suite on every push to `main` and `feature/**` branches.
