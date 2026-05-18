package com.leetcode.t66

/**
 * You are given a large integer represented as an integer array digits,
 * where each digits[i] is the ith digit of the integer.
 * The digits are ordered from most significant to least significant in left-to-right order.
 * The large integer does not contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 */
class Solution {
    fun plusOne(digits: IntArray): IntArray {
        var overflow = 1
        var index = digits.lastIndex

        while (overflow > 0 && index >= 0) {
            when (val sum = digits[index] + overflow) {
                10 -> digits[index] = 0
                else -> {
                    digits[index] = sum
                    overflow = 0
                }
            }
            index--
        }

        return if (overflow > 0) {
            intArrayOf(1, *digits)
        } else {
            digits
        }
    }
}

fun main() {
    Solution()
        .plusOne(intArrayOf(9, 9, 9))
        .forEach(::print)
}