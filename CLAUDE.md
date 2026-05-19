# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build & Test Commands

```bash
# Build the project
./gradlew assembleDebug

# Run unit tests
./gradlew test

# Run a single test class
./gradlew test --tests "com.example.stepcalgs.MainActivityKtTest"

# Run all checks (build + test)
./gradlew check
```

## Architecture

This is an Android project (Kotlin, minSdk 26, compileSdk 33) used as a scratchpad for algorithm and data structures practice. There is no UI beyond a stub `MainActivity` — all logic runs via `main()` functions or unit tests.

### Package structure

- **`com.leetcode.t<N>/`** — One `Solution.kt` per LeetCode problem number (~500+ problems). Each file is standalone; solutions are self-contained functions or classes.
- **`com.leetcode.util/`** — Shared data structures used across LeetCode solutions:
  - `TreeNode` — binary tree node with helpers (`isHeightBalanced`, `getHeight`, `printDfs`)
  - `ListNode` — linked list node
  - `Node` — generic graph/tree node
  - `IoExt.kt` — `Any?.print()` extension that pretty-prints trees, linked lists, and arrays
- **`com.leetcode.assessment/`** — Solutions from timed assessments
- **`com.coderun.t<N>/`** — Solutions from CodeRun (separate platform, similar structure)
- **`com.codewars/`** — Solutions from Codewars
- **`com.example/`** — Kotlin language experiments: coroutines (`callbackFlow`, `flatMapConcat`, `Mutex`), collections, exception handling, etc.
- **`com.example.mutex/`** — A custom `ReadWriteMutex` implementation built on top of kotlinx.coroutines `Mutex`, with `ReadWriteMutexImpl`, `ReadWriteMutexBuilder`, and state/mode enums.

### Adding a new LeetCode solution

Create `app/src/main/java/com/leetcode/t<N>/Solution.kt` with `package com.leetcode.t<N>`. Import `com.leetcode.util.*` if the problem involves trees or linked lists.

### Testing

Unit tests live in `app/src/test/`. The project uses JUnit 4. There are only two test files currently — most solutions are validated by running `main()` directly.
