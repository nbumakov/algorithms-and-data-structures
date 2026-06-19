package com.leetcode.t1732

import com.leetcode.util.print

fun main() {
    Solution2().largestAltitude(intArrayOf(-5, 1, 5, 0, -7)).print()
}

class Solution {

    fun largestAltitude(gain: IntArray): Int = gain
        .fold(0 to 0) { (max, current), change ->
            (current + change).let { maxOf(it, max) to it }
        }.first

}


class Solution2 {

    fun largestAltitude(gain: IntArray): Int =
        gain.scan(0, Int::plus).max()

}