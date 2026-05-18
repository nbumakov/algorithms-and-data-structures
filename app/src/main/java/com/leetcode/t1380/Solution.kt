package com.leetcode.t1380
// [
//  [3,7,8],
//  [9,11,13],
//  [15,16,17]
// ]
class Solution {
    fun luckyNumbers (matrix: Array<IntArray>): List<Int> {
        val rowMin = matrix.map { it.minOrNull()!! }
        val colMax = matrix[0].indices.map { col -> matrix.maxOf { it[col] } }
        return rowMin.intersect(colMax.toSet()).toList()
    }
}