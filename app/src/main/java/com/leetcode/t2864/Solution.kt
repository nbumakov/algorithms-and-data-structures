package com.leetcode.t2864

class Solution {
    fun maximumOddBinaryNumber(s: String): String {
        val onesCount = s.count { it == '1' }
        return "1".repeat(onesCount - 1) + "0".repeat(s.length - onesCount) + "1"
    }
}