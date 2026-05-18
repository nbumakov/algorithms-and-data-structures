package com.leetcode.t2817

import com.leetcode.util.print
import java.util.TreeSet
import kotlin.math.abs


fun main() {
//    Solution().minAbsoluteDifference(listOf(36, 19, 27), 2).print()
//    Solution().minAbsoluteDifference(listOf(1, 2, 3, 4), 3).print()
//    Solution().minAbsoluteDifference(listOf(65, 158, 4, 199), 3).print()
    Solution().minAbsoluteDifference(listOf(146, 153, 28, 157, 95), 3).print()
    Solution().minAbsoluteDifference(listOf(146, 148, 153, 28, 157, 95), 3).print()
}

class Solution {

    // nlogn TreeSet is helpful with finding the closest value
    fun minAbsoluteDifference(nums: List<Int>, x: Int): Int {
        var min = Int.MAX_VALUE
        val nm = TreeSet<Int>()
        for (i in x..nums.lastIndex) {
            nm.add(nums[i - x])
            nm.ceiling(nums[i])?.let { min = minOf(min, abs(nums[i] - it)) }
            nm.floor(nums[i])?.let { min = minOf(min, abs(nums[i] - it)) }
        }
        return min
    }

}
