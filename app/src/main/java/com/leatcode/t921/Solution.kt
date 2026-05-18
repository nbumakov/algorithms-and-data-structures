package com.leatcode.t921

import com.leatcode.util.print

fun main() {
    Solution().minAddToMakeValid("())").print()
    Solution().minAddToMakeValid("(((").print()
}

class Solution {
    fun minAddToMakeValid(s: String): Int {
        var openBrackets = 0
        var inserts = 0

        for (c in s) {
            when (c) {
                '(' -> openBrackets++
                ')' -> if (openBrackets > 0) openBrackets-- else inserts++
            }
        }
        return inserts + openBrackets
    }
}