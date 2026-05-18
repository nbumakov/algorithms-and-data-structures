package com.leetcode.t350

import java.util.Arrays



class Solution {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val counts = nums1.asList().groupingBy { it }.eachCount().toMutableMap()

        var k = 0
        for (n in nums2) {
            val cnt = counts.getOrDefault(n, 0)
            if (cnt > 0) {
                nums1[k++] = n
                counts[n] = cnt - 1
            }
        }
        return Arrays.copyOfRange(nums1, 0, k)
    }
}

class Solution2 {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val map1 = nums1.toList().groupingBy { it }.eachCount()
        val map2 = nums2.toList().groupingBy { it }.eachCount()

        return map2.flatMap { (num, count) ->
            List(minOf(map1[num] ?: 0, count)) { num }
        }.toIntArray()
    }
}