package com.leetcode.t3014

class Solution {
    fun minimumPushes(word: String): Int {
        var n = word.length
        var count = 0
        var step = 1
        while (n > 0) {
            count += n.coerceAtMost(8) * step++
            n -= 8
        }
        return count
    }
}

class Solution2{
    fun minimumPushes(word: String): Int {
        val n = word.length
        val fullRows = n / 8
        val remainder = n % 8
        return 8 * fullRows * (fullRows + 1) / 2 + remainder * (fullRows + 1)
    }
}