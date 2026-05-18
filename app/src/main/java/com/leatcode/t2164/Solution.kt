package com.leatcode.t2164

import com.leatcode.util.print
import java.util.PriorityQueue

fun main() {
    Solution().sortEvenOdd(intArrayOf(4,1,2,3)).print()
}

class Solution {
    fun sortEvenOdd(nums: IntArray): IntArray {
        val minHeap = PriorityQueue<Int>()
        for (i in nums.indices step 2) minHeap.add(nums[i])

        val maxHeap = PriorityQueue<Int>(reverseOrder())
        for (i in 1..nums.lastIndex step 2) maxHeap.add(nums[i])
        for (i in nums.indices) {
            nums[i] = if (i % 2 == 0) minHeap.remove()!! else maxHeap.remove()!!
        }
        return nums
    }
}