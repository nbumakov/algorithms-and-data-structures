package com.leetcode.t2439

import com.leetcode.util.print
import kotlin.math.ceil

fun main() {
    Solution().minimizeArrayValue(intArrayOf(3, 7, 1, 6)).print()
//    Solution().minimizeArrayValue(intArrayOf(6, 9, 3, 8, 14)).print()
}

class Solution {

    fun minimizeArrayValue(nums: IntArray): Int {
        var prefixSum = 0L
        var max = 0L
        for (i in 0..nums.lastIndex) {
            prefixSum += nums[i]
            max = maxOf(max, ceil(prefixSum.toDouble() / (i + 1)).toLong())
        }
        return max.toInt()
    }

    // TLE
    fun minimizeArrayValue1(nums: IntArray): Int {
        var wereChanges: Boolean
        do {
            wereChanges = false
            for (i in 1..nums.lastIndex) {
                if (nums[i - 1] < nums[i]) {
                    val a = (nums[i - 1] + nums[i] + 1) / 2
                    val b = (nums[i - 1] + nums[i]) / 2
                    nums[i - 1] = a
                    nums[i] = b
                    wereChanges = true
                }
            }
        } while (wereChanges)

        return nums.max()
    }
}