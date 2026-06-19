package com.leetcode.t1344

import com.leetcode.util.print
import kotlin.math.absoluteValue

fun main() {
    Solution()
        .angleClock(3, 15)
        .print()
}

class Solution {
    fun angleClock(hour: Int, minutes: Int): Double {
        val m = minutes / 60.0
        val h = (hour + m) / 12.0
        val angle = (m - h).absoluteValue * 360

        return minOf(angle, 360 - angle)
    }
}

class Solution2 {
    // Minute hand moves 6°/min, hour hand 0.5°/min → gap grows 5.5°/min
    fun angleClock(hour: Int, minutes: Int): Double {
        val angle = 5.5 * (hour * 60 + minutes) % 360
        return minOf(angle, 360 - angle)
    }
}