# CI/CD Guide

This project uses GitHub Actions for both CI and CD.

## Workflows

- `.github/workflows/maven-ci.yml`
  - Runs on push and pull requests to `main`/`master`
  - Builds and verifies the project with Maven (`mvn -B clean verify`)
- `.github/workflows/maven-cd.yml`
  - Runs on tag push matching `v*` (for example: `v1.0.0`)
  - Builds the Spring Boot JAR (`mvn -B clean package`)
  - Uploads the JAR as a workflow artifact
  - Publishes a GitHub Release with the JAR attached

## Release Process

1. Ensure CI is green on `main`.
2. Create and push a version tag:

```bash
git tag v1.0.0
git push origin v1.0.0
```

3. GitHub Actions will create a Release automatically.

## Notes

- The CD workflow uses the built-in `GITHUB_TOKEN`; no extra secret is required for releases in the same repository.
- Java version is set to `23` to match `pom.xml`.

