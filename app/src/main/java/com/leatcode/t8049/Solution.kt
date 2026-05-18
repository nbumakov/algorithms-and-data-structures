package com.leatcode.t8049

import kotlin.math.abs

class Solution {
    fun isReachableAtTime(sx: Int, sy: Int, fx: Int, fy: Int, t: Int): Boolean {
        if (sx == fx && sy == fy && t == 1) return false
        val min = maxOf(abs(sx - fx), abs(sy - fy))
        return t >= min
    }
}