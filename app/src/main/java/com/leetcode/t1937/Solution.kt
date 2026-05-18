package com.leetcode.t1937

import kotlin.math.max

class Solution {
    fun maxPoints(points: Array<IntArray>): Long {
        val dp = Array(points.size) { LongArray(points[0].size) }

        for (i in points[0].indices) {
            dp[0][i] = points[0][i].toLong()
        }


        for (i in 1..points.lastIndex) {
            val leftMax = dp[i - 1].clone()

            for (j in 1..dp[i-1].lastIndex) {
                leftMax[j] = max(dp[i-1][j], leftMax[j - 1] - 1) // The subtraction accounts for the penalty incurred when moving horizontally to the next cell.
            }
            val rightMax = dp[i - 1].clone()
            for (j in dp[i-1].lastIndex - 1 downTo 0) {
                rightMax[j] = max(dp[i-1][j], rightMax[j + 1] - 1)
            }

            for (j in points[i].indices) {
                dp[i][j] = points[i][j].toLong() + max(leftMax[j], rightMax[j])
            }
        }
        return dp.last().max()
    }
}