# Sprint 1 Retrospective

**Sprint:** Sprint 1  
**Date:** End of Sprint 1

---

## What Went Well

1. **Clean domain model from the start.** Separating `Account`, `Customer`, and `Transaction` into distinct classes made it easy to add `SavingsAccount` and `CheckingAccount` without modifying existing code.

2. **Custom exceptions caught edge cases early.** Writing `InsufficientFundsException`, `OverdraftExceededException`, `InvalidAmountException`, and `InvalidAccountException` in Sprint 1 meant that business rules were enforced from the first transaction test, and the tests caught real bugs during development.

3. **GitHub Actions CI was quick to set up.** The Maven build pipeline was running within an hour of writing the YAML. Having automated test feedback on every push removed the risk of forgetting to run tests manually.

4. **All 5 planned stories were delivered.** The sprint velocity target of 12 story points was hit exactly, giving confidence in the story point estimates for Sprint 2.

---

## What Didn't Go Well

1. **Vague commit messages made history hard to read.** Several commits were named `commit_1.2`, `commit_1.3`, etc., which provides no information about what changed. When reviewing the history, it was impossible to tell which commit introduced the savings account minimum balance rule versus the overdraft logic.

2. **All work was committed directly to `main` with no feature branch.** This meant that in-progress, incomplete code was visible on the main branch throughout the sprint. If a reviewer or collaborator checked out `main` mid-sprint, they would have seen a broken state.

---

## Improvements for Sprint 2

| # | Problem Identified                          | Specific Improvement                                                                                  |
|---|---------------------------------------------|-------------------------------------------------------------------------------------------------------|
| 1 | Vague commit messages are unreadable        | Adopt the **Conventional Commits** format: `type(scope): short description` (e.g., `feat(models): add SavingsAccount with minimum balance rule`) |
| 2 | Committing directly to `main` is risky      | Create a dedicated **`feature/sprint-2` branch** from `main`, do all Sprint 2 work there, and merge only after the CI pipeline passes |

These two improvements will make the project history a reliable audit trail and keep `main` always in a deployable state.
