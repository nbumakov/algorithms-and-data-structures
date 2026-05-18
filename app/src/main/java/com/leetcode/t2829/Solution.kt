package com.leetcode.t2829

import com.leetcode.util.print

fun main() {
    Solution().minimumSum(5, 4).print()
}

class Solution {
    fun minimumSum(n: Int, k: Int): Int {
        val set = mutableSetOf<Int>()
        val result = IntArray(n)
        var i = 0
        var number = 1
        while (i < result.size) {
            if (set.contains(k - number)) {
                number++
                continue
            }
            set.add(number)
            result[i++] = number++
        }
        return result.sum()
    }
}