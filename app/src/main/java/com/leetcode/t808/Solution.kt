package com.leetcode.t808

import com.leetcode.util.print

fun main() {
    Solution().soupServings(5000).print()
}

class Solution {
    fun soupServings(n: Int): Double {
        if (n > 5000) return 1.0
        return serve(n, n, hashMapOf())
    }

    private fun serve(a: Int, b: Int, cache: HashMap<Pair<Int, Int>, Double>): Double {
        if (a <= 0 && b > 0) return 1.0
        if (a <= 0) return 0.5
        if (b <= 0) return 0.0

        val key = a to b
        //if (cache.containsKey(key)) return cache[key]!!

        return (0.25 * (serve(a - 100, b, cache)
                + serve(a - 75, b - 25, cache)
                + serve(a - 50, b - 50, cache)
                + serve(a - 25, b - 75, cache)
                )).also { cache[key] = it }
    }
}