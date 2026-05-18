package com.leatcode.t973

import java.util.PriorityQueue

class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val distances = points.map { it[0] * it[0] + it[1] * it[1] }
        val heap = PriorityQueue<Int> { a, b -> distances[b] - distances[a] }

        for (i in points.indices) {
            heap.add(i)
            if (heap.size > k) heap.remove()
        }
        return Array(k) { points[heap.poll()!!] }
    }
}