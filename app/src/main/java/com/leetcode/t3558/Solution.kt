package com.leetcode.t3558


fun main() {
    print(
        Solution().assignEdgeWeights(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(1, 3),
                intArrayOf(3, 4),
                intArrayOf(3, 5)
            )
        )
    )
}

class Solution {
    fun assignEdgeWeights(edges: Array<IntArray>): Int {
        val adj = HashMap<Int, MutableList<Int>>()
        for ((u, v) in edges) {
            adj.getOrPut(u) { mutableListOf() }.add(v)
            adj.getOrPut(v) { mutableListOf() }.add(u)
        }

        fun depth(u: Int, parent: Int): Int {
            var best = 0
            for (w in adj[u].orEmpty()) {
                if (w != parent) best = maxOf(best, 1 + depth(w, u))
            }
            return best
        }

        val d = depth(1, -1)
        var result = 1L
        repeat(d - 1) { result = (result * 2) % 1_000_000_007 }
        return result.toInt()
    }

}