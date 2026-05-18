package com.leatcode.t1971

class Solution {
    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        val destinations = Array(n) { mutableSetOf<Int>() }
        edges.forEach { (i, j) ->
            destinations[i] += j
            destinations[j] += i
        }

        val queue = ArrayDeque<Int>().apply { add(source) }
        val visited = mutableSetOf<Int>().apply { add(source) }

        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val node = queue.removeFirst()
                if (node == destination) return true
                visited.add(node)
                destinations[node]
                    .filterNot { visited.contains(it) }
                    .let(queue::addAll)
            }
        }

        return false
    }
}