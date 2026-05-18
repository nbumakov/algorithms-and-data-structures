package com.leatcode.t560

import com.leatcode.util.print

fun main() {
//    Solution().subarraySum(intArrayOf(1, 1, 1), 2).print()
    Solution().subarraySum(intArrayOf(1, -1, 0), 0).print()
}

class Solution {

    // Using Hashmap N
    fun subarraySum(nums: IntArray, k: Int): Int {
        var count = 0
        val prefixSums = hashMapOf(0 to 1)
        var sum = 0
        for (i in nums.indices) {
            sum += nums[i]
            count += prefixSums.getOrDefault(sum - k, 0) // sum - pref = k
            prefixSums[sum] = prefixSums.getOrDefault(sum, 0) + 1
        }
        return count
    }

    // Cumulative Sum N2
    fun subarraySum1(nums: IntArray, k: Int): Int {
        var count = 0
        for (i in nums.indices) {
            var sum = 0
            for (j in i..nums.lastIndex) {
                sum += nums[j]
                if (sum == k) count++
            }
        }
        return count
    }
}