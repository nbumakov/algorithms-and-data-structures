package com.leetcode.t2962

fun main() {
    val nums = intArrayOf(1, 3, 2, 3, 3)
    val k = 2
    val result = Solution().countSubarrays(nums, k)
    println(result) // Output: 6
}

class Solution {

    // [1,3,2,3,3]
    fun countSubarrays(nums: IntArray, k: Int): Long {
        var result = 0L
        val max = nums.max()

        var maxElementsInWindow = 0
        var start = 0
        for (end in nums.indices) {
            if (nums[end] == max) maxElementsInWindow++
            while (maxElementsInWindow == k) {
                if (nums[start] == max) maxElementsInWindow--
                start++
            }
            result += start
        }

        return result
    }
}