package com.leatcode.t1905

class Solution {
    fun countSubIslands(grid1: Array<IntArray>, grid2: Array<IntArray>): Int {
        val islands = mutableListOf<List<IntArray>>()
        val curr = mutableListOf<IntArray>()
        fun dfs(i: Int, j: Int) {
            if (i < 0 || i >= grid2.size || j < 0 || j >= grid2[0].size || grid2[i][j] == 0) return
            grid2[i][j] = 0
            curr.add(intArrayOf(i, j))
            for (dir in directions) {
                dfs(i + dir[0], j + dir[1])
            }
        }
        for (i in grid2.indices) {
            for (j in grid2[i].indices) {
                if (grid2[i][j] == 1) {
                    dfs(i, j)
                    islands.add(curr.toList())
                    curr.clear()
                }
            }
        }

        return islands
            .count { it.all { (i, j) -> grid1[i][j] == 1 } }
    }

    companion object{
        val directions = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
    }
}