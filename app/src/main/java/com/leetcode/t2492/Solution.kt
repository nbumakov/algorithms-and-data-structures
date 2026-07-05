package com.leetcode.t2492

import com.leetcode.util.print

// Union find with path compression only - Accepted
class Solution {
    fun minScore(n: Int, roads: Array<IntArray>): Int {
        val uf = UnionFind(n)
        for (road in roads) {
            uf.union(road[0] - 1, road[1] - 1)
        }

        return roads.minOf { (start, _, value) ->
            value.takeIf { uf.isConnected(0, start - 1) } ?: Int.MAX_VALUE
        }
    }

    private class UnionFind(size: Int) {
        private val root = IntArray(size) { it }

        fun find(x: Int): Int {
            if (x != root[x]) {
                root[x] = find(root[x])
            }
            return root[x]
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

// Union find with path compression + union by rank - Accepted
class Solution2 {
    fun minScore(n: Int, roads: Array<IntArray>): Int {
        val uf = UnionFind(n)
        for (road in roads) {
            uf.union(road[0] - 1, road[1] - 1)
        }

        return roads.minOf { (start, _, value) ->
            value.takeIf { uf.isConnected(0, start - 1) } ?: Int.MAX_VALUE
        }
    }

    private class UnionFind(size: Int) {
        private val root = IntArray(size) { it }
        private val rank = IntArray(size)

        fun find(x: Int): Int {
            var x = x
            while (x != root[x]) {
                root[x] = root[root[x]] // path halving
                x = root[x]
            }
            return x
        }

        fun union(x: Int, y: Int) {
            val rootX = find(x)
            val rootY = find(y)
            if (rootX == rootY) return
            when {
                rank[rootX] < rank[rootY] -> root[rootX] = rootY
                rank[rootX] > rank[rootY] -> root[rootY] = rootX
                else -> {
                    root[rootY] = rootX
                    rank[rootX]++
                }
            }
        }

        fun isConnected(x: Int, y: Int): Boolean =
            find(x) == find(y)
    }
}

fun main() {
    Solution()
        .minScore(
            4, arrayOf(
                intArrayOf(1, 2, 9),
                intArrayOf(2, 3, 6),
                intArrayOf(2, 4, 5),
                intArrayOf(1, 4, 7)
            )
        ).print()

    Solution2()
        .minScore(
            4, arrayOf(
                intArrayOf(1, 2, 9),
                intArrayOf(2, 3, 6),
                intArrayOf(2, 4, 5),
                intArrayOf(1, 4, 7)
            )
        ).print()
}
