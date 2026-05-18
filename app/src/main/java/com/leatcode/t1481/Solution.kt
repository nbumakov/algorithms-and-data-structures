package com.leatcode.t1481

import com.leatcode.util.print
import java.util.PriorityQueue

fun main() {
    Solution().findLeastNumOfUniqueInts2(intArrayOf(5, 5, 4), 1).print()
}

class Solution {
    fun findLeastNumOfUniqueInts(arr: IntArray, k: Int): Int {
        val countMap = mutableMapOf<Int, Int>()
        arr.forEach {
            countMap[it] = countMap.getOrDefault(it, 0) + 1
        }
        val heap = PriorityQueue<Int> { a, b -> countMap[a]!! - countMap[b]!! }
        countMap.keys.forEach(heap::add)

        var itemsForRemove = k
        while (!heap.isEmpty() && countMap[heap.first()]!! <= itemsForRemove) {
            itemsForRemove -= countMap[heap.first()]!!
            heap.remove()
        }
        return heap.size
    }

    fun findLeastNumOfUniqueInts2(arr: IntArray, k: Int): Int = arr.asList()
        .groupingBy { it }
        .eachCount()
        .values
        .sorted()
        .run {
            var left = k
            size - count {
                left -= it
                left >= 0
            }
        }
}