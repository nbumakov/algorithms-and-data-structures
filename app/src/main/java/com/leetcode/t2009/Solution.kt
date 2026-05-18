package com.leetcode.t2009

import com.leetcode.util.print
import kotlin.math.min

fun main() {
//    Solution().minOperations(intArrayOf(4, 2, 5, 3)).print()
    Solution().minOperations(intArrayOf(1, 2, 3, 5, 6)).print()
//    Solution().minOperations(intArrayOf(1, 10, 100, 1000)).print()
}

class Solution {

    /**
     * Algorithm
     *
     * Set n = nums.length and the answer ans = n.
     * Remove duplicates from nums and then sort it. We will call this new array newNums.
     * Initialize j = 0 and iterate i over the indices of newNums:
     * While newNums[j] is within our range (less than newNums[i] + n), increment j.
     * Calculate count = j - i, the number of elements already in our range.
     * Update ans with n - count if it is smaller.
     * Return ans.
     */
    fun minOperations(nums: IntArray): Int {
        val numsSortedSet = nums.toSortedSet().toIntArray()
        var ans = nums.size
        var j = 0
        for (i in numsSortedSet.indices) {
            while (j < numsSortedSet.size && numsSortedSet[j] < numsSortedSet[i] + numsSortedSet.size) j++
            val count = j - i // the number of elements already in our range
            ans = min(ans, numsSortedSet.size - count)
        }
        return ans
    }
}