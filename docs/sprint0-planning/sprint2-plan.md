# Sprint 2 Plan

**Sprint Duration:** 2 weeks  
**Sprint Goal:** Complete the full transaction lifecycle by adding fund transfers and account statements, and introduce structured application logging to improve observability. Apply the two process improvements identified in the Sprint 1 retrospective.

---

## Process Improvements from Sprint 1 Retrospective

| # | Improvement                                            | How Applied in Sprint 2                                     |
|---|--------------------------------------------------------|-------------------------------------------------------------|
| 1 | Adopt conventional commit message format               | Every commit follows `type(scope): description` convention  |
| 2 | Use a dedicated feature branch (`feature/sprint-2`)   | All Sprint 2 work is branched from `main` and merged via PR |

---

## Selected User Stories

| ID    | Story Summary                                         | Story Points |
|-------|-------------------------------------------------------|--------------|
| US-06 | Transfer money between accounts                       | 3            |
| US-07 | View account transaction statement                    | 3            |
| US-08 | Application logging for audit and diagnostics         | 2            |
| **Total** |                                                   | **8 SP**     |

---

## Sprint Tasks

| Task                                                               | Story | Owner |
|--------------------------------------------------------------------|-------|-------|
| Add `Transactable` interface for account operation contract        | US-06 | Prince |
| Implement `ValidationUtils` for business rule validation           | US-06, US-08 | Prince |
| Implement `InputValidator` for safe console user input             | US-06, US-07 | Prince |
| Implement `TransactionManager` with transfer support               | US-06 | Prince |
| Implement `StatementGenerator` service                             | US-07 | Prince |
| Implement `ApplicationLogger` utility using `java.util.logging`    | US-08 | Prince |
| Integrate logging into `AccountManager` and `TransactionManager`   | US-08 | Prince |
| Update `Main` with transfers, statement generation, and full menus | US-06, US-07 | Prince |
| Add `TransactionManagerTest` for transfer operations               | US-06 | Prince |
| Merge `feature/sprint-2` into `main` after pipeline passes        | Setup | Prince |

---

## Sprint 2 Velocity Target
8 story points  
**Cumulative:** 20 story points (full backlog)
