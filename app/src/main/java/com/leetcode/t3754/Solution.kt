package com.leetcode.t3754

class Solution {
    fun sumAndMultiply(n: Int): Long {
        val digits = n.toString().filter { it != '0' }
        return digits.sumOf { it - '0' }.toLong() * digits.toLong()
    }
}

class Solution2 {
    fun sumAndMultiply(n: Int): Long {
        var num = n
        var sum = 0
        var x = 0L
        var place = 1L
        while (num > 0) {
            val digit = num % 10
            if (digit != 0) {
                sum += digit
                x += digit * place
                place *= 10
            }
            num /= 10
        }
        return sum.toLong() * x
    }
}