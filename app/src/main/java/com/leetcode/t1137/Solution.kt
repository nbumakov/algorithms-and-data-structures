package com.leetcode.t1137

import com.leetcode.util.print

fun main() {
    Solution().tribonacci(25).print()
}

class Solution {
    fun tribonacci(n: Int): Int = with(intArrayOf(0, 1, 1)) {
        for (t in 3..n) this[t % size] = sum()
        this[n % size]
    }
}