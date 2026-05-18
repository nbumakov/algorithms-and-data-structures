package com.leatcode.t1614

import java.util.ArrayDeque
import kotlin.math.max

class Solution {
    fun maxDepth(s: String): Int {
        var openParentheses = 0
        var max = 0
        s.forEach {
            when (it) {
                '(' -> openParentheses++
                ')' -> openParentheses--
            }
            max = max(max, openParentheses)
        }

        return max
    }
}

class SolutionSD {
    fun maxDepth(s: String): Int {
        var openParentheses = 0
        return s.maxOf {
            when (it) {
                '(' -> openParentheses++
                ')' -> openParentheses--
            }
            openParentheses
        }
    }
}