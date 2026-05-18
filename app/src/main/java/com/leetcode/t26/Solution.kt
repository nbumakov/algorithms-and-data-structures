package com.leetcode.t26

class Solution {
   fun removeDuplicates(nums: IntArray): Int {
        var p1 = 0
        for (p2 in 1 until nums.size) {
            if (nums[p2] != nums[p1]) {
                nums[++p1] = nums[p2]
            }
        }
        return p1 + 1
    }
}