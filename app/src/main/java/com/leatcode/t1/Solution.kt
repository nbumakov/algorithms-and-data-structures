package com.leatcode.t1

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray = with(hashMapOf<Int, Int>()){
        nums.forEachIndexed { i, n ->
            val j = this[target - n]
            if (j != null && i != j) {
                return@with intArrayOf(i, j)
            }
            this[n] = i
        }
        return@with intArrayOf()
    }
}