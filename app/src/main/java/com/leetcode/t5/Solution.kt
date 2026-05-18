package com.leetcode.t5

import com.leetcode.util.print

fun main() {
    Solution().longestPalindrome_On3("bb").print()
}

class Solution {

    fun longestPalindrome(s: String): String {
        var result = s.substring(0..0)
        fun expand(i: Int, j: Int) {
            if (s[i] != s[j]) return

            if (i - 1 in s.indices && j + 1 in s.indices && s[i - 1] == s[j + 1]) {
                expand(i - 1, j + 1)
            } else {
                if (result.length < j - i + 1) {
                    result = s.substring(i..j)
                }
            }
        }

        for (i in s.indices) expand(i, i)
        for (i in 0 until s.lastIndex) expand(i, i + 1)

        return result
    }


    //TODO: investigate other solutions
    fun longestPalindrome_On3(s: String): String {
        for (n in s.length downTo 2) {
            for (i in 0..s.length - n) {
                val substring = s.substring(i, i + n)
                if (isPalindrome(substring)) {
                    return substring
                }
            }
        }
        return s[0].toString()
    }

    private fun isPalindrome(s: String): Boolean {
        var l = 0
        var r = s.lastIndex
        while (l < r) {
            if (s[l++] != s[r--]) return false
        }
        return true
    }
}