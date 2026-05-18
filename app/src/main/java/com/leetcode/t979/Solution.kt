package com.leetcode.t979

import com.leetcode.util.TreeNode
import com.leetcode.util.print
import kotlin.math.abs

fun main() {
    Solution()
        .distributeCoins(
            TreeNode(0).apply {
                left = TreeNode(3)
                right = TreeNode(0)
            })
        .print()
}

class Solution {
    fun distributeCoins(root: TreeNode?): Int {
        var moves = 0

        fun dfs(node: TreeNode?): Int = node?.run {
            (dfs(node.left) + dfs(node.right) + node.`val` - 1)
                .also { moves += abs(it) }
        } ?: 0

        dfs(root)

        return moves
    }
}