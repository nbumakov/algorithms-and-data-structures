package com.leatcode.t849

import com.leatcode.util.print

fun main() {
//    Solution().maxDistToClosest(intArrayOf(1, 0, 0, 0, 1, 0, 1)).print()
    Solution().maxDistToClosest(intArrayOf(1, 0, 0, 0)).print()
//    Solution().maxDistToClosest(intArrayOf(0,0,1,0,1,1)).print()
//    Solution().maxDistToClosest(intArrayOf(1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0)).print()
}

class Solution {
    fun maxDistToClosest(seats: IntArray): Int {
        val maxConsecutiveZeros = seats.maxConsecutiveZeros()
        val maxConsecutiveZerosFromEdge = seats.maxConsecutiveZerosFromEdge()
        return maxOf(maxConsecutiveZerosFromEdge, (maxConsecutiveZeros - 1) / 2 + 1)
    }

    private fun IntArray.maxConsecutiveZerosFromEdge(): Int {
        var fromStart = 0
        for (n in this) if (n == 0) fromStart++ else break
        var fromEnd = 0
        for (i in lastIndex downTo 0) if (this[i] == 0) fromEnd++ else break
        return maxOf(fromStart, fromEnd)
    }

    private fun IntArray.maxConsecutiveZeros(): Int {
        var max = 0
        var count = 0
        for (n in this) {
            if (n == 0) count++ else count = 0
            max = maxOf(max, count)
        }
        return max
    }
}