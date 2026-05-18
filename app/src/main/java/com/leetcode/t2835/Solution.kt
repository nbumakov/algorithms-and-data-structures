package com.leetcode.t2835

import com.leetcode.util.print

fun main() {
//    Solution().minOperations(listOf(1,32,1,2), 12).print()
//    Solution().minOperations(listOf(1,256,16,128), 3).print()
//    Solution().minOperations(listOf(16, 16, 4), 3).print()
//    Solution().minOperations(listOf(128, 1, 128, 1, 64), 4).print()
    Solution().minOperations(
        listOf(
            64,
            1,
            16384,
            16384,
            1024,
            1,
            2,
            4096,
            2,
            2,
            65536,
            1,
            65536,
            4,
            4,
            256,
            4,
            16384,
            16384,
            8388608,
            16384,
            4,
            2,
            4096,
            4,
            1073741824,
            16777216,
            4,
            2,
            256,
            1,
            4,
            256,
            16384,
            1073741824,
            4096,
            1,
            4096,
            4,
            16384,
            4,
            4
        ), 42
    ).print()
}

class Solution {
    fun minOperations(nums: List<Int>, target: Int): Int {
        if (nums.asSequence().map { it.toLong() }.sum() < target) return -1

        val sorted = nums.toMutableList().apply { sortDescending() }  // nlogn
        val selected = mutableListOf<Int>()
        var curr = target
        var operations = 0
        while (curr > 0) { // logt
            val i = sorted.indexOfFirst { it <= curr } // n
            if (i >= 0) {
                curr -= sorted[i]
                selected.add(sorted[i])
                sorted.removeAt(i)
            } else {
                val j = sorted.indexOfLast { it > curr } // n
                val n = sorted[j]
                sorted.removeAt(j)
                sorted.add(n / 2)
                sorted.add(n / 2)
                sorted.addAll(selected)
                sorted.sortDescending() // nlogn
                selected.clear()
                curr = target
                operations++
            }
        }

        return operations
    }
}