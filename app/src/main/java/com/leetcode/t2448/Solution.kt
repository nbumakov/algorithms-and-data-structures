package com.leetcode.t2448

import kotlin.math.abs

class Solution {

    // Time Limit Exceeded
    fun minCost(nums: IntArray, cost: IntArray): Long {
        val costTo: (x: Int) -> Long = { x ->
            nums.foldIndexed(0L) { i, acc, n ->
                acc + abs(n - x).toLong() * cost[i]
            }
        }

        return (nums.min()!!..nums.max()!!)
            .map { costTo(it) }
            .min()!!
    }

    fun minCostBS(nums: IntArray, cost: IntArray): Long {
        val costTo: (x: Int) -> Long = { x ->

            nums.foldIndexed(0L) { i, acc, n ->
                acc + abs(n - x).toLong() * cost[i]
            }
        }

        var l = nums.min()!!
        var h = nums.max()!!
        var min = minOf(costTo(l), costTo(h))
        while (l <= h) {
            val mid = (h + l) / 2
            val midCost1 = costTo(mid - 1)
            val midCost2 = costTo(mid + 1)

            min = minOf(min, midCost1, midCost2)

            if (midCost1 < midCost2) h = mid - 1 else l = mid + 1
        }

        return min
    }

}
