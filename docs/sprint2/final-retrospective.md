# Sprint 2 — Final Retrospective

**Sprint:** Sprint 2 (Final)  
**Date:** End of Sprint 2

---

## What Went Well

1. **Conventional commits transformed the project history.** Switching to `feat(services): ...`, `test: ...`, `ci: ...` prefixes made every commit self-documenting. Looking back at the log now clearly shows when the `TransactionManager` was added versus when logging was integrated — no guesswork.

2. **The `feature/sprint-2` branch kept `main` stable throughout the sprint.** While in-progress code was being written and iterated on the feature branch, `main` always remained in a working, deployable state. This is a pattern worth carrying into every project.

3. **The `TransactionManagerTest` caught a real edge case.** Writing `transferFailsOnInsufficientFunds` exposed that the transfer method needed to validate funds *before* executing the withdrawal — the test confirmed the correct ordering of validation and execution.

4. **`ApplicationLogger` works as a drop-in audit trail.** Integrating logging required no changes to the public API of `AccountManager` or `TransactionManager` — only adding two import lines and log calls. The `bank-app.log` file now provides a timestamped record of every account creation and transaction without affecting application behavior.

5. **Full backlog delivered on time.** All 8 user stories (20 story points) were completed across two sprints, demonstrating that the upfront estimation and planning in Sprint 0 was realistic and effective.

---

## What Didn't Go Well

1. **In-memory data structures limit the system.** Using fixed-size arrays (`Account[50]`, `Transaction[200]`) means all data is lost when the application exits. A real banking system would require persistent storage (a database or file system). This was a known simplification, but it became more apparent in Sprint 2 when demonstrating the statement generator — the data resets on every run.

2. **No end-to-end integration test.** Unit tests verify individual components in isolation, but there is no test that exercises the full flow: create account → deposit → transfer → generate statement. Such a test would catch integration-level bugs (e.g., account number counter state affecting other tests) that unit tests miss.

---

## Key Lessons Learned

| Lesson                                                                         | Takeaway                                                                                   |
|--------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------|
| Good commit messages are as valuable as good code                              | Future-you and teammates read git history more than source comments.                       |
| Writing the Definition of Done upfront prevents scope creep                    | Each story had clear acceptance criteria, so "done" was never ambiguous.                   |
| Retrospective improvements must be concrete and actionable                     | "Write better commits" is vague. "Use Conventional Commits format on every commit" is not. |
| Feature branches protect the main branch during development                    | One push to a stable `main` is worth more than ten pushes to a chaotic one.                |
| CI catches regressions before they reach `main`                                | The pipeline failed once on a compilation error caught before merge — exactly as designed. |

---

## Recommendations for Future Sprints

1. **Add persistence** — Replace in-memory arrays with file-based or database storage so account data survives restarts.
2. **Add an end-to-end integration test** — A single test that runs the full account → transaction → statement flow would increase confidence during refactoring.
3. **Add a health endpoint or status command** — A simple `HEALTH` menu option that prints system stats (account count, transaction count, log file location) would improve operability.
