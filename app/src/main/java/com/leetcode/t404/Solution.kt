package com.leetcode.t404

import com.leetcode.util.TreeNode

class Solution {
    fun sumOfLeftLeaves(root: TreeNode?): Int {

        fun helper(node: TreeNode?, isLeft: Boolean): Int {
            if (node?.left == null && node?.right == null) {
                return if (isLeft) node?.`val` ?: 0 else 0
            }

            return helper(node.left, true) + helper(node.right, false)
        }

        return helper(root, false)
    }
}

class Solution2 {
    fun sumOfLeftLeaves(root: TreeNode?): Int = root?.run {
        (left?.takeIf { it.left == null && it.right == null }?.`val` ?: sumOfLeftLeaves(left)) + sumOfLeftLeaves(right)
    } ?: 0

}