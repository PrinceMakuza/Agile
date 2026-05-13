# Sprint 0 — Product Backlog

## Product Vision
To deliver a secure, console-based banking application that allows individual users to create and manage accounts, perform financial transactions, and view account statements — demonstrating clean code, modular design, and iterative Agile delivery.

---

## User Stories

| ID    | User Story                                                                                                      | Priority (MoSCoW) | Story Points | Sprint   |
|-------|-----------------------------------------------------------------------------------------------------------------|-------------------|--------------|----------|
| US-01 | As a user, I want to create a Savings account so I can store money and earn interest.                           | Must Have         | 3            | Sprint 1 |
| US-02 | As a user, I want to create a Checking account with an overdraft limit so I can manage daily expenses.          | Must Have         | 3            | Sprint 1 |
| US-03 | As a user, I want to deposit money into my account so I can add funds at any time.                              | Must Have         | 2            | Sprint 1 |
| US-04 | As a user, I want to withdraw money from my account so I can access my funds.                                   | Must Have         | 2            | Sprint 1 |
| US-05 | As a user, I want to see clear error messages when an operation fails so I understand what went wrong.          | Should Have       | 2            | Sprint 1 |
| US-06 | As a user, I want to transfer money between accounts so I can move funds easily without visiting a branch.     | Must Have         | 3            | Sprint 2 |
| US-07 | As a user, I want to view a transaction statement for my account so I can track my financial history.           | Should Have       | 3            | Sprint 2 |
| US-08 | As an operator, I want the system to log all account and transaction events so I can audit and diagnose issues. | Could Have        | 2            | Sprint 2 |

---

## Acceptance Criteria

### US-01 — Create a Savings Account
- User can enter customer name, age, contact number, and address.
- User can choose between Regular and Premium customer types.
- System rejects initial deposits below the $500 minimum balance with a clear error.
- System generates a unique account number (e.g., `ACC001`).
- Created account appears in the "View All Accounts" list.

### US-02 — Create a Checking Account
- User can create a Checking account with any valid initial deposit.
- Account is created with a $1,000 overdraft limit.
- A monthly fee of $10 applies (automatically waived for Premium customers).
- System generates a unique account number.
- Created account appears in the "View All Accounts" list.

### US-03 — Deposit Money
- User can select an account by account number and enter a deposit amount.
- System rejects zero or negative deposit amounts.
- Account balance is updated immediately and displayed after deposit.
- Transaction is recorded with timestamp and type `DEPOSIT`.

### US-04 — Withdraw Money
- User can select an account by account number and enter a withdrawal amount.
- Savings account rejects withdrawals that would drop balance below $500 minimum.
- Checking account allows overdraft up to the $1,000 limit.
- Transaction is recorded with timestamp and type `WITHDRAWAL`.
- New balance is displayed after successful withdrawal.

### US-05 — Meaningful Error Messages
- Depositing a negative or zero amount shows "Invalid amount" error.
- Looking up a non-existent account number shows "Account not found" error.
- Exceeding the overdraft limit shows "Overdraft limit exceeded" error.
- A Savings withdrawal below minimum shows "Insufficient funds" error.
- All errors are caught and displayed without crashing the application.

### US-06 — Transfer Between Accounts
- User can transfer funds by providing source and destination account numbers.
- System prevents transferring to the same account.
- Transfer fails gracefully if the source account has insufficient funds.
- Both account balances update atomically — either both update or neither does.
- Two transactions are recorded: `TRANSFER-OUT` and `TRANSFER-IN`.

### US-07 — View Account Statement
- User can enter an account number to generate a statement.
- Statement displays all transactions: date/time, type, amount, and resulting balance.
- Statement shows a summary: total deposits, total withdrawals, and net change.
- Accounts with no transactions display "No transactions found."
- Statement is formatted clearly in a readable table.

### US-08 — Application Logging
- All account creation events are logged to `bank-app.log`.
- All transaction operations (deposit, withdrawal, transfer) are logged with amounts.
- Failed operations (invalid account lookups, capacity exceeded) log a warning.
- Log file is created or appended to at application startup.
- Log entries include timestamp and severity level (INFO / WARNING / SEVERE).

---

## Backlog Prioritization

| Priority | Stories               | Rationale                                                    |
|----------|-----------------------|--------------------------------------------------------------|
| 1 (High) | US-01, US-02          | Core entity — nothing else works without accounts.           |
| 2 (High) | US-03, US-04          | Primary value — deposits and withdrawals are the core flow.  |
| 3 (Med)  | US-05                 | Safety net — users must be informed when operations fail.    |
| 4 (Med)  | US-06                 | Key differentiator — transfers between accounts.             |
| 5 (Med)  | US-07                 | Transparency — users need to see their history.              |
| 6 (Low)  | US-08                 | Operational — logging for auditability, not end-user facing. |

**Total Estimated Effort:** 20 story points
