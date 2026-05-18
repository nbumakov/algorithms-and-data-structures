package com.leetcode.t557

import com.leetcode.util.print

fun main() {
    Solution().reverseWordsOneLiner("Let's take LeetCode contest").print()
}

class Solution {

    fun reverseWordsOneLiner(s: String): String =
        s.split(' ').joinToString(" ") { it.reversed() }

    // reverse string then reverse words order
    fun reverseWordsOneLiner2(s: String): String =
        s.reversed().split(' ').reversed().joinToString(" ")

    fun reverseWords(s: String): String {
        var i = 0
        val resultBuilder = StringBuilder()
        val wordsBuilder = StringBuilder()

        while (i < s.length) {
            while (i < s.length && s[i] == ' ') resultBuilder.append(s[i++])
            while (i < s.length && s[i] != ' ') {
                wordsBuilder.append(s[i++])
            }
            resultBuilder.append(wordsBuilder.reversed())
            wordsBuilder.clear()
        }

        return resultBuilder.toString()
    }

}