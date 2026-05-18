package com.leetcode.t2191

fun main() {
    val mapping = intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 0)
//    Solution().sortJumbled(
//        mapping = mapping,
//        nums = intArrayOf(0,1,2,3,4,5,6,7,8,9)
//    ).contentToString().let(::println)

    with(Solution()) {
        0.map(mapping).let(::println)
    }
}

class Solution {
    fun sortJumbled(mapping: IntArray, nums: IntArray): IntArray =
        nums.sortedBy { it.map(mapping) }.toIntArray()

    fun Int.map(mapping: IntArray): Int {
        if (this == 0) return mapping[0]

        var num = this
        var result = 0
        var pow = 1
        while (num > 0) {
            val d = num % 10
            result += mapping[d] * pow
            pow *= 10
            num /= 10
        }
        return result
    }
}