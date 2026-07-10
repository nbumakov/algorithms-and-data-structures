package com.leetcode.t448

import com.leetcode.util.print
import kotlin.math.abs

fun main() {
    Solution().findDisappearedNumbers(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1))
        .joinToString().print()
}

// In-place marking: for each value v, negate nums[v-1] to mark v as seen.
// Indices whose value is still positive afterwards were never marked, i.e. missing.
class Solution {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        for (number in nums) {
            val newIndex = abs(number) - 1
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1
            }
        }
        return nums.withIndex().filter { it.value > 0  }.map { it.index + 1 }
    }
}

// Straightforward approach: collect all present values into a Set and
// report every number in 1..n that's missing from it.
class Solution2 {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val result = mutableListOf<Int>()
        val numsSet = nums.toSet()
        for (i in 1..nums.size) {
            if (!numsSet.contains(i)) {
                result.add(i)
            }
        }
        return result
    }
}