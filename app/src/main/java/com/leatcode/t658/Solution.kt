package com.leatcode.t658

import com.leatcode.util.print
import java.util.PriorityQueue
import kotlin.math.abs


fun main() {
    Solution().findClosestElements(intArrayOf(1, 2, 3, 4, 5), 4, 3).print()
}

class Solution {

    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int>? {
        var l = 0
        var r = arr.size - k

        while (l < r) {
            val mid = (l + r) / 2
            if (x - arr[mid] > arr[mid + k] - x) {
                l = mid + 1
            } else {
                r = mid
            }
        }

        return arr.slice(l until l + k)
    }

    // sorting
    fun findClosestElements3(arr: IntArray, k: Int, x: Int): List<Int> =
        arr.sortedBy { abs(it - x) }
            .take(k)
            .sorted()


    // heap
    fun findClosestElements1(arr: IntArray, k: Int, x: Int): List<Int> {
        val heap = PriorityQueue<Int> { i, j ->
            (abs(arr[j] - x) - abs(arr[i] - x))
                .takeIf { it != 0 }
                ?: (j - i)
        }
        for (i in arr.indices) {
            heap.add(i)
            if (heap.size > k) heap.remove()
        }
        return heap.map { arr[it] }.sorted()
    }
}