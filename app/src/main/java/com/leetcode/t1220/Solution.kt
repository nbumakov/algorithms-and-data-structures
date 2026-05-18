package com.leetcode.t1220

import com.leetcode.util.print

fun main() {
    Solution().countVowelPermutation(1).print()
    Solution().countVowelPermutation(2).print()
    Solution().countVowelPermutation(5).print()
}

class Solution {

    fun countVowelPermutation(n: Int): Int {
        val dp = mutableMapOf<Pair<Char, Int>, Long>()

        /**
         * @returns qty of permutations if it starts on position i with letter char
         *
         *  @param i - start position of premutations
         *  @param c - start simbol of premutations
         */
        fun dfs(c: Char, i: Int): Long {
            if (i == n) return 1L

            return dp.getOrPut(c to i) {
                Adj[c]!!.sumOf { dfs(it, i + 1) } % MOD
            }
        }

        return (listOf('a', 'e', 'i', 'o', 'u').sumOf { dfs(it, 1) } % MOD).toInt()
    }

    companion object {
        private const val MOD = 1_000_000_007
        private val Adj = mapOf(
            'a' to charArrayOf('e'),
            'e' to charArrayOf('a', 'i'),
            'i' to charArrayOf('a', 'e', 'o', 'u'),
            'o' to charArrayOf('i', 'u'),
            'u' to charArrayOf('a'),
        )
    }
}