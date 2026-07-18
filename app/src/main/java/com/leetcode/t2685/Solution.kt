package com.leetcode.t2685

/**
 * LeetCode 2685. Count the Number of Complete Components
 *
 * Компонента полная, если каждая пара её вершин соединена ребром,
 * т.е. в компоненте из k вершин ровно k * (k - 1) / 2 рёбер.
 *
 * Объединяем вершины через DSU, затем для каждого корня считаем
 * число вершин и число рёбер и проверяем формулу.
 */
class Solution {
    fun countCompleteComponents(n: Int, edges: Array<IntArray>): Int {
        val uf = UnionFind(n)
        for (edge in edges) {
            uf.union(edge[0], edge[1])
        }

        val nodeCount = IntArray(n)
        val edgeCount = IntArray(n)
        for (v in 0 until n) {
            nodeCount[uf.find(v)]++
        }
        for (edge in edges) {
            edgeCount[uf.find(edge[0])]++
        }

        var count = 0
        for (v in 0 until n) {
            if (uf.find(v) == v && edgeCount[v] == nodeCount[v] * (nodeCount[v] - 1) / 2) {
                count++
            }
        }
        return count
    }

    private class UnionFind(size: Int) {
        private val root = IntArray(size) { it }
        private val rank = IntArray(size)

        fun find(x: Int): Int {
            if (x != root[x]) {
                root[x] = find(root[x])
            }
            return root[x]
        }

        fun union(x: Int, y: Int) {
            val rootX = find(x)
            val rootY = find(y)
            if (rootX == rootY) return
            when {
                rank[rootX] > rank[rootY] -> root[rootY] = rootX
                rank[rootX] < rank[rootY] -> root[rootX] = rootY
                else -> {
                    root[rootY] = rootX
                    rank[rootX]++
                }
            }
        }
    }
}

fun main() {
    val solution = Solution()
    // {0,1,2} полная, {3,4} полная, {5} полная -> 3
    println(solution.countCompleteComponents(6, arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 2), intArrayOf(3, 4))))
    // {3,4,5} не полная (нет ребра 4-5) -> 1
    println(solution.countCompleteComponents(6, arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 2), intArrayOf(3, 4), intArrayOf(3, 5))))
}
