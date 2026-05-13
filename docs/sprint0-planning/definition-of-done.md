# Definition of Done (DoD)

A user story is considered **Done** only when ALL of the following criteria are met:

## Code Quality
- [ ] Code compiles without errors: `mvn clean compile`
- [ ] All acceptance criteria for the story are implemented and verified manually
- [ ] Code follows Google Java Style Guide (2-space indentation, meaningful names)
- [ ] Javadoc is present on all public classes and methods
- [ ] No dead code, commented-out blocks, or TODO items left in the commit

## Testing
- [ ] Unit tests are written for all new business logic
- [ ] All existing tests continue to pass: `mvn test`
- [ ] Edge cases (e.g., invalid input, boundary values) are covered

## Version Control
- [ ] Work is done on a dedicated feature branch (e.g., `feature/sprint-1`)
- [ ] Commit messages follow the conventional format: `type(scope): description`
  - Types: `feat`, `fix`, `test`, `docs`, `ci`, `chore`, `refactor`
- [ ] Feature branch is merged into `main` after the sprint

## CI/CD
- [ ] GitHub Actions pipeline passes (build + tests) before merging to `main`
- [ ] No pipeline failures left unresolved

## Documentation
- [ ] Any new feature is reflected in `README.md` if it affects how to run/use the system
- [ ] Sprint Review document is updated with the completed story
