package com.leatcode.t1863

class Solution {
    fun subsetXORSum(nums: IntArray): Int {
        var sum = 0
        fun backtrack(i: Int, currentXor: Int) {
            if (i >= nums.size) {
                sum += currentXor
                return
            }
            backtrack(i + 1, currentXor)
            backtrack(i + 1, nums[i] xor currentXor)
        }
        backtrack(0, 0)
        return sum
    }
}