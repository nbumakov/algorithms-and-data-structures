package com.leetcode.t743

import com.leetcode.util.print
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.util.LinkedList
import java.util.Queue
import kotlin.math.abs

// TODO: Solve with Dijkstra's
class Solution {

    // BFS
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        val nodes = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
        times.forEach { nodes[it.first()].add(it[1] to it[2]) }

        val receivedTime = hashMapOf<Int, Int>().apply { this[k] = 0 }
        val queue: Queue<Int> = LinkedList<Int>().apply { add(k) }

        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val node = queue.poll()!!
                val nodeTime = receivedTime[node]!!

                nodes[node].forEach { (node, time) ->
                    val deliveryTime = nodeTime + time
                    if (!receivedTime.containsKey(node) || receivedTime[node]!! > deliveryTime) {
                        queue.add(node)
                        receivedTime[node] = deliveryTime
                    }
                }
            }
        }

        return if (receivedTime.keys.size == n) {
            receivedTime.values.max()
        } else -1
    }

    fun daysBetweenDates(date1: String, date2: String): Int {
        val localDate1 = date1.toLocalDate()
        val localDate2 = date2.toLocalDate()
        return abs(ChronoUnit.DAYS.between(localDate1, localDate2).toInt())
    }

    private fun String.toLocalDate() = split("-")
        .map { it.toInt() }
        .let { LocalDate.of(it[0], it[1], it[2]) }
}

fun main() {
    val bm = object : Solution7.BinaryMatrix {
        val matrix = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(1, 1),
        )

        override fun get(row: Int, col: Int): Int = matrix[row][col]

        override fun dimensions(): List<Int> = listOf(2, 2)

    }
    Solution7().leftMostColumnWithOne(bm).print()
}

class Solution7 {


    // This is the BinaryMatrix's API interface.
    // You should not implement it, or speculate about its implementation
    interface BinaryMatrix {
        fun get(row: Int, col: Int): Int
        fun dimensions(): List<Int>
    }

    fun leftMostColumnWithOne(binaryMatrix: BinaryMatrix): Int {

        fun getFirstOneIndex(row: Int, size: Int): Int {
            var l = 0
            var r = size - 1
            while (l <= r) {
                val mid = (l + r) / 2
                val value = binaryMatrix.get(row, mid)
                when {
                    value >= 1 -> r = mid - 1
                    else -> l = mid + 1
                }
            }
            return if (r + 1 < size && binaryMatrix.get(row, r + 1) == 1) r + 1 else -1
        }

        val dimensions = binaryMatrix.dimensions()
        val rows = dimensions.first()
        val columns = dimensions.last()

        var firstColumn = Int.MAX_VALUE
        for (row in 0 until rows) {
            val columnIndex = getFirstOneIndex(row, columns)
            if (columnIndex >= 0) {
                firstColumn = minOf(firstColumn, columnIndex)
            }
        }

        return if (firstColumn == Int.MAX_VALUE) -1 else firstColumn
    }


}