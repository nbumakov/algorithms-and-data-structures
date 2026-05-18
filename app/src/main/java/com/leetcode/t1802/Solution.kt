package com.leetcode.t1802

fun main() {
//    val x = 3
//    println(Solution().tail(x, 1))
//    println(Solution().sum(x, 3, 2))
//    println(Solution().maxValue(7, 0, 930041194))
//    println(Solution().maxValue(4, 2, 6))
//    println(Solution().maxValue(3, 2, 18))
    println(Solution().maxValue(1, 0, 24))
    println(Solution().maxValueSlow(1, 0, 24))
}

class Solution {
    fun maxValueSlow(n: Int, index: Int, maxSum: Int): Int {

        var x = maxSum
        while (sum(x, index + 1, n - index) > maxSum) {
            x--
        }

        return x
    }

    fun maxValue(n: Int, index: Int, maxSum: Int): Int {
        var bottom = 1
        var top = maxSum

        val left = index + 1
        val right = n - index

        while (top - bottom > 1) {
            val mid = bottom + (top - bottom) / 2

            when {
                sum(mid, left, right) > maxSum -> top = mid - 1
                else -> bottom = mid
            }
        }

        return if(sum(top, left, right) <= maxSum) top else bottom
    }


    private fun sum(x: Int, leftSize: Int, rightSize: Int): Long {
        val n = rightSize + leftSize - 1
        val x1 = (x - 1).toLong()
        return n + x1 * x1 - tail(x1, leftSize) - tail(x1, rightSize)
    }

    private fun tail(x: Long, length: Int): Long {
        if (length >= x) {
            return 0
        }

        val value = x - length
        val tailSize = x - length
        return (value + 1) * tailSize / 2
    }
}
