package com.leatcode.t2563

import kotlin.math.max

// lower <= nums[i] + nums[j] <= upper

fun main() {
    //0,1,4,4,5,7
    Solution2().countFairPairs(intArrayOf(0, 1, 7, 4, 4, 5), 3, 6).let(::println)
    Solution2().countFairPairs(intArrayOf(1, 7, 9, 2, 5), 11, 11).let(::println)
}

// Binary Search
class Solution {
    fun countFairPairs(nums: IntArray, lower: Int, upper: Int): Long {
        nums.sort()

        var res = 0L
        for (i in nums.indices) {
            val min = lower - nums[i]
            val max = upper - nums[i]
            val lowerIndex = max(i + 1, findLowerIndex(nums, min))
            val upperIndex = findUpperIndex(nums, max)

            if (upperIndex >= lowerIndex) {
                res += upperIndex - lowerIndex + 1
            }
        }
        return res
    }

    private fun findLowerIndex(nums: IntArray, target: Int): Int {
        var low = 0
        var high = nums.lastIndex
        while (low <= high) {
            val mid = low + (high - low) / 2
            when {
                nums[mid] >= target -> high = mid - 1
                else -> low = mid + 1
            }
        }
        return high + 1
    }

    private fun findUpperIndex(nums: IntArray, target: Int): Int {
        var low = 0
        var high = nums.lastIndex
        while (low <= high) {
            val mid = low + (high - low) / 2
            when {
                nums[mid] <= target -> low = mid + 1
                else -> high = mid - 1
            }
        }
        return low - 1
    }
}

// Two Pointers
class Solution2 {
    fun countFairPairs(nums: IntArray, lower: Int, upper: Int): Long {
        nums.sort()

        return lowerBound(nums, upper + 1) - lowerBound(nums, lower)
    }

    // Calculate the number of pairs with sum less than `value`.
    private fun lowerBound(nums: IntArray, value: Int): Long {
        var left = 0
        var right = nums.lastIndex
        var res = 0L
        while (left < right) {
            val sum = nums[left] + nums[right]
            // If sum is less than value, add the size of window to result and move to the
            // next index.
            if (sum < value) {
                res += (right - left)
                left++
            } else {
                // Otherwise, shift the right pointer backwards, until we get a valid window.
                right--
            }
        }
        return res
    }
}