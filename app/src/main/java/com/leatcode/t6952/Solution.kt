package com.leatcode.t6952

import com.leatcode.util.print

fun main() {
    Solution().countInterestingSubarrays(listOf(3, 2, 4), 2, 1).print()
}

class Solution {

    fun countInterestingSubarrays(nums: List<Int>, modulo: Int, k: Int): Long {
        var count = 0L
        val prefixes = IntArray(nums.size) {
            if (nums[it] % modulo == k) count++
            count.toInt()
        }
        count = 0
        for (i in nums.indices) {
            for (j in i..nums.lastIndex) {
                val cnt = prefixes[j] - prefixes.getOrElse(i - 1) { 0 }
                if (cnt % modulo == k) count++
            }
        }

        return count
    }

}