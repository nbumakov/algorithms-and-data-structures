# Algorithms & Data Structures

Kotlin solutions to algorithm problems from LeetCode, CodeRun, Codewars, and Stepik.

## Structure

| Package | Problems | Description |
|---------|----------|-------------|
| `com.leatcode` | 517 | LeetCode — each problem in `t<N>/Solution.kt` |
| `com.coderun` | 10 | CodeRun — each problem in `t<N>/Solution.kt` |
| `com.codewars` | — | Codewars kata solutions |
| `com.stepcalgs` | — | Stepik course tasks |

Shared data structures used across LeetCode solutions live in `com.leatcode.util`: `TreeNode`, `ListNode`, `Node`, and `IoExt` (a `print()` extension for pretty-printing trees, lists, and arrays).

## Build

```bash
./gradlew compileKotlin
```

Kotlin 2.3.21 · Coroutines 1.11.0 · Gradle 9.5.1 · JVM 21
