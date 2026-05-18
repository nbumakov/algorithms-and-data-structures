package com.leatcode.t1046

import com.leatcode.util.print
import java.util.PriorityQueue
import kotlin.math.abs

fun main() {
    Solution().lastStoneWeight(intArrayOf(1, 3, 3)).print()
}

class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val heap = PriorityQueue<Int> { a, b -> b - a }
            .apply { stones.forEach { add(it) } }

        while (heap.size > 1) {
            val stone1 = heap.poll()!!
            val stone2 = heap.poll()!!
            if (stone1 != stone2) heap.add(stone1 - stone2)
        }

        return heap.peek() ?: 0
    }
}