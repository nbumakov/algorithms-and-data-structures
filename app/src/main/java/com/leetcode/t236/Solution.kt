package com.leetcode.t236

import com.leetcode.util.TreeNode


class Solution {

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode, q: TreeNode): TreeNode? {
        var lcaNode: TreeNode? = null
        fun dfs(node: TreeNode?): Boolean {
            if (node == null) return false

            val left = if (dfs(node.left)) 1 else 0
            val right = if (dfs(node.right)) 1 else 0
            val current = if (node == p || node == q) 1 else 0

            // If any two of the flags left, right or mid become True
            if (current + left + right >= 2) lcaNode = node

            // Return true if any one of the three bool values is True.
            return current + left + right > 0
        }

        dfs(root)
        return lcaNode
    }
}