package com.leetcode.t771

class Solution {
    fun numJewelsInStones(jewels: String, stones: String): Int {
        val jewelsSet = jewels.toSet()
        return stones.count { jewelsSet.contains(it) }
    }
}