package com.leetcode.t907

import kotlin.math.min

class Solution {
    fun sumSubarrayMins(arr: IntArray): Int {
        var sum = 0
        var currMin = 0
        for (i in 0..arr.lastIndex) {
            currMin = arr[i]
            for (j in i..arr.lastIndex) {
                currMin = min(currMin, arr[j])
                sum = (sum + currMin) % 1_000_000_007
            }
        }
        return sum
    }
}