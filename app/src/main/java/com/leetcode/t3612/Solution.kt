package com.leetcode.t3612

import com.leetcode.util.print
import java.util.LinkedList

fun main() {
    Solution().processStr("a#b%*").print()
    Solution().processStr("z*#").print()
}

class Solution {
    fun processStr(s: String): String {
        val ll = LinkedList<Char>()
        var direction = Direction.LEFT
        s.forEach { c ->
            when (c) {
                '*' -> when (direction) {
                    Direction.LEFT -> ll.removeLastOrNull()
                    Direction.RIGHT -> ll.removeFirstOrNull()
                }

                '#' -> ll.addAll(ll)
                '%' -> direction = when (direction) {
                    Direction.LEFT -> Direction.RIGHT
                    Direction.RIGHT -> Direction.LEFT
                }

                else -> when (direction) {
                    Direction.LEFT -> ll.addLast(c)
                    Direction.RIGHT -> ll.addFirst(c)
                }
            }
        }

        if (direction == Direction.RIGHT) ll.reverse()

        return ll.joinToString("")
    }

    private enum class Direction {
        LEFT,
        RIGHT
    }
}