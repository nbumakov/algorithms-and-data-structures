package com.leetcode.t2639

class Solution {
    fun findColumnWidth(grid: Array<IntArray>): IntArray = IntArray(grid.first().size).apply {
        grid.forEach { row ->
            row.forEachIndexed { index, k ->
                this[index] = maxOf(this[index], k.toString().length)
            }
        }
    }
}