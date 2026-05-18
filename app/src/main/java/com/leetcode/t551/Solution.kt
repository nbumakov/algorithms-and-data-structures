package com.leetcode.t551

class Solution {

    fun checkRecord(s: String): Boolean {
        var aCount = 0
        var lCount = 0
        s.forEach {
            when (it) {
                'A' -> {
                    aCount++
                    lCount = 0
                }
                'L' -> lCount++
                else -> lCount = 0
            }
            if (aCount > 1 || lCount > 2) return false
        }
        return true
    }

    fun checkRecord2(s: String): Boolean =
        s.count { it == 'A' } < 2 && !s.contains("LLL")
}