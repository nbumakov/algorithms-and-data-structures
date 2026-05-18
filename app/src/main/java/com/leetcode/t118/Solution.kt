package com.leetcode.t118

import com.leetcode.util.print

fun main() {
    Solution().generate(3).print()
}

class Solution {

    fun generate(numRows: Int) = (2..numRows)
        .runningFold(listOf(1)) { r, _ ->
            listOf(1) + r.windowed(2).map { it.sum() } + listOf(1)
        }

    fun generate1(numRows: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        for (i in 1..numRows) {
            result += List(i) {
                when (it) {
                    0, i - 1 -> 1
                    else -> result[i - 2][it - 1] + result[i - 2][it]
                }
            }
        }
        return result
    }
}