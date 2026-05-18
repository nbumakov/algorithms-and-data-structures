package com.leetcode.t680

import com.leetcode.util.print

fun main() {
    Solution()
        .validPalindrome("deddde")
        .print()
}

class Solution {

    // abcca
    fun validPalindrome(s: String): Boolean {
        var p1 = 0
        var p2 = s.lastIndex
        while (p1 < p2) {
            if (s[p1] == s[p2]) {
                p1++
                p2--
            } else {
                return isPalindrome(s.substring(0 until p1) + s.substring(p1 + 1..s.lastIndex))
                        || isPalindrome(s.substring(0 until p2) + s.substring(p2 + 1..s.lastIndex))
            }
        }
        return true
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