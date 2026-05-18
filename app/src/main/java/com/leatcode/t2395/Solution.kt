package com.leatcode.t2395

class Solution {
    fun findSubarrays(nums: IntArray): Boolean {
        val set = hashSetOf<Int>()
        for (i in 0 until nums.lastIndex) {
            val sum = nums[i] + nums[i + 1]
            if (set.contains(sum)) {
                return true
            }
            set.add(sum)
        }
        return false
    }
}