package com.leetcode.t673

import com.leetcode.util.print

fun main() {
    Solution().findNumberOfLIS(intArrayOf(1, 3, 5, 4, 7)).print()
}

class Solution {
    fun findNumberOfLIS(nums: IntArray): Int {
        val lis = Array(nums.size) { 0 to 0 }.apply { this[lastIndex] = 1 to 1 } // length to count
        var max = 0
        for (i in nums.indices) {
            max = maxOf(max, nums.dfsLis(i, lis).first)
        }
        return lis.asSequence().filter { it.first == max }.map { it.second }.sum()!!
    }

    private fun IntArray.dfsLis(i: Int, lis: Array<Pair<Int, Int>>): Pair<Int, Int> {
        if (lis[i].first > 0) return lis[i]

        val lengthCountMap = hashMapOf<Int, Int>()

        for (j in i + 1..lastIndex) {
            if (this[j] > this[i]) {
                val (length, count) = dfsLis(j, lis)
                lengthCountMap[length] = lengthCountMap.getOrDefault(length, 0) + count
            }
        }
        val maxLength = lengthCountMap.keys.max() ?: 0
        lis[i] = maxLength + 1 to lengthCountMap[maxLength]!!
        return lis[i]
    }
}