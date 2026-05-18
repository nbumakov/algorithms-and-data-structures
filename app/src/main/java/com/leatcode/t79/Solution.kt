package com.leatcode.t79

import com.leatcode.util.print

fun main() {
    Solution()
        .exist(
            arrayOf(
                charArrayOf('A', 'B', 'C', 'E'),
                charArrayOf('S', 'F', 'C', 'S'),
                charArrayOf('A', 'D', 'E', 'E'),
            ),
            "ABCCED"
        ).print()

    Solution()
        .exist(
            arrayOf(
                charArrayOf('A', 'B', 'C', 'E'),
                charArrayOf('S', 'F', 'C', 'S'),
                charArrayOf('A', 'D', 'E', 'E'),
            ),
            "ABCB"
        ).print()
}

class Solution {

    private val directions = listOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)

    fun exist(board: Array<CharArray>, word: String): Boolean {

        val visited = Array(board.size) { BooleanArray(board[it].size) }

        fun search(index: Int, i: Int, j: Int): Boolean {
            if (index > word.lastIndex) return true
            if (i !in board.indices || j !in board[i].indices) return false
            if (visited[i][j]) return false
            if (board[i][j] != word[index]) return false

            visited[i][j] = true

            return directions.any { (diffX, diffY) -> search(index + 1, i + diffX, j + diffY) }
                .also { visited[i][j] = false }
        }

        for (i in board.indices) {
            for (j in board[i].indices) {
                if (search(0, i, j)) return true
            }
        }

        return false
    }
}