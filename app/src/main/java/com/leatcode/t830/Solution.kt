package com.leatcode.t830

import com.leatcode.util.print

fun main() {
    Solution().largeGroupPositions("aaa").print()
}

class Solution {
    fun largeGroupPositions(s: String): List<List<Int>> {
        var curr = s[0]
        var start = 0
        val groups = mutableListOf<List<Int>>()
        s.forEachIndexed { index, c ->
            if (curr != c) {
                if (index - start >= 3) groups.add(listOf(start, index - 1))
                start = index
                curr = c
            } else if (index == s.lastIndex && index - start >= 2) {
                groups.add(listOf(start, index))
            }
        }

        return groups
    }

}