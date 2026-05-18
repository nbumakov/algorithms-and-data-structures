package com.leetcode.t167

class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var lp = 0
        var rp = numbers.lastIndex

        while (lp < rp) {
            val sum = numbers[lp] + numbers[rp]
            when {
                sum < target -> lp++
                sum > target -> rp--
                else -> return intArrayOf(lp + 1, rp + 1)
            }
        }
        throw IllegalArgumentException()
    }
}