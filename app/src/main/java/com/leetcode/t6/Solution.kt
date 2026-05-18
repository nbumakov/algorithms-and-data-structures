package com.leetcode.t6

fun main() {
    println(Solution().convert("PAYPALISHIRING", 4))
}

class Solution {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) {
            return s
        }

        val zigZag = Array(numRows) { StringBuilder() }
        var row = 0
        var isGoingDown = true

        for (c in s) {
            zigZag[row].append(c)

            if (row == 0) isGoingDown = true
            if (row + 1 == numRows) isGoingDown = false
            if (isGoingDown) row++ else row--
        }
        return zigZag.joinToString("")
    }
}