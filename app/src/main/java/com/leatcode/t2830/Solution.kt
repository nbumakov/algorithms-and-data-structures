package com.leatcode.t2830

import com.leatcode.util.print


fun main() {
    Solution().maximizeTheProfit(
        5,
        listOf(
            listOf(0, 0, 1),
            listOf(0, 2, 2),
            listOf(1, 3, 2),
        )
    ).print()
}

class Solution {

    //[[0,0,1],[0,2,2],[1,3,2]]
//    fun maximizeTheProfit(n: Int, offers: List<List<Int>>): Int {
//        val sorted = offers.sortedBy { it[0] }
//        val dp = IntArray(n)
//
//
//    }


    fun maximizeTheProfit(n: Int, offers: List<List<Int>>): Int {
        val houses = IntArray(n) // dp
        val sortedOffers = offers.sortedBy { it[1] }
        var offerIndex = 0
        for (i in houses.indices) {
            houses[i] = houses.getOrElse(i - 1) { 0 }
            while (offerIndex < sortedOffers.size) {
                val (start, end, gold) = sortedOffers[offerIndex]
                if (i == end) {
                    val previous = houses.getOrElse(start - 1) { 0 }
                    houses[i] = maxOf(houses[i], previous + gold)
                    offerIndex++
                } else {
                    break
                }
            }
        }
        return houses.last()
    }

    // WA
    fun maximizeTheProfit1(n: Int, offers: List<List<Int>>): Int {
        val sorted = offers.sortedBy { it[1] }
        val dp = IntArray(n)

        sorted.forEach { (from, to, gold) ->
            val prev = (dp.getOrNull(from - 1) ?: 0)
            for (i in from..to) {
                dp[i] = maxOf(dp[i], gold + prev)
            }
        }

        return dp.max()
    }
}