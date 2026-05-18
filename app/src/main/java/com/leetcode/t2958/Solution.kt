package com.leetcode.t2958

class Solution {
    fun maxSubarrayLength(nums: IntArray, k: Int): Int {
        var l = 0
        val qtyMap = mutableMapOf<Int, Int>()
        var maxLength = 0

        for (r in nums.indices) {
            val n = nums[r]
            qtyMap[n] = qtyMap.getOrDefault(n, 0) + 1
            while (qtyMap[n]!! > k) {
                val lValue = nums[l]
                qtyMap[lValue] = qtyMap[lValue]!! - 1
                l++
            }
            maxLength = maxOf(maxLength, r - l + 1)
        }

        return maxLength
    }
}