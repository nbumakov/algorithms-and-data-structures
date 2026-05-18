package com.leetcode.t2842

import com.leetcode.util.print

fun main() {
    Solution().countKSubsequencesWithMaxBeauty("bcca", 2).print()
    Solution().countKSubsequencesWithMaxBeauty("abbcd", 4).print()
    Solution().countKSubsequencesWithMaxBeauty("fkp", 2).print()
    Solution().countKSubsequencesWithMaxBeauty("iewvwmocnrqfuxa", 12).print()
}

private const val MODULO = 1000000007

class Solution {
    fun countKSubsequencesWithMaxBeauty(s: String, k: Int): Int {
        if (s.toSet().size < k) return 0

        val freq = IntArray(26).apply {
            s.forEach { this[it - 'a']++ }
            sortDescending()
        }

        val last = freq[k - 1]
        val n = freq.filter { it == last }.count()
        val places = k - freq.filter { it > last }.count()
        val partSum = freq.take(k).fold(1L) { acc, i -> acc * i % MODULO }
        val sum = (n.factorial() / places.factorial() / (n - places).factorial()) % MODULO * partSum // C(n, k) = n! / (k!(n - k)!)
        return (sum % MODULO).toInt()
    }

    private fun Int.factorial(): Long {
        var result = 1L
        for (i in 1..this) {
            result *= i
        }
        return result
    }

}