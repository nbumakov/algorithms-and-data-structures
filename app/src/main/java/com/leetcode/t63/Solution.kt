package com.leetcode.t63

class Solution {

    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        if (obstacleGrid[0][0] == 1) return 0

        obstacleGrid[0][0] = 1
        for (j in 1..obstacleGrid.first().lastIndex) {
            obstacleGrid[0][j] = if (obstacleGrid[0][j] == 1) 0 else obstacleGrid[0][j - 1]
        }

        for (i in 1..obstacleGrid.lastIndex) {
            for (j in obstacleGrid[i].indices) {
                obstacleGrid[i][j] = when (obstacleGrid[i][j]) {
                    1 -> 0
                    else -> obstacleGrid[i - 1][j] + (obstacleGrid[i].getOrNull(j - 1) ?: 0)
                }
            }
        }

        return obstacleGrid.last().last()
    }

    // DFS + memo
    fun uniquePathsWithObstacles2(obstacleGrid: Array<IntArray>): Int {
        val m = obstacleGrid.lastIndex
        val n = obstacleGrid.first().lastIndex
        val cache = Array(m + 1) { IntArray(n + 1) }

        fun dfs(i: Int, j: Int): Int = when {
            i > m -> 0
            j > n -> 0
            obstacleGrid[i][j] == 1 -> 0
            i == m && j == n -> 1
            cache[i][j] > 0 -> cache[i][j]
            else -> (dfs(i + 1, j) + dfs(i, j + 1)).also { cache[i][j] = it }
        }

        return dfs(0, 0)
    }
}