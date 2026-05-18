package com.leetcode.t37

import com.leetcode.util.print

fun main() {
    val a = 5
    println('0' + a)

    val array = arrayOf(
        arrayOf("5", "3", ".", ".", "7", ".", ".", ".", ".").map { it.first() }.toCharArray(),
        arrayOf("6", ".", ".", "1", "9", "5", ".", ".", ".").map { it.first() }.toCharArray(),
        arrayOf(".", "9", "8", ".", ".", ".", ".", "6", ".").map { it.first() }.toCharArray(),
        arrayOf("8", ".", ".", ".", "6", ".", ".", ".", "3").map { it.first() }.toCharArray(),
        arrayOf("4", ".", ".", "8", ".", "3", ".", ".", "1").map { it.first() }.toCharArray(),
        arrayOf("7", ".", ".", ".", "2", ".", ".", ".", "6").map { it.first() }.toCharArray(),
        arrayOf(".", "6", ".", ".", ".", ".", "2", "8", ".").map { it.first() }.toCharArray(),
        arrayOf(".", ".", ".", "4", "1", "9", ".", ".", "5").map { it.first() }.toCharArray(),
        arrayOf(".", ".", ".", ".", "8", ".", ".", "7", "9").map { it.first() }.toCharArray(),
    )
    Solution().solveSudoku(array)
    array.forEach {
        it.joinToString().print()
    }
}

class Solution {

    private val nums = ('1'..'9').asSequence()

    fun solveSudoku(board: Array<CharArray>) {

        fun Char.isValid(i: Int, j: Int): Boolean {
            // check row
            if (board[i].contains(this)) return false
            //check column
            for (k in board.indices) if (board[k][j] == this) return false
            //check cell
            for (k in 3 * (i / 3) until 3 * (i / 3) + 3) {
                for (l in 3 * (j / 3) until 3 * (j / 3) + 3) {
                    if (board[k][l] == this) return false
                }
            }
            return true
        }

        fun dfs(row: Int, column: Int): Boolean {
            fun next() = when {
                column < 8 -> dfs(row, column + 1)
                row < 8 -> dfs(row + 1, 0)
                else -> true
            }

            if (board[row][column] != '.') return next()

            for (i in nums.filter { it.isValid(row, column) }) {
                board[row][column] = i
                if (next()) return true
                board[row][column] = '.'
            }
            return false
        }

        dfs(0, 0)
    }

    // nums board
    fun solveSudoku2(board: Array<CharArray>) {
        val numsBoard = Array(board.size) {
            board[it].map { c ->
                when (c) {
                    '.' -> 0
                    else -> Character.getNumericValue(c)
                }
            }.toIntArray()
        }

        fun Int.isValid(i: Int, j: Int): Boolean {
            if (numsBoard[i].contains(this)) return false
            for (k in numsBoard.indices) {
                if (numsBoard[k][j] == this) return false
            }
            for (k in 3 * (i / 3) until 3 * (i / 3) + 3) {
                for (l in 3 * (j / 3) until 3 * (j / 3) + 3) {
                    if (numsBoard[k][l] == this) return false
                }
            }
            return true
        }

        fun dfs(row: Int, column: Int): Array<IntArray>? {
            fun next() = when {
                column < 8 -> dfs(row, column + 1)
                row < 8 -> dfs(row + 1, 0)
                else -> numsBoard
            }

            if (board[row][column] != '.') return next()

            for (i in 1..9) {
                if (i.isValid(row, column)) {
                    numsBoard[row][column] = i
                    next()?.apply { return this }
                    numsBoard[row][column] = 0
                }
            }
            return null
        }

        dfs(0, 0)?.run {
            this.forEachIndexed { i, row ->
                row.forEachIndexed { j, value ->
                    board[i][j] = '0' + value
                }
            }
        }
    }
}