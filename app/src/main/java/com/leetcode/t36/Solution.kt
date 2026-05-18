package com.leetcode.t36

class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rows = mutableMapOf<Int, MutableSet<Char>>()
        val columns = mutableMapOf<Int, MutableSet<Char>>()
        val blocks = mutableMapOf<Pair<Int, Int>, MutableSet<Char>>()

        for (r in 0 until 9) {
            for (c in 0 until 9) {
                val item = board[r][c]
                if (item == '.') continue
                if (item in rows.getOrPut(r) { mutableSetOf() }) return false
                if (item in columns.getOrPut(c) { mutableSetOf() }) return false
                if (item in blocks.getOrPut(r / 3 to c / 3) { mutableSetOf() }) return false
                rows[r]?.add(item)
                columns[c]?.add(item)
                blocks[r / 3 to c / 3]?.add(item)
            }
        }
        return true
    }
}

class SolutionSlow {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val areRowsValid = board.map {
            Validator().check(it)
        }.all { it }

        val areColumnsValid = (0 until 9)
            .map { j ->
                val colum = board.map { it.slice(j until j + 1) }
                    .flatten()
                    .toCharArray()
                Validator().check(colum)
            }.all { it }

        var areBlocksValid = true
        for (n in 0 until 9 step 3) {
            for (m in 0 until 9 step 3) {
                val block = board.slice(0 + n until 3 + n)
                    .map { it.slice(0 + m until 3 + m) }
                    .flatten()
                    .toCharArray()
                areBlocksValid = areBlocksValid && Validator().check(block)
            }
        }

        return areRowsValid && areColumnsValid && areBlocksValid
    }

    class Validator {
        private val vals = BooleanArray(10) { false }

        fun check(array: CharArray): Boolean {
            for (c in array) {
                if (!check(c)) {
                    return false
                }
            }
            return true
        }

        private fun check(c: Char): Boolean {
            if (!c.isDigit()) return true
            return !vals[c - '0'].also {
                vals[c - '0'] = true
            }
        }
    }
}