package com.leetcode.t8

import com.leetcode.util.print

fun main() {
    Solution().myAtoi(" -12").print()
}

class Solution {
    fun myAtoi(s: String): Int {
        var p = 0
        var res = 0
        var sign = 1
        while (p <= s.lastIndex && s[p] == ' ') p++
        if (p > s.lastIndex) return 0

        if (s[p] == '-') {
            sign = -1
            p++
        } else if (s[p] == '+') {
            p++
        }

        while (p <= s.lastIndex && s[p].isDigit()) {
            val value = sign * Character.digit(s[p++], 10)
            if (res > Int.MAX_VALUE / 10 || res == Int.MAX_VALUE / 10 && value > 7) {
                return Int.MAX_VALUE
            }
            if (res < Int.MIN_VALUE / 10 || res == Int.MIN_VALUE / 10 && value < -8) {
                return Int.MIN_VALUE
            }
            res *= 10
            res += value
        }

        return res
    }
}