package com.leetcode.t53

import com.leetcode.util.print

fun main() {
    Solution().maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)).print()
    Solution().maxSubArray2(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)).print()
    Solution().maxSubArray(intArrayOf(-2, 2, -1, 4)).print()
    Solution().maxSubArray(intArrayOf(-1)).print()
    Solution().maxSubArray2(intArrayOf(-1)).print()
}

class Solution {

    fun maxSubArray(nums: IntArray): Int {
        var max = nums.max()
        var sum = 0
        for (num in nums) {
            if (sum + num < 0) { // если сумма текущих элементов < 0 - сбрасываем ее
                sum = 0
            } else {
                sum += num
                max = maxOf(max, sum)
            }
        }

        return max
    }

    fun maxSubArray2(nums: IntArray): Int {
        val dp = IntArray(nums.size + 1)
        for (i in nums.lastIndex downTo 0) {
            dp[i] = dp[i + 1].coerceAtLeast(0) + nums[i]
        }

        return dp.take(nums.size).max()!!
    }

}

class SolutionDP {
    fun maxSubArray(nums: IntArray): Int {
        for (i in 1 .. nums.lastIndex) {
            nums[i] = maxOf(nums[i], nums[i] + nums[i - 1])
        }
        return nums.max()
    }
}