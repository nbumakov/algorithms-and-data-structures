package com.leetcode.t3264

import java.util.PriorityQueue

class Solution {
    fun getFinalState(nums: IntArray, k: Int, multiplier: Int): IntArray {
        val minHeap = PriorityQueue<IndexedValue<Int>>(compareBy({ it.value }, { it.index }))
            .apply { nums.withIndex().forEach { add(it) } }

        repeat(k) {
            val min = minHeap.remove()
            minHeap.add(IndexedValue(min.index, min.value * multiplier))
        }
        return IntArray(nums.size).apply {
            minHeap.forEach { this[it.index] = it.value }
        }
    }
}