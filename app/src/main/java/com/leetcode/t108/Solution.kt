package com.leetcode.t108

import com.leetcode.util.TreeNode
import com.leetcode.util.printDfs

/**
 * Given an integer array nums where the elements are sorted in ascending order,
 * convert it to a height-balanced binary search tree.
 */
class Solution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? = constructBst(nums, nums.indices)

    private fun constructBst(nums: IntArray, range: IntRange): TreeNode? {
        if (range.first > range.last) {
            return null
        }
        val mid = (range.first + range.last) / 2
        val root = TreeNode(nums[mid])
        root.left = constructBst(nums, range.first until mid)
        root.right = constructBst(nums, mid + 1..range.last)
        return root
    }
}

fun main() {
    Solution()
        .sortedArrayToBST(intArrayOf(-10, -3, 0, 5, 9))
        .printDfs()
}
