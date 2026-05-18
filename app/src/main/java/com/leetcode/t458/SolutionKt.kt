package com.leetcode.t458

import com.leetcode.util.print
import kotlin.math.ceil
import kotlin.math.ln
import kotlin.math.log

fun main() {
//    SolutionKt().poorPigs(4, 15, 15).print()
//    SolutionKt().poorPigs(8, 15, 30).print()
    SolutionKt().poorPigs2(125, 1, 4).print()
//    Solution().poorPigs(125, 1, 4).print()

}

// 8, 15, 30
// 1 2 3
// 4 5 6
// 7 8

class SolutionKt {

    // The problem is to find x such that states^x ≥ buckets
    fun poorPigs2(buckets: Int, minutesToDie: Int, minutesToTest: Int): Int {
        val states = minutesToTest / minutesToDie + 1
        return ceil(log(buckets.toFloat(), states.toFloat())).toInt()
    }

    fun poorPigs(buckets: Int, minutesToDie: Int, minutesToTest: Int): Int {
        val states = minutesToTest / minutesToDie + 1
        return ceil(ln(buckets.toDouble()) / ln(states.toDouble())).also { println(it) }.toInt()
    }
}