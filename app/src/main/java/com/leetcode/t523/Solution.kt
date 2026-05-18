package com.leetcode.t523

class Solution {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        var prefixMod = 0
        val modSeen = hashMapOf(0 to -1)
        for (i in nums.indices) {
            prefixMod = (prefixMod + nums[i]) % k
            if (modSeen.containsKey(prefixMod)) {
                if (i - modSeen[prefixMod]!! > 1) return true
                if (i - modSeen[prefixMod]!! > 1) return true
            } else {
                modSeen[prefixMod] = i
            }
        }
        return false
    }
}