package com.leetcode.t1480

class Solution {

    fun runningSum3(nums: IntArray): IntArray = nums.apply {
        for (i in 1..nums.lastIndex) this[i] += this[i - 1]
    }

    fun runningSum2(nums: IntArray): IntArray = IntArray(nums.size).apply {
        this[0] = nums[0]
        for (i in 1..nums.lastIndex) {
            this[i] = this[i - 1] + nums[i]
        }
    }

    fun runningSum(nums: IntArray): IntArray {
        var sum = 0
        return IntArray(nums.size) {
            sum += nums[it]
            sum
        }
    }
}