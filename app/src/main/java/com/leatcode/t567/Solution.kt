package com.leatcode.t567

import com.leatcode.util.print

fun main() {
    Solution().checkInclusion("ab", "eidbaooo").print()
}

class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s2.length < s1.length) return false

        val s1QtyMap = IntArray(26)
        s1.forEach { s1QtyMap[it.index()] += 1 }

        val s2QtyMap = IntArray(26)
        s2.take(s1.length - 1).forEach { s2QtyMap[it.index()] += 1 }

        for (i in s1.lastIndex until s2.length) {
            s2QtyMap[s2[i].index()] += 1
            if (s1QtyMap.contentEquals(s2QtyMap)) return true
            s2QtyMap[s2[i - s1.lastIndex].index()] -= 1
        }

        return false
    }

    private fun Char.index() = this - 'a'
}