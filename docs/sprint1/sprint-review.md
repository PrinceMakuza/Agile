# Sprint 1 Review

**Sprint Duration:** 2 weeks  
**Sprint Goal:** Establish the core account management foundation — account creation, deposits, withdrawals, and error handling.  
**Review Date:** End of Sprint 1

---

## Stories Completed

| ID    | Story Summary                                   | Story Points | Status    |
|-------|-------------------------------------------------|--------------|-----------|
| US-01 | Create a Savings account                        | 3            | Done      |
| US-02 | Create a Checking account                       | 3            | Done      |
| US-03 | Deposit money into an account                   | 2            | Done      |
| US-04 | Withdraw money from an account                  | 2            | Done      |
| US-05 | Meaningful error messages for failed operations | 2            | Done      |
| **Total Delivered** |                                   | **12 SP**    |           |

All 5 planned stories were completed and meet the Definition of Done.

---

## Increment Demonstration

### US-01 & US-02 — Account Creation
- A user can select **Manage Accounts → Create Account** from the main menu.
- The system prompts for customer name, age, contact, address, and customer type (Regular/Premium).
- Selecting **Savings** enforces the $500 minimum initial deposit rule.
- Selecting **Checking** accepts any deposit and applies a $1,000 overdraft limit.
- The system generates a unique account number (e.g., `ACC001`) and confirms creation.

```
Account Type:
1. Savings (Interest: 3.5%, Min balance $500)
2. Checking (Overdraft: $1,000, Monthly Fee: $10)

Enter initial deposit: $600
✅ Account created successfully. Account Number: ACC001
```

### US-03 & US-04 — Deposit and Withdrawal
- A user selects **Perform Transactions**, enters an account number, and chooses Deposit or Withdrawal.
- The system validates amounts, updates the balance, and records the transaction.

```
Enter Account Number: ACC001
1. Deposit  2. Withdrawal  3. Transfer  0. Back
Select type: 1
Enter amount: $300
Confirm deposit of $300.00 (Y/N): Y
✅ Deposit successful. New balance: $900.00
```

### US-05 — Error Messages
Custom exceptions are thrown and caught at every invalid operation:

| Scenario                            | Exception                    | User Message                                         |
|-------------------------------------|------------------------------|------------------------------------------------------|
| Deposit ≤ 0                         | `InvalidAmountException`     | "Invalid amount. Amount must be greater than 0."     |
| Account number not found            | `InvalidAccountException`    | "Account not found. Please check the account number."|
| Savings withdrawal below minimum    | `InsufficientFundsException` | "Insufficient funds. Balance below $500 minimum."    |
| Checking overdraft exceeded         | `OverdraftExceededException` | "Overdraft limit exceeded. Maximum overdraft is $1,000." |

---

## CI/CD Pipeline
- GitHub Actions workflow is live at `.github/workflows/ci.yml`.
- Pipeline runs on every push to `main` and `feature/**` branches.
- Stages: **Compile → Test → Upload test results as artifact**.
- All pipeline runs for Sprint 1 passed successfully.

---

## Test Results
- **8 unit tests** across `AccountTest.java` and `ExceptionTest.java`.
- All tests pass: `mvn test` exits with code 0.

| Test Class     | Tests | Passed | Failed |
|----------------|-------|--------|--------|
| AccountTest    | 5     | 5      | 0      |
| ExceptionTest  | 5     | 5      | 0      |

---

## What Was Not Completed
- US-06 (Transfer), US-07 (Statement), US-08 (Logging) are deferred to Sprint 2 as planned.

---

## Stakeholder Feedback
- Core account creation and transaction flow works end-to-end.
- Error messages are clear and prevent application crashes.
- Requested: add fund transfers between accounts in Sprint 2.
