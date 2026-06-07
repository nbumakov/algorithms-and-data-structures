package com.leetcode.t760

import java.util.LinkedList

class Solution {
    fun anagramMappings(nums1: IntArray, nums2: IntArray): IntArray {
        val indicesByValue = mutableMapOf<Int, LinkedList<Int>>()
        nums2.forEachIndexed { index, value ->
            indicesByValue.getOrPut(value, ::LinkedList).addLast(index)
        }

        return IntArray(nums1.size) { i ->
            indicesByValue.getValue(nums1[i]).pop()
        }
    }
}
