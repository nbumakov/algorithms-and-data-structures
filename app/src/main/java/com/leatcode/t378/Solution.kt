package com.leatcode.t378

import java.util.PriorityQueue

class Solution {

    // 1 2 3
    // 4 5 6
    // 7 8 9
    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        val pointers = IntArray(matrix.size) { 0 }
        fun Array<IntArray>.getValueAtRow(row: Int): Int =
            this[row].getOrElse(pointers[row]) { Int.MAX_VALUE }

        val heap = PriorityQueue<Int> { a, b -> matrix.getValueAtRow(a) - matrix.getValueAtRow(b) }
        (0..matrix.lastIndex).forEach { heap.add(it) }
        repeat(k - 1) {
            val minRow = heap.poll()!!
            pointers[minRow]++
            heap.add(minRow)
        }
        val row = heap.peek()!!
        return matrix[row][pointers[row]]
    }
}