package com.leetcode.t2812

class Solution {
    fun maximumSafenessFactor(grid: List<List<Int>>): Int {
        val n = grid.size

        // ---- Фаза 1: multi-source BFS ----
        val memory = Array(n) { IntArray(n) { -1 } }
        val queue = ArrayDeque<IntArray>()

        for (i in 0 until n) {
            for (j in 0 until n) {
                if (grid[i][j] == 1) {
                    memory[i][j] = 0
                    queue.add(intArrayOf(i, j))
                }
            }
        }

        val dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))
        while (queue.isNotEmpty()) {
            val (i, j) = queue.removeFirst()
            for (d in dirs) {
                val ni = i + d[0]
                val nj = j + d[1]
                if (ni in 0 until n && nj in 0 until n && memory[ni][nj] == -1) {
                    // сосед на 1 дальше от вора, чем текущая клетка
                    memory[ni][nj] = memory[i][j] + 1
                    queue.add(intArrayOf(ni, nj))
                }
            }
        }

        // ---- Фаза 2: бинарный поиск по ответу + DFS-проверка ----
        var lo = 0
        var hi = minOf(memory[0][0], memory[n - 1][n - 1])
        var answer = 0
        while (lo <= hi) {
            val mid = (lo + hi) / 2
            if (canReach(memory, n, mid)) {
                answer = mid
                lo = mid + 1
            } else {
                hi = mid - 1
            }
        }
        return answer
    }

    // DFS: существует ли путь из (0,0) в (n-1,n-1) через клетки с safeness >= threshold
    private fun canReach(memory: Array<IntArray>, n: Int, threshold: Int): Boolean {
        if (memory[0][0] < threshold) return false
        val visited = Array(n) { BooleanArray(n) }
        val dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))

        fun dfs(i: Int, j: Int): Boolean {
            if (i !in 0 until n || j !in 0 until n) return false
            if (visited[i][j] || memory[i][j] < threshold) return false
            if (i == n - 1 && j == n - 1) return true
            visited[i][j] = true
            for (d in dirs) {
                if (dfs(i + d[0], j + d[1])) return true
            }
            return false
        }

        return dfs(0, 0)
    }
}

fun main() {
    val s = Solution()
    // ожидается 0
    println(s.maximumSafenessFactor(listOf(listOf(1, 0, 0), listOf(0, 0, 0), listOf(0, 0, 1))))
    // ожидается 2
    println(s.maximumSafenessFactor(listOf(listOf(0, 0, 1), listOf(0, 0, 0), listOf(0, 0, 0))))
    // ожидается 2
    println(
        s.maximumSafenessFactor(
            listOf(
                listOf(0, 0, 0, 1),
                listOf(0, 0, 0, 0),
                listOf(0, 0, 0, 0),
                listOf(1, 0, 0, 0),
            )
        )
    )
}
