package com.leetcode.t1523

class Solution {
    fun countOdds(low: Int, high: Int): Int {
        var difference = (high - low) / 2
        if (low % 2 == 1 || high % 2 == 1) difference++
        return difference
    }

    fun countOdds2(low: Int, high: Int) =
        ((high + 1) / 2) - (low / 2)
}