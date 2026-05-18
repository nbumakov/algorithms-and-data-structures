package com.leatcode.t414

class Solution {
    fun thirdMax(nums: IntArray): Int {
        val numsSet = nums.toMutableSet()
        if (numsSet.size < 3) {
            return nums.max()!!
        }

        repeat(2) {
            numsSet.remove(numsSet.max()!!)
        }

        return numsSet.max()!!
    }
}