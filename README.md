# Algorithms & Data Structures

Kotlin solutions to algorithm problems from LeetCode, CodeRun, Codewars, and Stepik.

## Structure

```
app/src/main/java/
├── com/leatcode/
│   ├── t<N>/Solution.kt      # LeetCode problem N (~520 problems)
│   ├── util/                 # Shared types: TreeNode, ListNode, Node, IoExt
│   └── assessment/           # Timed assessment solutions
├── com/coderun/
│   └── t<N>/Solution.kt      # CodeRun problems
├── com/codewars/
│   └── Test.kt               # Codewars kata solutions
└── com/stepcalgs/
    └── group<N>/task_*/      # Stepik course tasks
```

## Build

```bash
./gradlew compileKotlin
```
