package com.leetcode.q.a2.q2

class Solution {
    fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
        val count = IntArray(101) { 0 }
        nums.forEach { count[it]++ }
        for(i in 1..100) count[i] += count[i - 1]
        return IntArray(nums.size) { count[nums[it] - 1] }
    }
}