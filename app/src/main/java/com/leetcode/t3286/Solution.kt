package com.leetcode.t3286

class Solution {

    fun findSafeWalk(grid: List<List<Int>>, health: Int): Boolean {
        val m = grid.size
        val n = grid[0].size
        // minimum number of unsafe cells crossed to reach (i, j)
        val cost = Array(m) { IntArray(n) { Int.MAX_VALUE } }
        cost[0][0] = grid[0][0]

        val deque = ArrayDeque<IntArray>()
        deque.addLast(intArrayOf(0, 0))

        while (deque.isNotEmpty()) {
            val (i, j) = deque.removeFirst()
            for ((di, dj) in dirs) {
                val ni = i + di
                val nj = j + dj
                if ((ni !in 0..<m) || (nj !in 0..<n)) continue
                val newCost = cost[i][j] + grid[ni][nj]
                if (newCost < cost[ni][nj]) {
                    cost[ni][nj] = newCost
                    if (grid[ni][nj] == 1) {
                        deque.addLast(intArrayOf(ni, nj))
                    } else {
                        deque.addFirst(intArrayOf(ni, nj))
                    }
                }
            }
        }

        return health > cost[m - 1][n - 1]
    }

    companion object {
        private val dirs =
            arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))
    }
}

fun main() {
    val grid = listOf(
        listOf(0, 1, 1, 0, 0, 0),
        listOf(1, 0, 1, 0, 0, 0),
        listOf(0, 1, 1, 1, 0, 1),
        listOf(0, 0, 1, 0, 1, 0)
    )
    val health = 3
    println(Solution().findSafeWalk(grid, health))
}