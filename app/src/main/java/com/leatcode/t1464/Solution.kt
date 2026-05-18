package com.leatcode.t1464

import java.util.PriorityQueue

class Solution {

    fun maxProduct2(nums: IntArray): Int = with(nums.indices.asSequence()) {
        val i = maxBy { nums[it] }
        val j = filter { it != i }.maxBy { nums[it] }
        (nums[i] - 1) * (nums[j] - 1)
    }

    fun maxProduct(nums: IntArray): Int = with(PriorityQueue<Int>()) {
        for (n in nums) {
            add(n)
            if (size > 2) remove()
        }
        fold(1) { acc, n -> acc * (n - 1) }
    }
}