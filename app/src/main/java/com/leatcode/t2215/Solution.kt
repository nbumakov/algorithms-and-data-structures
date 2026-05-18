package com.leatcode.t2215

class Solution {
    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        val nums1Set = nums1.toSet()
        val nums2Set = nums2.toSet()
        return listOf(
            nums1Set.filter { !nums2Set.contains(it) },
            nums2Set.filter { !nums1Set.contains(it) }
        )
    }
}