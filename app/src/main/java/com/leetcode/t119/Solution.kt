package com.leetcode.t119

import com.leetcode.util.print

fun main() {
    Solution().getRowRec(3).print()
}

class Solution {

    fun getRowRec(row: Int): List<Int> {
        if (row == 0) return listOf(1)

        return buildList {
            add(1)
            getRowRec(row - 1).run { for (i in 1..lastIndex) add(this[i - 1] + this[i]) }
            add(1)
        }
    }

    fun getRow(rowIndex: Int): List<Int> {
        var row = listOf(1)
        for (i in 1..rowIndex + 1) {
            val newRow = mutableListOf<Int>()
            for (j in 0 until i) {
                if (j == 0 || j == i - 1) {
                    newRow.add(1)
                } else {
                    newRow.add(row[j - 1] + row[j])
                }
            }
            row = newRow
        }
        return row
    }

    fun getRow2(rowIndex: Int): List<Int> {
        var row = IntArray(1) { 1 }
        repeat(rowIndex) {
            row = IntArray(row.size + 1) {
                if (it == 0 || it == row.size) {
                    1
                } else {
                    row[it - 1] + row[it]
                }
            }
        }
        return row.toList()
    }

}