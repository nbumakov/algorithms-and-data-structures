package com.leetcode.t3300

class Solution {
    fun minElement(nums: IntArray): Int {
        var best = Int.MAX_VALUE
        for (n in nums) {
            var x = n
            var s = 0
            while (x > 0) {
                s += x % 10
                x /= 10
            }
            if (s < best) best = s
        }
        return best
    }
}
