package com.leetcode.t3635

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun earliestFinishTime(
        landStartTime: IntArray,
        landDuration: IntArray,
        waterStartTime: IntArray,
        waterDuration: IntArray
    ): Int {
        val minLandEnd = landStartTime.indices.minOf { landStartTime[it] + landDuration[it] }
        val minWaterEnd = waterStartTime.indices.minOf { waterStartTime[it] + waterDuration[it] }

        // land first
        val landFirst = waterStartTime.indices.minOf {
            max(waterStartTime[it], minLandEnd) + waterDuration[it]
        }
        // water first
        val waterFirst = landStartTime.indices.minOf {
            max(landStartTime[it], minWaterEnd) + landDuration[it]
        }

        return min(landFirst, waterFirst)
    }
}