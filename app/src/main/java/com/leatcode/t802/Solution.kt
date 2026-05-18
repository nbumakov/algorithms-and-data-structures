package com.leatcode.t802

import com.leatcode.util.print
import java.util.TreeSet

fun main() {
    arrayOf(false).all { it }.print()

    Solution().eventualSafeNodes(
        arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(5),
            intArrayOf(0),
            intArrayOf(5),
            intArrayOf(),
            intArrayOf(),
        )
    ).print()

    Solution().eventualSafeNodes(
        arrayOf(
            intArrayOf(),
            intArrayOf(0, 2, 3, 4),
            intArrayOf(3),
            intArrayOf(4),
            intArrayOf(),
        )
    ).print()
}

class Solution {

    // not mine
//    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
//        val cycle = mutableSetOf<Int>()
//        val safe = mutableSetOf<Int>()
//        fun cycle(curr: Int): Boolean {
//            return if (safe.contains(curr)) false else !cycle.add(curr)
//                    || graph[curr].any { cycle(it) }
//                .also {
//                    if (!it) {
//                        cycle.remove(curr)
//                        safe.add(curr)
//                    }
//                }
//        }
//        return graph.indices.filter { !cycle(it) }
//    }

    private val safeNodes = TreeSet<Int>()
    private lateinit var visited: BooleanArray

    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        visited = BooleanArray(graph.size) { false }
        for (n in graph.indices) {
            visited.fill(false)
            graph.trackNode(n)
        }

        return safeNodes.toList()
    }

    private fun Array<IntArray>.trackNode(node: Int): Boolean {
        if (safeNodes.contains(node)) {
            return true
        }
        if (this[node].isEmpty()) {
            safeNodes.add(node)
            return true
        }

        if (visited[node]) {
            return false
        }
        visited[node] = true

        if (this[node].any { !trackNode(it) }) {
            return false
        }

        safeNodes.add(node)
        return true
    }
}