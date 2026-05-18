package com.leetcode.t356

import com.leetcode.util.print

fun main() {
//    Solution().isReflected(
//        arrayOf(
//            intArrayOf(0, 0),
//            intArrayOf(1, 0),
//        )
//    ).print()
    Solution().isReflected(
        arrayOf(
            intArrayOf(-16, 1),
            intArrayOf(16, 1),
            intArrayOf(16, 1),
        )
    ).print()
}

class Solution {
    fun isReflected(points: Array<IntArray>): Boolean {
        val pointsSet = points.map { it.first().toDouble() to it.last() }.toSet()
        val avgX = pointsSet.map { it.first }.average()
        pointsSet.forEach { p ->
            val symmetricalP = p.first.symmetrical(avgX) to p.second
            if (!pointsSet.contains(symmetricalP)) {
                return false
            }
        }
        return true
    }

    private fun Double.symmetrical(c: Double): Double = 2 * c - this

}