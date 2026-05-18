package com.leatcode.t942

import com.leatcode.util.print

fun main() {
    Solution().diStringMatch("IDID").print()
}

class Solution {
    fun diStringMatch(s: String): IntArray {
        var min = 0
        var max = s.length

        val result = IntArray(s.length + 1)
        s.forEachIndexed { index, c ->
            result[index] = if (c == 'I') min++ else max--
        }
        result[result.lastIndex] = min

        return result
    }
}