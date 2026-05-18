package com.leetcode.t392

class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        var pt = 0

        for (sChar in s) {
            while (pt < t.length && t[pt] != sChar) pt++
            if (pt == t.length) return false
            pt++
        }

        return true
    }
}