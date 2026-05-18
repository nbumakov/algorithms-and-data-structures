package com.leetcode.t217

class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val numsSet = HashSet<Int>()
        for (n in nums) {
            if (numsSet.contains(n)) {
                return true
            } else {
                numsSet.add(n)
            }
        }
        return false
    }

}