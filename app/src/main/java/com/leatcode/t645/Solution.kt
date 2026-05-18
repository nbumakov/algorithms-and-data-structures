package com.leatcode.t645

import com.leatcode.util.print

fun main() {
    Solution().findErrorNums(intArrayOf(3, 2, 3, 4, 6, 5)).print()
}

class Solution {
    fun findErrorNums(nums: IntArray): IntArray {
        val set = (1..nums.size).toMutableSet()
        var errorNumber = 0
        nums.forEach { if (set.contains(it)) set.remove(it) else errorNumber = it }
        return intArrayOf(errorNumber, set.first())
    }

    fun findErrorNumsSD(nums: IntArray) = with(nums) {
        val missing = ((1..size) - toSet()).first()
        val delta = sum() - (size + 1) * size / 2
        intArrayOf(missing + delta, missing)
    }
}