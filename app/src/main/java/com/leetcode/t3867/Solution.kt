package com.leetcode.t3867

import kotlin.math.max

class Solution {
    fun gcdSum(nums: IntArray): Long {
        // Let mxi = max(nums[0], nums[1], ..., nums[i]).
        val mx = IntArray(nums.size) { nums[it] }
        for (i in 1..nums.lastIndex) {
            mx[i] = max(mx[i - 1], mx[i])
        }

        // prefixGcd[i] = gcd(nums[i], mxi).
        val prefixGcd = IntArray(nums.size) { gcd(nums[it], mx[it]) }

        // Sort prefixGcd in non-decreasing order.
        prefixGcd.sort()

        // Form pairs by taking the smallest unpaired element and the largest unpaired element.
        // For each formed pair, compute the gcd of the two elements.
        // Return an integer denoting the sum of the GCD values of all formed pairs.
        var res = 0L
        for (i in 0 until nums.size / 2) {
            res += gcd(prefixGcd[i], prefixGcd[nums.lastIndex - i])
        }

        return res
    }

    private fun gcd(a: Int, b: Int): Int {
        if (b == 0) return a
        return gcd(b, a % b)
    }
}

// One-pass prefix build + two-pointer pairing (see hints 1-4).
class Solution2 {
    fun gcdSum(nums: IntArray): Long {
        // Hint 1: running prefix maximum, prefixGcd[i] = gcd(nums[i], mxi).
        var mx = 0
        val prefixGcd = IntArray(nums.size) {
            mx = max(mx, nums[it])
            gcd(nums[it], mx)
        }

        // Hint 2: sort in non-decreasing order.
        prefixGcd.sort()

        // Hints 3-4: pair smallest with largest; a middle element (odd n) is skipped.
        var res = 0L
        var lo = 0
        var hi = nums.lastIndex
        while (lo < hi) {
            res += gcd(prefixGcd[lo++], prefixGcd[hi--])
        }
        return res
    }

    private fun gcd(a: Int, b: Int): Int {
        if (b == 0) return a
        return gcd(b, a % b)
    }
}