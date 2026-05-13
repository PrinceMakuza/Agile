# Sprint 2 Review

**Sprint Duration:** 2 weeks  
**Sprint Goal:** Complete the full transaction lifecycle with fund transfers and account statements, and add structured logging for system observability. Apply Sprint 1 retrospective improvements.  
**Review Date:** End of Sprint 2

---

## Process Improvements Applied

| Improvement from Sprint 1 Retro              | Applied?                                                                |
|----------------------------------------------|-------------------------------------------------------------------------|
| Adopt conventional commit message format     | Yes — all Sprint 2 commits follow `type(scope): description` convention |
| Use `feature/sprint-2` branch, merge to main | Yes — all work was done on `feature/sprint-2` and merged after CI pass  |

---

## Stories Completed

| ID    | Story Summary                                   | Story Points | Status |
|-------|-------------------------------------------------|--------------|--------|
| US-06 | Transfer money between accounts                 | 3            | Done   |
| US-07 | View account transaction statement              | 3            | Done   |
| US-08 | Application logging for audit and diagnostics   | 2            | Done   |
| **Total Delivered** |                                   | **8 SP**     |        |

All 3 planned stories were completed and meet the Definition of Done.  
**Cumulative velocity: 20 story points — full backlog completed.**

---

## Increment Demonstration

### US-06 — Transfer Between Accounts
- A user selects **Perform Transactions → Transfer** and enters source and destination account numbers.
- The system prevents same-account transfers and validates sufficient funds.
- Balances update atomically — both `TRANSFER-OUT` and `TRANSFER-IN` transactions are recorded.

```
Enter Account Number: ACC001
Select type: 3
Enter amount: $200.00
Enter Destination Account Number: ACC002
Confirm transfer of $200.00 to Account ACC002 (Y/N): Y
✅ Transfer successful.
```

### US-07 — Account Statement
- A user selects **Generate Account Statements** and enters an account number.
- The system displays all transactions in a formatted table with a net change summary.

```
GENERATE ACCOUNT STATEMENT
--------------------------
Account Number: ACC001
Account Name: John Smith (Savings)
Current Balance: $4,900.00

TXN001 | 13-05-2026 09:15 AM | DEPOSIT      |    500.00 | 5,750.00
TXN002 | 13-05-2026 09:20 AM | WITHDRAWAL   |    350.00 | 5,400.00
TXN003 | 13-05-2026 09:25 AM | TRANSFER-OUT |    200.00 | 5,200.00

Net Change: -$50.00
```

### US-08 — Application Logging
- `ApplicationLogger` (in `utils/`) uses `java.util.logging` with two handlers:
  - **FileHandler** — writes all events (INFO and above) to `bank-app.log` in the project root.
  - **ConsoleHandler** — surfaces WARNING and SEVERE messages to the console for immediate visibility.
- Logged events include: account creation, every transaction recorded, failed account lookups, and transfer initiation.

Sample log entries from `bank-app.log`:
```
May 13, 2026 9:15:00 AM services.AccountManager addAccount
INFO: Account created: ACC001 (Savings) for John Smith
May 13, 2026 9:20:00 AM services.TransactionManager addTransaction
INFO: Transaction recorded: [ACC001] WITHDRAWAL | $350.00
May 13, 2026 9:25:00 AM services.TransactionManager transfer
INFO: Transfer initiated: $200.00 from ACC001 to ACC002
```

---

## CI/CD Pipeline
- All Sprint 2 commits on `feature/sprint-2` triggered the pipeline and passed.
- The merge commit to `main` also passed.
- Test artifact (surefire reports) is uploaded on every run.

---

## Test Results
- **11 unit tests** across `AccountTest.java`, `ExceptionTest.java`, and `TransactionManagerTest.java`.
- All tests pass after Sprint 2 changes.

| Test Class              | Tests | Passed | Failed |
|-------------------------|-------|--------|--------|
| AccountTest             | 5     | 5      | 0      |
| ExceptionTest           | 5     | 5      | 0      |
| TransactionManagerTest  | 3     | 3      | 0      |

---

## Stakeholder Feedback
- Full transaction lifecycle (create → deposit → withdraw → transfer → statement) works end-to-end.
- Log file provides a clear audit trail of all account operations.
- Suggestion for future work: add a persistence layer (file or database) so accounts survive restarts.
