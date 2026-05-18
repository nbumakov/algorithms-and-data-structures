package com.leatcode.t3110

import kotlin.math.abs

class Solution {
    fun scoreOfString(s: String): Int =
        s.asSequence()
            .windowed(2)
            .sumOf { abs(it[0] - it[1]) }
}