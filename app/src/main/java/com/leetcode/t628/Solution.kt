package com.leetcode.t628

import java.util.PriorityQueue
import kotlin.math.max

class Solution {
    fun maximumProduct(nums: IntArray): Int {
        val minHeap = PriorityQueue<Int>()
        val maxHeap = PriorityQueue<Int> { a, b -> b - a }
        for (n in nums) {
            minHeap.add(n)
            maxHeap.add(n)
            if (minHeap.size > 3) minHeap.poll()
            if (maxHeap.size > 2) maxHeap.poll()
        }

        val maxValues = minHeap.toList()
        val minValues = maxHeap.toList()
        return max(maxValues[0] * maxValues[1] * maxValues[2], minValues[0] * minValues[1] * maxValues.max())
    }
}