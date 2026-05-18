package com.leatcode.t135

import com.leatcode.util.print

fun main() {
    Solution().candy(intArrayOf(1, 0, 2)).print()
}

class Solution {

    // Approach 1: Brute Force
    fun candy(ratings: IntArray): Int {
        val candies = IntArray(ratings.size) { 1 }
        var wereChanges: Boolean
        do {
            wereChanges = false
            for (i in candies.indices) {
                when {
                    i > 0 && ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1] -> {
                        candies[i] = candies[i - 1] + 1
                        wereChanges = true
                    }
                    i < candies.lastIndex && ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1] ->{
                        candies[i] = candies[i + 1] + 1
                        wereChanges = true
                    }
                }
            }
        } while (wereChanges)

        return candies.sum()
    }
}