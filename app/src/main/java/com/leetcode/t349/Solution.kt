package com.leetcode.t349

class Solution {

    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val set1 = nums1.toHashSet()
        val intersection = hashSetOf<Int>()
        nums2.forEach {
            if (set1.contains(it)) intersection.add(it)
        }
        return intersection.toIntArray()
    }

    fun intersectionStupid(nums1: IntArray, nums2: IntArray): IntArray =
        (nums1.toSet() intersect nums2.toSet()).toIntArray()
}