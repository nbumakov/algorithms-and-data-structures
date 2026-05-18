package com.leetcode.t200

import java.util.LinkedList
import java.util.Queue

class Solution {

    fun numIslands(grid: Array<CharArray>): Int {
        fun bfs(i: Int, j: Int) {
            val queue: Queue<Pair<Int, Int>> = LinkedList()
            queue.add(i to j)

            while (queue.isNotEmpty()) {
                for(k in 0 until queue.size) {
                    val (x, y) = queue.poll()!!
                    if (x !in grid.indices || y !in grid[x].indices) continue
                    if (grid[x][y] == '0') continue
                    grid[x][y] = '0'
                    queue.add(x - 1 to y)
                    queue.add(x to y + 1)
                    queue.add(x + 1 to y)
                    queue.add(x to y - 1)
                }
            }
        }

        var islands = 0
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == '1') {
                    bfs(i, j)
                    islands++
                }
            }
        }

        return islands
    }


    // dfs top-down
    fun numIslands1(grid: Array<CharArray>): Int {
        var islands = 0

        fun dfs(i: Int, j: Int) {
            if (i !in grid.indices || j !in grid[i].indices) return
            if (grid[i][j] == '0') return

            grid[i][j] = '0'
            dfs(i - 1, j)
            dfs(i, j + 1)
            dfs(i + 1, j)
            dfs(i, j - 1)
        }

        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == '1') {
                    dfs(i, j)
                    islands++
                }
            }
        }

        return islands
    }
}

// dfs
class SolutionSD {

    fun numIslands(grid: Array<CharArray>): Int {
        fun dfs(y: Int, x: Int): Boolean =
            if (grid[y][x] == '1') {
                grid[y][x] = '0'
                if (x > 0) dfs(y, x - 1)
                if (y > 0) dfs(y - 1, x)
                if (x < grid[0].size - 1) dfs(y, x + 1)
                if (y < grid.size - 1) dfs(y + 1, x)
                true
            } else false
        return (0 until grid.size * grid[0].size).count {
            dfs(it / grid[0].size, it % grid[0].size)
        }
    }
}