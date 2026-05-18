package com.leatcode.t129

import com.leatcode.util.TreeNode
import com.leatcode.util.print

fun main() {
    Solution().sumNumbers(
        TreeNode(1).apply {
            left = TreeNode(2)
            right = TreeNode(3)
        }
    ).print()
}

class Solution {
    fun sumNumbers(root: TreeNode?): Int {
        fun dfs(node: TreeNode?, value: Int): Int {
            if (node == null) return 0

            val newValue = value * 10 + node.`val`
            if (node.left == null && node.right == null) return newValue

            return dfs(node.left, newValue) + dfs(node.right, newValue)
        }
        return dfs(root, 0)
    }
}