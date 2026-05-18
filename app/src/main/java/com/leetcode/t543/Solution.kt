package com.leetcode.t543

import com.leetcode.util.TreeNode
import kotlin.math.max

class Solution {
    fun diameterOfBinaryTree(root: TreeNode?): Int {

        fun dfs(root: TreeNode?): Int =
            root?.run { maxOf(left.height + right.height, dfs(left), dfs(right)) } ?: 0

        return dfs(root)
    }

    private val TreeNode?.height: Int
        get() = this?.run { max(left.height, right.height) + 1 } ?: 0
}

class Solution2 {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        var diameter = 0

        fun dfs(node: TreeNode?): Int = node?.run {
            val leftHeight = dfs(left)
            val rightHeight = dfs(right)
            diameter = max(diameter, leftHeight + rightHeight)
            return max(leftHeight, rightHeight) + 1
        } ?: 0

        dfs(root)

        return diameter
    }

}

class Solution3 {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        var diameter = 0

        fun dfs(node: TreeNode?): Int {
            if (node == null) return 0

            val leftHeight = dfs(node.left)
            val rightHeight = dfs(node.right)
            diameter = max(diameter, leftHeight + rightHeight)

            return max(leftHeight, rightHeight) + 1
        }

        dfs(root)

        return diameter
    }
}