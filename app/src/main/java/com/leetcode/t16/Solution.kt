package com.leetcode.t16

import com.leetcode.util.print
import kotlin.math.abs

fun main() {
    Solution()
        .threeSumClosest(intArrayOf(4, 0, 5, -5, 3, 3, 0, -4, -5), -2)
        .print()
}

class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()

        var closestSum = Int.MAX_VALUE

        for (i in 0..nums.size - 3) {
            var l = i + 1
            var r = nums.size - 1
            while (l < r) {
                val sum = nums[i] + nums[l] + nums[r]

                when {
                    sum < target -> l++
                    else -> r--
                }
                if (abs(target - sum) < abs(target - closestSum)) {
                    closestSum = sum
                }
            }
        }

        return closestSum
    }

}