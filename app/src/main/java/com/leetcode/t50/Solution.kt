package com.leetcode.t50

import com.leetcode.util.print

fun main() {
    Solution().myPow(2.0, -2).print()
}

class Solution {

    fun myPow(x: Double, n: Int): Double {
        if (n == 0) return 1.0
        if (n < 0) return 1 / x.exp(-n.toLong())

        return x.exp(n.toLong())
    }

    private fun Double.exp(n: Long): Double {
        if (n == 1L) return this
        return (this * this).exp(n / 2) * if (n % 2 == 1L) this else 1.0
    }


    fun myPowIterative(x: Double, n: Int): Double = when {
        n == 0 -> 1.0
        n < 0 -> (1 / x).expIterative(-n.toLong())
        else -> x.expIterative(n.toLong())
    }

    private fun Double.expIterative(n: Long): Double {
        var k = n
        var x = this
        var result = 1.0
        while (k > 0) {
            if (k % 2 != 0L) {
                result *= x
            }
            x *= x
            k /= 2
        }
        return result
    }

//    fun myPow(x: Double, n: Int): Double =
//        x.exp(n.toLong())

//    private fun Double.exp(n: Long): Double {
//        if (n == 0L) return 1.0
//        if (n < 0) return 1 / exp(-n)
//
//        return (if (n % 2 == 1L) this else 1.0) * (this * this).exp(n / 2)
//    }

}