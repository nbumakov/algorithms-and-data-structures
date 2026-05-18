package com.leetcode.t480

import com.leetcode.util.print


fun main() {
    Solution().medianSlidingWindow(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3)
        .joinToString().print()
}

class Solution {
    fun medianSlidingWindow(nums: IntArray, k: Int): DoubleArray {
        val result = DoubleArray(nums.size - k + 1)
        val window = ArrayList<Int>(k).apply {
            repeat(k - 1) { add(nums[it]) }
            sort()
        }
        for (i in k - 1..nums.lastIndex) {
            val addIndex = window.binarySearch(nums[i]).let { if (it < 0) -it - 1 else it }
            window.add(addIndex, nums[i])
            result[i - k + 1] = window.median()
            window.removeAt(window.binarySearch(nums[i - k + 1]))
        }

        return result
    }

    private fun List<Int>.median(): Double =
        if (size % 2 == 0) {
            this[size / 2 - 1].toDouble() / 2 + this[size / 2].toDouble() / 2
        } else {
            this[size / 2].toDouble()
        }

}