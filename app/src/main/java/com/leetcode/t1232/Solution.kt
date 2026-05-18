package com.leetcode.t1232

class Solution {
    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        val c = coordinates.first().let { it[0].toDouble() / it[1] }
        return coordinates.all { it[0].toDouble() / it[1] == c }
    }
}