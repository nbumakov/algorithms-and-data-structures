package com.leetcode.t1646

import com.leetcode.util.print

fun main() {
    Solution().getMaximumGenerated(15).print()
}

class Solution {
    fun getMaximumGenerated(n: Int): Int {
        if (n == 0) return 0
        val array = IntArray(n + 1)
        array[0] = 0
        array[1] = 1
        for (i in 2..n) {
            if (i % 2 == 0) {
                array[i] = array[i / 2]
            } else {
                array[i] = array[i / 2] + array[i / 2 + 1]
            }
        }
        return array.max()!!
    }
}