package com.leetcode.t112

import com.leetcode.util.TreeNode

class Solution {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) {
            return false
        }

        val newSum = targetSum - root.`val`
        return (root.isLeaf() && newSum == 0)
                || hasPathSum(root.left, newSum)
                || hasPathSum(root.right, newSum)
    }

    private fun TreeNode.isLeaf(): Boolean =
        left == null && right == null
}