package com.leatcode.t1930

class Solution {
    fun countPalindromicSubsequence(s: String): Int {
        val set = hashSetOf<String>()

        for (i in 1 until s.lastIndex) {
            if (s[i - 1] == s[i + 1]) {
                set.add(s.substring(i - 1, i + 1))
            }
        }

        return set.size
    }
}