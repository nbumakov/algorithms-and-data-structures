package com.leetcode.t2540

fun main() {
    val solution = Solution()
    println(solution.getCommon(intArrayOf(2,3,3), intArrayOf(2,4)))
}

class Solution {
    fun getCommon(nums1: IntArray, nums2: IntArray): Int {
        var i = 0
        var j = 0
        while (i < nums1.size && j < nums2.size) {
            when {
                nums1[i] == nums2[j] -> return nums1[i]
                nums1[i] < nums2[j] -> i++
                else -> j++
            }
        }
        return -1
    }
}
