# Sprint 1 Plan

**Sprint Duration:** 2 weeks  
**Sprint Goal:** Establish the core account management foundation — users can create Savings and Checking accounts, deposit and withdraw funds, and receive meaningful error feedback. The CI/CD pipeline is operational.

---

## Selected User Stories

| ID    | Story Summary                                         | Story Points |
|-------|-------------------------------------------------------|--------------|
| US-01 | Create a Savings account                              | 3            |
| US-02 | Create a Checking account                             | 3            |
| US-03 | Deposit money into an account                         | 2            |
| US-04 | Withdraw money from an account                        | 2            |
| US-05 | Meaningful error messages for failed operations       | 2            |
| **Total** |                                                   | **12 SP**    |

---

## Sprint Tasks

| Task                                                            | Story | Owner |
|-----------------------------------------------------------------|-------|-------|
| Initialize Maven project (pom.xml, .gitignore, README)         | Setup | Prince |
| Implement `Account` abstract base class                         | US-01, US-02 | Prince |
| Implement `SavingsAccount` with minimum balance rule           | US-01 | Prince |
| Implement `CheckingAccount` with overdraft rule                | US-02 | Prince |
| Implement `Customer`, `RegularCustomer`, `PremiumCustomer`     | US-01, US-02 | Prince |
| Implement `Transaction` model with timestamp                   | US-03, US-04 | Prince |
| Implement custom exceptions (4 classes)                        | US-05 | Prince |
| Implement `AccountManager` (add, get, list accounts)           | US-01, US-02 | Prince |
| Implement deposit and withdrawal in `Account`                  | US-03, US-04 | Prince |
| Implement console `Main` with account and transaction menus    | All   | Prince |
| Write JUnit 5 unit tests (`AccountTest`, `ExceptionTest`)      | US-03–05 | Prince |
| Set up GitHub Actions CI pipeline                              | Setup | Prince |

---

## Sprint 1 Velocity Target
12 story points
