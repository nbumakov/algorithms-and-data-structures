package com.leetcode.t2540

fun main() {
    val solution = Solution()
    println(solution.getCommon(intArrayOf(2,3,3), intArrayOf(2,4)))
}

class Solution {
    fun getCommon(nums1: IntArray, nums2: IntArray): Int {
        var j = 0
        for (i in nums1.indices) {
            while (j < nums2.size && nums1[i] > nums2[j]) j++
            if (j < nums2.size && nums1[i] == nums2[j]) return nums1[i]
        }
        return -1
    }
}
