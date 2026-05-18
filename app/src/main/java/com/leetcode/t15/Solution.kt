package com.leetcode.t15

fun main() {
    println(
        Solution().threeSum(intArrayOf(-2, 0, 1, 1, 2)).joinToString()
    )
}

class Solution {

    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = hashSetOf<List<Int>>()

        for (i in nums.indices) {
            var l = i + 1
            var r = nums.size - 1
            while (l < r) {
                val sum = nums[i] + nums[l] + nums[r]

                when {
                    sum < 0 -> l++
                    sum > 0 -> r--
                    else -> result.add(listOf(nums[i], nums[l++], nums[r]))
                }
            }
        }

        return result.toList()
    }
}