package com.leetcode.t3559

class Solution {
    fun assignEdgeWeights(edges: Array<IntArray>, queries: Array<IntArray>): IntArray {
        val mod = 1_000_000_007L
        val n = edges.size + 1
        val adj = Array(n + 1) { mutableListOf<Int>() }
        for ((u, v) in edges) {
            adj[u].add(v)
            adj[v].add(u)
        }

        val log = 17 // 2^17 > 1e5
        val depth = IntArray(n + 1)
        val up = Array(log) { IntArray(n + 1) }

        // BFS from root 1 to fill depth[] and immediate parents up[0][]
        val visited = BooleanArray(n + 1)
        val queue = ArrayDeque<Int>().also { it.add(1) }
        visited[1] = true
        up[0][1] = 1 // root is its own parent
        while (queue.isNotEmpty()) {
            val u = queue.removeFirst()
            for (v in adj[u]) {
                if (!visited[v]) {
                    visited[v] = true
                    depth[v] = depth[u] + 1
                    up[0][v] = u
                    queue.add(v)
                }
            }
        }

        // binary lifting table
        for (k in 1 until log)
            for (v in 1..n)
                up[k][v] = up[k - 1][up[k - 1][v]]

        fun lca(a: Int, b: Int): Int {
            var x = a
            var y = b
            if (depth[x] < depth[y]) x = y.also { y = x }
            val diff = depth[x] - depth[y]
            for (k in 0 until log) if ((diff shr k) and 1 == 1) x = up[k][x]
            if (x == y) return x
            for (k in log - 1 downTo 0) if (up[k][x] != up[k][y]) {
                x = up[k][x]
                y = up[k][y]
            }
            return up[0][x]
        }

        // pow2[i] = 2^i mod p
        val pow2 = LongArray(n + 1)
        pow2[0] = 1
        for (i in 1..n) pow2[i] = pow2[i - 1] * 2 % mod

        return queries.map { (u, v) ->
            val dist = depth[u] + depth[v] - 2 * depth[lca(u, v)]
            if (dist == 0) 0 else pow2[dist - 1].toInt()
        }.toIntArray()
    }
}
