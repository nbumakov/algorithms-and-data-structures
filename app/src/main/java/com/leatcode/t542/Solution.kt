package com.leatcode.t542

import com.leatcode.util.print
import java.util.LinkedList
import java.util.Queue

fun main() {
    Solution().updateMatrix(
        arrayOf(
            intArrayOf(1, 0, 1, 1, 0, 0, 1, 0, 0, 1),
            intArrayOf(0, 1, 1, 0, 1, 0, 1, 0, 1, 1),
            intArrayOf(0, 0, 1, 0, 1, 0, 0, 1, 0, 0),
            intArrayOf(0, 0, 1, 0, 1, 0, 0, 1, 0, 0),
            intArrayOf(1, 0, 1, 0, 1, 1, 1, 1, 1, 1),
            intArrayOf(0, 1, 0, 1, 1, 0, 0, 0, 0, 1),
            intArrayOf(0, 0, 1, 0, 1, 1, 1, 0, 1, 0),
            intArrayOf(0, 1, 0, 1, 0, 1, 0, 0, 1, 1),
            intArrayOf(1, 0, 0, 0, 1, 1, 1, 1, 0, 1),
            intArrayOf(1, 1, 1, 1, 1, 1, 1, 0, 1, 0),
            intArrayOf(1, 1, 1, 1, 0, 1, 0, 0, 1, 1),
        )
    ).forEach {
        it.joinToString(" ").print()
    }
}

class Solution {

    // BFS is the key to find a distance in graph
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val iQ: Queue<Int> = LinkedList()
        val jQ: Queue<Int> = LinkedList()
        val visited = Array(mat.size) { BooleanArray(mat[it].size) }

        fun add(i: Int, j: Int) {
            if (i !in mat.indices || j !in mat[i].indices) return
            if (visited[i][j]) return
            iQ.add(i)
            jQ.add(j)
        }

        for (i in mat.indices) {
            for (j in mat[i].indices) {
                if (mat[i][j] == 0) add(i, j)
            }
        }

        var level = 0
        while (iQ.isNotEmpty()) {
            for (l in 0 until iQ.size) {
                val i = iQ.poll()!!
                val j = jQ.poll()!!
                if (visited[i][j]) continue
                visited[i][j] = true
                mat[i][j] = level

                add(i , j + 1)
                add(i + 1 , j)
                add(i , j - 1)
                add(i - 1 , j)
            }
            level++
        }

        return mat
    }
}