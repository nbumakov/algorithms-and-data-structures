package com.leatcode.t1337

import com.leatcode.util.print
import java.util.PriorityQueue

fun main() {
    Solution().kWeakestRows(
        arrayOf(
            intArrayOf(1, 1, 1, 0, 0, 0, 0),
            intArrayOf(1, 1, 1, 1, 1, 1, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0),
            intArrayOf(1, 1, 1, 0, 0, 0, 0),
            intArrayOf(1, 1, 1, 1, 1, 1, 1),
        ),
        4
    ).print()
}

class Solution {

    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray =
        mat.map { it.sum() }
            .withIndex()
            .sortedBy { it.value }
            .take(k)
            .map { it.index }
            .toIntArray()

    fun kWeakestRows1(mat: Array<IntArray>, k: Int): IntArray {
        val rows = mat.map { it.sum() }
        val heap = PriorityQueue<Int> { a, b ->
            (rows[b] - rows[a]).takeIf { it != 0 } ?: (b - a)
        }
        for (i in rows.indices) {
            heap.add(i)
            if (heap.size > k) heap.remove()
        }

        return IntArray(heap.size).apply {
            for (i in heap.size - 1 downTo 0) {
                this[i] = heap.poll()!!
            }
        }
    }
}