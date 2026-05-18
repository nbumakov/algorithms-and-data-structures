package com.leetcode.t2831

import com.leetcode.util.print
import java.util.TreeMap


fun main() {
    Solution().longestEqualSubarray(listOf(1, 3, 2, 3, 1, 3), 3).print()
}

class Solution {
    fun longestEqualSubarray(nums: List<Int>, k: Int): Int {
        var l = 0
        var maxCount = 0
        var max = 0
        val map = TreeMap<Int, Int>()

        for (r in nums.indices) {
            map[nums[r]] = map.getOrDefault(nums[r], 0) + 1
            maxCount = maxOf(maxCount, map[nums[r]] ?: 0)

            if ((r - l + 1) - maxCount > k) {
                map[nums[l]] = map[nums[l]]!! - 1
                maxCount = map.firstEntry()!!.value
                l++
            }

            max = maxOf(max, maxCount)
        }

        return max
    }
}