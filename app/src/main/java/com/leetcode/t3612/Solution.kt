package com.leetcode.t3612

import com.leetcode.util.print

fun main() {
    Solution().processStr("a#b%*").print()
    Solution().processStr("z*#").print()
}

// O(N) deque: a direction flag makes '%' O(1) (no per-step reversal).
class Solution {
    fun processStr(s: String): String {
        val current = ArrayDeque<Char>()
        var direction = Direction.LEFT
        s.forEach { c ->
            when (c) {
                '*' -> when (direction) {
                    Direction.LEFT -> current.removeLastOrNull()
                    Direction.RIGHT -> current.removeFirstOrNull()
                }

                '#' -> current.addAll(current.toList())
                '%' -> direction = when (direction) {
                    Direction.LEFT -> Direction.RIGHT
                    Direction.RIGHT -> Direction.LEFT
                }

                else -> when (direction) {
                    Direction.LEFT -> current.addLast(c)
                    Direction.RIGHT -> current.addFirst(c)
                }
            }
        }

        if (direction == Direction.RIGHT) current.reverse()

        return current.joinToString("")
    }

    private enum class Direction {
        LEFT,
        RIGHT
    }
}

// Spec-literal one-liner. Clear, but O(N^2): immutable String is copied on every op.
class Solution2 {
    fun processStr(s: String) = s.fold("") { r, c ->
        when (c) {
            '*' -> r.dropLast(1)
            '%' -> r.reversed()
            '#' -> r + r
            else -> r + c
        }
    }
}