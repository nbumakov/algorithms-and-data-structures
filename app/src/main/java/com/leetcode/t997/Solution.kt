package com.leetcode.t997

import com.leetcode.util.print

fun main() {
    Solution().findJudge(
        2, arrayOf(
            intArrayOf(1, 2)
        )
    ).print()
}

class Solution {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        val adj = Array(n) { BooleanArray(n) }
        trust.forEach { (j, i) -> adj[i - 1][j - 1] = true }
        return adj.filterIndexed { i, a ->
            a.indices.all { it == i || a[it] } && adj.all { !it[i] }
        }
            .takeIf { it.isNotEmpty() }
            ?.first()?.indexOfFirst { !it }?.let { it + 1 }
            ?: -1
    }

    fun findJudge2(n: Int, trust: Array<IntArray>): Int {
        val potentialJudges = (1..n).toSet() - trust.map { it[0] }.toSet()
        return potentialJudges.firstOrNull { judje ->
            trust.count { it[1] == judje } == n - 1
        } ?: -1
    }


    // Approach 2: One Array
    fun findJudge3(n: Int, trust: Array<IntArray>): Int {

        // Initialize an array to keep track of trust levels -->
        val trustLevel = IntArray(n + 1).apply { this[0] = -1 }

        // Update trust levels based on the trust array
        for ((a, b) in trust) {
            trustLevel[a]--
            trustLevel[b]++
        }

        // Find the person who satisfies properties 1 and 2
        return trustLevel.indexOfFirst { it == n - 1 }
    }
}