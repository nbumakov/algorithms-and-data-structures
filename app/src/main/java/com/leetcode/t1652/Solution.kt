package com.leetcode.t1652

import kotlin.math.abs

fun main() {
    Solution().decrypt(intArrayOf(2,4,9,3), -2).forEach {
        print("$it ")
    }
}

class Solution {
    fun decrypt(code: IntArray, k: Int): IntArray {
        if (k == 0) return IntArray(code.size)

        var sum = 0
        for (i in 0 until abs(k)) {
            sum += code[i % code.size]
        }

        val res = IntArray(code.size)
        for (i in code.indices) {
            if (k < 0) {
                res[(i + abs(k)) % code.size] = sum
            } else {
                res[i] = sum
            }
            sum -= code[i]
            sum += code[(i + abs(k)) % code.size]
        }
        return res
    }
}