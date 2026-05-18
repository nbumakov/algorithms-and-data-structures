package com.leatcode.t1503

import kotlin.math.max


class Solution {
    fun getLastMoment(n: Int, left: IntArray, right: IntArray): Int =
        max(
            left.maxOfOrNull { it } ?: 0,
            right.maxOfOrNull { n - it } ?: 0
        )
}