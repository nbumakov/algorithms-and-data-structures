package com.leatcode.t747

import com.leatcode.util.print
import java.util.PriorityQueue

fun main() {
    Solution().dominantIndex(intArrayOf(3, 6, 1, 0)).print()
}

class Solution {
    fun dominantIndex(nums: IntArray): Int {
        val priorityQueue = PriorityQueue<IndexedValue<Int>>(3) { o1, o2 ->
            o1.value.compareTo(o2.value)
        }
        for (n in nums.withIndex()) {
            priorityQueue.add(n)
            if (priorityQueue.size > 2) {
                priorityQueue.poll()
            }
        }

        val max1 = priorityQueue.poll()!!
        val max2 = priorityQueue.poll()!!
        return if (max2.value >= 2 * max1.value) max2.index else -1
    }
}