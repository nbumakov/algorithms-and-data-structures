package com.leetcode.t1266

import kotlin.math.abs
import kotlin.math.max

class Solution {
    fun minTimeToVisitAllPoints(points: Array<IntArray>): Int =
        points.asSequence()
            .windowed(2)
            .sumOf { (from, to) ->
                val dx = abs(to[0] - from[0])
                val dy = abs(to[1] - from[1])
                max(dx, dy)
            }

}