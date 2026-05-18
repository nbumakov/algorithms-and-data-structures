package com.leetcode.t1743


class Solution {

    //[[2,1],[3,4],[3,2]]
    // 2 -> 1, 3
    // 1 -> 2,
    // 3 -> 4, 2
    // 4 -> 3
    fun restoreArray(adjacentPairs: Array<IntArray>): IntArray {
        val adj = hashMapOf<Int, MutableList<Int>>().apply {
            adjacentPairs.forEach {
                getOrPut(it[0]) { mutableListOf() } += it[1]
                getOrPut(it[1]) { mutableListOf() } += it[0]
            }
        }

        var curr: Int? = with(adj) {
            for (key in keys) if (adj[key]!!.size == 1) return@with key
            return@with null
        }

        val result = mutableSetOf<Int>()
        while (curr != null) {
            result.add(curr)
            curr = adj[curr]!!.firstOrNull { it !in result }
        }

        return result.toIntArray()
    }
}