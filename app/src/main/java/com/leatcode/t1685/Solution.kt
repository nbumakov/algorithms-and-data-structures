package com.leatcode.t1685

import com.leatcode.util.print

fun main() {
    Solution().getSumAbsoluteDifferences(intArrayOf(2, 3, 5)).print()
}

class Solution {
    fun getSumAbsoluteDifferences(nums: IntArray): IntArray {
        val prefixArray = IntArray(nums.size)
        nums.forEachIndexed { index, i ->
            prefixArray[index] = i + prefixArray.getOrElse(index - 1) { 0 }
        }
        return IntArray(nums.size) { i ->
            prefixArray[nums.lastIndex] + (2 + 2 * i - nums.size) * nums[i] - 2 * prefixArray[i]
        }
    }

    fun getSumAbsoluteDifferences2(nums: IntArray): IntArray {
        val sum = nums.sum()
        var prefixSum = 0
        return IntArray(nums.size) { i ->
            prefixSum += nums[i]
            sum + (2 + 2 * i - nums.size) * nums[i] - 2 * prefixSum
        }
    }
}