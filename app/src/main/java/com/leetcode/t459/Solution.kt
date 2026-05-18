package com.leetcode.t459

import com.leetcode.util.print

fun main() {
//    Solution().repeatedSubstringPattern("abab").print()
    Solution().repeatedSubstringPattern("aba").print()
//    Solution().repeatedSubstringPattern("abcabcabcabc").print()
}

class Solution {
    fun repeatedSubstringPattern(s: String): Boolean {
        var p = 0
        for (step in 1..s.length / 2) {
            if (s.length % step != 0) continue
            while (p <= s.lastIndex - step) {
                if (s[p] != s[p + step]) break
                p++
            }
            if (p == s.length - step) return true
            p = 0
        }
        return false
    }
}