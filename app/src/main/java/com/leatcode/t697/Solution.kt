package com.leatcode.t697

import com.leatcode.util.print

fun main() {
    Solution().findShortestSubArray(intArrayOf(1, 2, 2, 3, 1)).print()
}

class Solution {
    fun findShortestSubArray(nums: IntArray): Int {
        val map = hashMapOf<Int, Int>()
        nums.forEach { map[it] = map.getOrDefault(it, 0) + 1 }
        val max = map.maxBy { it.value }!!.value
        return map.filter { it.value == max }
            .map { entry ->
                val start = nums.indexOfFirst { it == entry.key }
                val end = nums.indexOfLast { it == entry.key }
                end - start + 1
            }
            .min()!!
    }
}