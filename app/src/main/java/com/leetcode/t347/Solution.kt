package com.leetcode.t347

import com.leetcode.util.print
import java.util.PriorityQueue


fun main() {
    Solution().topKFrequent_heep(intArrayOf(1, 1, 1, 2, 2, 3), 2)
        .joinToString().print()
}

class Solution {

    // O(n)
    fun topKFrequent_heep(nums: IntArray, k: Int): IntArray {
        val map = hashMapOf<Int, Int>()
        nums.forEach { n -> map[n] = map.getOrDefault(n, 0) + 1 }
        val heap = PriorityQueue<Int> { i1, i2 -> map[i1]!! - map[i2]!! }
        map.keys.forEach { heap.add(it); if (heap.size > k) heap.remove() }
        return heap.toIntArray()
    }

    // O(n)
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = hashMapOf<Int, Int>()
        nums.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }

        val freq = Array<MutableList<Int>>(nums.size + 1) { mutableListOf() } // [freq : elements]
        map.forEach { (k, v) -> freq[v].add(k) }

        return freq.flatMap { it }.takeLast(k).toIntArray()
    }


    //O(nLogn)
    fun topKFrequent_OneLine(nums: IntArray, k: Int): IntArray =
        nums.groupBy { it }
            .mapValues { it.value.size }
            .map { it }
            .sortedBy { it.value }
            .takeLast(k)
            .map { it.key }
            .toIntArray()
}