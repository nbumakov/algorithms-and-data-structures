package com.leetcode.t151

import com.leetcode.util.print

fun main() {
//    println("  hello world  ".split(" "))
    Solution().reverseWordsFast("  hello world  ").print()
}

class Solution {
    fun reverseWordsFast(s: String): String {
        var i = s.lastIndex
        val resultBuilder = StringBuilder()
        val wordsBuilder = StringBuilder()

        while (i >= 0) {
            while (i >= 0 && s[i] == ' ') i--
            while (i >= 0 && s[i] != ' ') {
                wordsBuilder.append(s[i--])
            }
            if (wordsBuilder.isNotEmpty()) {
                if (resultBuilder.isNotEmpty()) {
                    resultBuilder.append(' ')
                }
                resultBuilder.append(wordsBuilder.reversed())
                wordsBuilder.clear()
            }
        }

        return resultBuilder.toString()
    }

    fun reverseWords(s: String): String =
        s.split(" ")
            .filter { it.isNotBlank() }
            .reversed()
            .joinToString(" ")
}