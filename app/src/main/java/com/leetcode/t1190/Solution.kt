package com.leetcode.t1190

import com.leetcode.util.print

fun main() {
    Solution().reverseParentheses("(abcd)").print()
//    Solution().reverseParentheses("vdgzyj()").print()
}

class Solution {
    fun reverseParentheses(s: String): String {
        val stack = ArrayDeque<Int>()
        val result = StringBuilder()

        s.forEach { c ->
            when (c) {
                '(' -> stack.add(result.length)
                ')' -> {
                    val start = stack.removeLast()
                    if (start <= result.lastIndex) {
                        result.replace(start, result.length, result.substring(start).reversed())
                    }
                }
                else -> result.append(c)
            }
        }

        return result.toString()
    }

}