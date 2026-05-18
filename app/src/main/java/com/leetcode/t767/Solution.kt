package com.leetcode.t767

import com.leetcode.util.print

fun main() {
    Solution().reorganizeString("aab").print()
}

class Solution {
    fun reorganizeString(s: String): String {
        val map = hashMapOf<Char, Int>().apply {
            s.forEach { this[it] = getOrDefault(it, 0) + 1 }
        }

        val dq = ArrayDeque<Char>(s.length)
        map.toList()
            .sortedBy { it.second }
            .forEach { (c, count) -> repeat(count) { dq.add(c) } }

        val result = CharArray(s.length)
        for (i in s.indices step 2) {
            result[i] = dq.removeLast()
        }
        for (i in 1 until s.length step 2) {
            result[i] = dq.removeLast()
            if (result[i - 1] == result[i]
                || i < s.lastIndex && result[i + 1] == result[i]
            ) return ""
        }
        return result.joinToString("")
    }
}