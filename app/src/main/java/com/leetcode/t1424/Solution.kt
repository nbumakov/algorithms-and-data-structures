package com.leetcode.t1424

import com.leetcode.util.print

fun main() {
    //[[1,2,3],[4,5,6],[7,8,9]]
    Solution().findDiagonalOrder(
        listOf(
            listOf(1),
            listOf(2),
            listOf(3),
            listOf(4),
            listOf(8, 9),
        )
    ).print()
}

class Solution {
    fun findDiagonalOrder2(nums: List<List<Int>>): IntArray {
        val diagonalGroups = hashMapOf<Int, MutableList<Int>>()

        for (i in nums.indices.reversed()) {
            for (j in nums[i].indices) {
                // порядок может нарушаться
                diagonalGroups.getOrPut(i + j) { mutableListOf() }.add(nums[i][j])
            }
        }

        return (0..diagonalGroups.keys.max())
            .map { diagonalGroups[it]!! }
            .flatten().toIntArray()
    }

    fun findDiagonalOrder(nums: List<List<Int>>): IntArray {
        val diagonalGroups = hashMapOf<Int, MutableList<Int>>()

        for (i in nums.indices.reversed()) {
            for (j in nums[i].indices) {
                diagonalGroups.getOrPut(i + j) { mutableListOf() }.add(nums[i][j])
            }
        }

        return diagonalGroups.map { it.value }
            .flatten()
            .toIntArray()
    }
}