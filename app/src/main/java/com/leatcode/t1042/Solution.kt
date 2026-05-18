package com.leatcode.t1042

class Solution {

    fun gardenNoAdj(n: Int, paths: Array<IntArray>): IntArray {
        val adj = Array(n) { mutableSetOf<Int>() }
        paths.forEach { (start, end) ->
            adj[start - 1] += end - 1
            adj[end - 1] += start - 1
        }

        val result = IntArray(n)

        for (i in 0 until n) {
            result[i] = Colors.first { color ->
                adj[i].all { result[it] != color }
            }
        }

        return result
    }

    companion object {
        val Colors = intArrayOf(1, 2, 3, 4)
    }
}
