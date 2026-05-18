package com.leatcode.t204

import com.leatcode.util.print
import kotlin.math.sqrt

fun main() {
    Solution().countPrimes(5000000).print()
    Solution().countPrimes2(5000000).print()
}

class Solution {


    // 2, 3, 4, 5, 6, 7, 8, 9, 10
    fun countPrimes(n: Int): Int {
        if (n <= 2) return 0

        val primes = BooleanArray(n) { true }
        for (i in 2..sqrt(n.toDouble()).toInt()) {
            if (primes[i]) {
                for (j in 2 * i until n step i) primes[j] = false
            }
        }

        return primes.count { it } - 2
    }

    // TLE
    fun countPrimes2(n: Int): Int {
        if (n <= 2) return 0

        val primes = mutableListOf(2)
        for (i in 3 until n step 2) {
            val sqrt = sqrt(i.toDouble()).toInt()
            for (prime in primes) {
                if (prime > sqrt) {
                    primes.add(i)
                    break
                }
                if (i % prime == 0) break
            }
        }

        return primes.size
    }
}