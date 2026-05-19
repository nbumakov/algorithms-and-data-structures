package com.leetcode.t2090

import com.leetcode.util.print


fun main() {
//    val text = File("/Users/nbumakov/AndroidStudioProjects/StepcAlgs/app/src/main/java/com/leetcode/t2090/data.txt")
//    val input = Scanner(text).next().split(",").map { it.toInt() }
    Solution()
        .getAverages(intArrayOf(7,4,3,9,1,8,5,2,6), 3)
        .joinToString()
        .print()
}

class Solution {
    fun getAverages(nums: IntArray, k: Int): IntArray {
        if (k == 0) return nums

        val result = IntArray(nums.size) { -1 }
        var sum = 0L
        val windowOffset = 2 * k
        val windowSize = windowOffset + 1

        for (i in nums.indices) {
            sum += nums[i]
            if (i >= windowOffset) {
                result[i - k] = (sum / windowSize).toInt()
                sum -= nums[i - windowOffset]
            }
        }

        return result
    }
}