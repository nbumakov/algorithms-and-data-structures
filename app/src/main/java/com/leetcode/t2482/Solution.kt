package com.leetcode.t2482

class Solution {
    fun onesMinusZeros(grid: Array<IntArray>): Array<IntArray> {
        val onesRowi = IntArray(grid.size) { i -> grid[i].count { it == 1 } }
        val zerosRowi = IntArray(grid.size) { i -> grid[i].size - onesRowi[i] }
        val onesColj = IntArray(grid[0].size) { j -> grid.indices.count { grid[it][j] == 1 } }
        val zerosColj = IntArray(grid[0].size) { j -> grid.size - onesColj[j] }

        return Array(grid.size) {i ->
            IntArray(grid[i].size) {j ->
                onesRowi[i] + onesColj[j] - zerosRowi[i] - zerosColj[j]
            }
        }
    }
}