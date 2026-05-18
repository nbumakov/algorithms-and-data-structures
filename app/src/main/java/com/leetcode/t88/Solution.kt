package com.leetcode.t88

fun main() {
    val a1 = intArrayOf(4, 5, 6, 0, 0, 0)
    val a2 = intArrayOf(1, 2, 3)
    Solution().merge(a1, a1.size - a2.size, a2, a2.size)
    println(a1.joinToString())
}

/**
 * You are given two integer arrays nums1 and nums2,
 * sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function,
 * but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n,
 * where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored.
 * nums2 has a length of n.
 */
class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var p1 = m - 1
        var p2 = nums2.lastIndex
        var i = nums1.lastIndex

        while (p2 >= 0) {
            nums1[i--] = if (p1 >= 0 && nums1[p1] > nums2[p2]) nums1[p1--] else nums2[p2--]
        }
    }

    fun mergeWithInsert(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var p1 = 0
        var p2 = 0

        while (p2 < n) {
            if (p1 < m && nums1[p1 + p2] <= nums2[p2]) {
                p1++
            } else {
                nums1.insert(p1 + p2, nums2[p2])
                p2++
            }
        }
    }

    private fun IntArray.insert(i: Int, n: Int) {
        for (j in lastIndex downTo i + 1) {
            this[j] = this[j - 1]
        }
        this[i] = n
    }
}
