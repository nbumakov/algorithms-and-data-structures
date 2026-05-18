package com.leetcode.t168

import com.leetcode.util.print

fun main() {
    Solution().convertToTitle(701).print()
}

class Solution {
    fun convertToTitle(columnNumber: Int): String {
        val sb = StringBuilder()
        var x = columnNumber
        while (x > 0) {
            x--
            sb.append('A' + x % 26)
            x /= 26
        }
        return sb.reversed().toString()
    }
}