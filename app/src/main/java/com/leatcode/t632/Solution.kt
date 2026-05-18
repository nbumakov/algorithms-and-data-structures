package com.leatcode.t632

import java.util.PriorityQueue
import java.util.TreeSet
import kotlin.math.max


class Solution {
    fun smallestRange(nums: List<List<Int>>): IntArray {
        // Priority queue to store (value, list index, element index)
        val pq = PriorityQueue(compareBy { a: IntArray -> a[0] })
        var maxVal = Int.MIN_VALUE
        var range = 0 .. Int.MAX_VALUE

        // Insert the first element from each list into the min-heap
        nums.forEachIndexed { i, list ->
            pq.offer(intArrayOf(list[0], i, 0))
            maxVal = max(maxVal, list[0])
        }
        // Continue until we can't proceed further
        while (pq.size == nums.size) {
            val data = pq.remove()
            val (minVal, row, col) = data

            // Update the smallest range
            if (maxVal - minVal < range.last - range.first) {
                range = minVal .. maxVal
            }

            // If possible, add the next element from the same row to the heap
            if (col + 1 < nums[row].size) {
                val nextVal = nums[row][col + 1]
                pq.offer(intArrayOf(nextVal, row, col + 1))
                maxVal = max(maxVal, nextVal)
            }
        }

        return intArrayOf(range.first, range.last)
    }
}

class SolutionSD{
    fun smallestRange(nums: List<List<Int>>): IntArray {
        val columns = IntArray(nums.size)
        var res = intArrayOf(0, Int.MAX_VALUE)
        val tree = TreeSet<Int>(compareBy({nums[it][columns[it]]}, { it }))
        tree += nums.indices

        while (tree.size == nums.size) {
            val minValIndex = tree.pollFirst()
            val maxValIndex = tree.last()
            val a = nums[minValIndex][columns[minValIndex]]
            val b = nums[maxValIndex][columns[maxValIndex]]

            if (b - a < res[1] - res[0]) res = intArrayOf(a, b)
            if (++columns[minValIndex] < nums[minValIndex].size) tree += minValIndex
        }
        return res
    }
}