package com.leatcode.t704

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var lo = 0
        var hi = nums.lastIndex
        while (lo < hi) {
            val mid = (lo + hi) / 2
            when {
                nums[mid] > target -> hi = mid - 1
                nums[mid] < target -> lo = mid + 1
                else -> return mid
            }
        }

        return -1
    }
}