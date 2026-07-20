package com.leetcode.t1260

class Solution {
    fun shiftGrid(grid: Array<IntArray>, k: Int): List<List<Int>> {
        val m = grid.size
        val n = grid[0].size
        val shift = (m * n - k % (m * n)) % (m * n)

        return List(grid.size) { i ->
            List(grid[0].size) { j ->
                grid[(i + (j + shift) / n) % m][(j + shift) % n]
            }
        }
    }
}