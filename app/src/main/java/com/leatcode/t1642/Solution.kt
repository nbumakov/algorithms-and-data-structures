package com.leatcode.t1642

import com.leatcode.util.print
import java.util.PriorityQueue

fun main() {
    Solution().furthestBuilding_BS(intArrayOf(14, 3, 19, 3), 17, 0).print()
}

class Solution {
    fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
        val heap = PriorityQueue<Int>()
        var bricksLeft = bricks
        for (i in 0 until heights.lastIndex) {
            val climb = heights[i + 1] - heights[i]
            if (climb <= 0) continue

            // nlogn
            heap.add(climb)
            if (heap.size <= ladders) continue
            bricksLeft -= heap.poll()!!
            if (bricksLeft < 0) return i
        }
        return heights.lastIndex
    }

    fun furthestBuilding_BS(heights: IntArray, bricks: Int, ladders: Int): Int {
        val diffs = IntArray(heights.size) {
            if (it == 0) 0 else (heights[it] - heights[it - 1]).coerceAtLeast(0)
        }

        //nlogn
        fun isReachable(i: Int): Boolean {
            if (i <= ladders) return true
            return diffs.slice(0..i)
                .sorted()
                .take(i - ladders + 1)
                .sum() <= bricks
        }

        var l = 0
        var r = heights.lastIndex

        // logn * nlogn = n(logn)^2
        while (l < r) {
            val mid = l + (r - l + 1) / 2
            if (isReachable(mid)) {
                l = mid
            } else {
                r = mid - 1
            }
        }
        return l
    }
}