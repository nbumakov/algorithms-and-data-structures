package com.leetcode.t2841

import com.leetcode.util.print


fun main() {
    Solution().maxSum(listOf(2, 6, 7, 3, 1, 7), 3, 4).print()
    Solution().maxSum(listOf(5,9,9,2,4,5,4), 1, 3).print()
    Solution().maxSum(listOf(1,2,1,2,1,2,1), 3, 3).print()
}

class Solution {
    fun maxSum(nums: List<Int>, m: Int, k: Int): Long {
        val freq = hashMapOf<Int, Int>().apply {
            nums.take(k - 1).forEach { this[it] = getOrDefault(it, 0) + 1 }
        }

        var sum: Long = nums.take(k - 1).map { it.toLong() }.sum()
        var maxSum = Long.MIN_VALUE
        var uniq = freq.keys.size
        for (i in k - 1..nums.lastIndex) {
            val iFreq = freq.getOrDefault(nums[i], 0)
            if (iFreq == 0) uniq++
            freq[nums[i]] = iFreq + 1
            sum += nums[i]

            if (uniq >= m) maxSum = maxOf(maxSum, sum)

            val ikFreq = freq.getOrDefault(nums[i - k + 1], 0)
            if (ikFreq == 1) uniq--
            freq[nums[i - k + 1]] = ikFreq - 1
            sum -= nums[i - k + 1]
        }

        return maxSum.takeIf { it != Long.MIN_VALUE } ?: 0
    }
}