package com.leetcode.t606

import com.leetcode.util.TreeNode

class Solution {
    fun tree2str(root: TreeNode?): String {
        if (root == null) return ""
        return buildString {
            append(root.`val`)
            if (root.left != null || root.right != null) {
                append("(${tree2str(root.left)})")
            }
            if (root.right != null) {
                append("(${tree2str(root.right)})")
            }
        }
    }
}