package com.leetcode.t1561

import com.leetcode.util.print

fun main() {
    Solution()
        .maxCoins(intArrayOf(2, 4, 1, 2, 7, 8)).print()
}

class Solution {
    fun maxCoins(piles: IntArray): Int =
        piles.sorted()
            .asSequence()
            .drop(piles.size / 3)
            .filterIndexed { index, _ -> index % 2 == 0 }
            .sum()
}