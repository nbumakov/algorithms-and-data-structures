package com.leetcode.t572

import com.leetcode.util.TreeNode

class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null) return false
        if (equal(root, subRoot)) return true

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
    }

    private fun equal(a: TreeNode?, b: TreeNode?): Boolean {
        if (a == null && b == null) return true
        if (a?.`val` != b?.`val`) return false

        return equal(a?.left, b?.left) && equal(a?.right, b?.right)
    }
}