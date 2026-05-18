package com.leatcode.t264

fun main() {
    val result = Solution_Dp().nthUglyNumber(1352) //402653184
    println("Result: $result")
}


class Solution_Dp {

    /**
     * The main part of the function is a loop that runs from 1 to n-1.
     * In each iteration, it calculates the next ugly number
     * by taking the minimum of the next multiples of 2, 3, and 5.
     * This ensures that the dp array always contains the smallest possible ugly numbers in sorted order.
     */
    fun nthUglyNumber(n: Int): Int{
        val dp = IntArray(n)
        dp[0] = 1
        var indexMultipleOf2 = 0
        var indexMultipleOf3 = 0
        var indexMultipleOf5 = 0

        for (i in 1 until n){
            dp[i] = minOf(dp[indexMultipleOf2] * 2, dp[indexMultipleOf3] * 3, dp[indexMultipleOf5] * 5)
            if (dp[i] == dp[indexMultipleOf2] * 2) indexMultipleOf2++
            if (dp[i] == dp[indexMultipleOf3] * 3) indexMultipleOf3++
            if (dp[i] == dp[indexMultipleOf5] * 5) indexMultipleOf5++
        }

        return dp.last()
    }

    companion object {
        private val factors = intArrayOf(2, 3, 5)
    }
}

// Approach 1: Using Set
class Solution {

    // O(n * logm) where m - size of the set
    fun nthUglyNumber(n: Int): Int = with(sortedSetOf(1L)) {
        repeat(n - 1) {
            pollFirst()
                .let { lowest -> factors.map { it * lowest } }
                .let(::addAll)
        }
        first().toInt()
    }

    companion object {
        private val factors = intArrayOf(2, 3, 5)
    }
}

class SolutionTle {
    fun nthUglyNumber(n: Int): Int {
        var i = 1
        return generateSequence {
            while (!i.isUgly(2, 3, 5)) i++
            i.also { i++ }
        }.drop(n - 1).first()
    }

    private fun Int.isUgly(vararg factors: Int): Boolean {
        var x = this
        for (factor in factors) {
            while (x % factor == 0 && x != 1) x /= factor
        }
        return x == 1
    }
}