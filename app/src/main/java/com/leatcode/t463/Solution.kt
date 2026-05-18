package com.leatcode.t463

class Solution {
    fun islandPerimeter(grid: Array<IntArray>): Int {
        var result = 0
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 1) {
                    result += 4
                    if (i > 0 && grid[i - 1][j] == 1) result -= 2
                    if (j > 0 && grid[i][j - 1] == 1) result -= 2
                }
            }
        }
        return result
    }
}