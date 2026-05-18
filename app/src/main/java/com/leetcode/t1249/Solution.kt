package com.leetcode.t1249

import com.leetcode.util.print

fun main() {
    Solution().minRemoveToMakeValid("lee(t(c)o)de)").print()
    Solution().minRemoveToMakeValid("))((").print()
    Solution().minRemoveToMakeValid("a)b(c)d").print()
}

class Solution {
    fun minRemoveToMakeValid(s: String): String {
        val openBrackets = mutableListOf<Int>()
        val wrongCloseBrackets = mutableSetOf<Int>()

        for (i in s.indices) {
            when (s[i]) {
                '(' -> openBrackets += i
                ')' -> if (openBrackets.isNotEmpty()) openBrackets.removeLast() else wrongCloseBrackets += i
            }
        }

        val openBracketsSet = openBrackets.toSet()

        return s.filterIndexed { index, _ -> index !in openBracketsSet && index !in wrongCloseBrackets }
    }
}