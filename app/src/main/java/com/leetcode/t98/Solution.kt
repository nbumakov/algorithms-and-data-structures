package com.leetcode.t98

import com.leetcode.util.TreeNode
import com.leetcode.util.print

fun main() {
    Solution().isValidBST(
        TreeNode(5).apply {
            left = TreeNode(4)
            right = TreeNode(6).apply {
                left = TreeNode(3)
                right = TreeNode(7)
            }
        }
    ).print()
}

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        fun check(node: TreeNode?, min: Long, max: Long): Boolean {
            if (node == null) return true
            if (node.`val` !in min..max) return false

            return check(node.left, min, minOf(max, node.`val` - 1L))
                    && check(node.right, maxOf(min, node.`val` + 1L), max)
        }
        return check(root!!, Long.MIN_VALUE, Long.MAX_VALUE)
    }

    fun isValidBST_Traverse(root: TreeNode?): Boolean {

        val traverse = mutableListOf<Int>()
        fun dfs(node: TreeNode?) {
            if (node == null) return
            dfs(node.left)
            traverse.add(node.`val`)
            dfs(node.right)
        }
        dfs(root)
        for (i in 0 until traverse.lastIndex) {
            if (traverse[i] >= traverse[i + 1]) return false
        }
        return true
    }

}