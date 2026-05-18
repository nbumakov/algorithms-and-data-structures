package com.leatcode.t2206

class Solution {
    fun divideArray(nums: IntArray): Boolean =
        nums.groupBy { it }.all { it.value.size % 2 == 0 }
}