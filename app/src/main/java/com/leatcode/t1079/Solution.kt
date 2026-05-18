package com.leatcode.t1079

import com.leatcode.util.print

fun main() {
    Solution().numTilePossibilities("AAB").print()
}

class Solution {
    fun numTilePossibilities(tiles: String): Int {
        val sets = mutableSetOf<String>()
        val current = mutableListOf<Char>()
        val used = BooleanArray(tiles.length)

        fun backtrack() {
            sets.add(current.toString())
            if (current.size == tiles.length) return

            tiles.forEachIndexed { index, c ->
                if (!used[index]) {
                    current.add(c)
                    used[index] = true
                    backtrack()
                    used[index] = false
                    current.removeLast()
                }
            }
        }

        backtrack()

        return sets.size - 1
    }
}