package com.leatcode.t100125

import com.leatcode.util.print
import kotlin.math.min

fun main() {
    Solution().distributeCandies(5, 2).print()
    Solution().distributeCandies(3, 3).print()
}

class Solution {
    fun distributeCandies(n: Int, limit: Int): Int {
        val cache = hashMapOf<Pair<Int, Int>, Int>()
        fun dfs(i: Int, left: Int): Int {
            if (i == 3 && left > limit) return 0
            if (i == 3) return 1

            return cache.getOrPut(i to left){
                (0..min(limit, left)).sumOf { dfs(i + 1, left - it) }
            }
        }

        return dfs(1, n)
    }
}