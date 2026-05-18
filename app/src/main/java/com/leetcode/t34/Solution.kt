package com.leetcode.t34

import com.leetcode.util.print

fun main() {
    Solution().searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8).print()
    Solution().searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 6).print()
}

class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray =
        intArrayOf(nums.indexOfFirst(target), nums.indexOfLast(target))

    private fun IntArray.indexOfFirst(target: Int): Int {
        var l = 0
        var r = lastIndex
        while (l <= r) {
            val mid = (l + r) / 2

            when {
                this[mid] >= target -> r = mid - 1
                else -> l = mid + 1
            }
        }

        return if (getOrNull(r + 1) == target) r + 1 else -1
    }

    private fun IntArray.indexOfLast(target: Int): Int {
        var l = 0
        var r = lastIndex
        while (l <= r) {
            val mid = (l + r) / 2

            when {
                this[mid] <= target -> l = mid + 1
                else -> r = mid - 1
            }
        }

        return if (getOrNull(l - 1) == target) l - 1 else -1
    }
}