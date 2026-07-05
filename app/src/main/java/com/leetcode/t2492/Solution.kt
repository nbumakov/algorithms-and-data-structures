package com.leetcode.t2492

import com.leetcode.util.print

// Union find - Time Limit Exceeded
class Solution {
    fun minScore(n: Int, roads: Array<IntArray>): Int {
        val uf = UnionFind(n)
        for (road in roads) {
            uf.union(road[0] - 1, road[1] - 1)
        }

        var minScore = Int.MAX_VALUE
        for (road in roads) {
            if (uf.isConnected(0, road[0] - 1)) {
                minScore = road[2].coerceAtMost(minScore)
            }
        }

        return minScore
    }

    private class UnionFind(size: Int) {
        private val root = IntArray(size) { it }

        fun find(x: Int): Int {
            var x = x
            while (x != root[x]) x = root[x]
            return x
        }

        fun union(x: Int, y: Int) {
            val rootX = find(x)
            val rootY = find(y)
            root[rootY] = rootX
        }

        fun isConnected(x: Int, y: Int): Boolean =
            find(x) == find(y)
    }
}

fun main() {
    Solution()
        .minScore(4, arrayOf(
            intArrayOf(1, 2, 9),
            intArrayOf(2, 3, 6),
            intArrayOf(2, 4, 5),
            intArrayOf(1, 4, 7)
        )).print()
}