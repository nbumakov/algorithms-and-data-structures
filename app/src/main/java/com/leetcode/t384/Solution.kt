package com.leetcode.t384

import kotlin.random.Random

class Solution(val nums: IntArray) {

    fun reset(): IntArray = nums

    fun shuffle(): IntArray {
        val curr = nums.toMutableList()
        val result = IntArray(nums.size)
        for (i in result.indices) {
            val next = Random.nextInt(curr.size)
            result[i] = curr.removeAt(next)
        }
        return result
    }

}