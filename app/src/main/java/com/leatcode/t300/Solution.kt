package com.leatcode.t300

import com.leatcode.util.print

fun main() {
    Solution().lengthOfLIS(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)).print()
}

//TODO: make again
class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val lis = IntArray(nums.size) { 0 }.apply { this[lastIndex] = 1 }
        var max = 0
        for (i in nums.indices) {
            max = maxOf(max, nums.dfsLis(i, lis))
        }
        return max
    }

    private fun IntArray.dfsLis(i: Int, lis: IntArray): Int {
        if (lis[i] > 0) return lis[i]

        var max = 0
        for (j in i + 1..lastIndex) {
            if (this[j] > this[i]) max = maxOf(max, dfsLis(j, lis))
        }
        lis[i] = max + 1
        return lis[i]
    }
}