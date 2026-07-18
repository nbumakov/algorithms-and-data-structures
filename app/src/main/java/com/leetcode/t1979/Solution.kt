package com.leetcode.t1979

class Solution {
    fun findGCD(nums: IntArray): Int =
        gcd(nums.min(), nums.max())

    private fun gcd(a: Int, b: Int): Int {
        if (b == 0) return a
        return gcd(b, a % b)
    }
}

class Solution2 {
    fun findGCD(nums: IntArray): Int {
        var min = nums[0]
        var max = nums[0]
        for (n in nums) {
            if (n < min) min = n
            if (n > max) max = n
        }
        while (min != 0) {
            val rem = max % min
            max = min
            min = rem
        }
        return max
    }
}