package com.leetcode.t113

import com.leetcode.util.TreeNode

class Solution {

    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        fun dfs(node: TreeNode, sum: Int, path: MutableList<Int>) {
            if (node.isLeaf() && sum + node.`val` == targetSum) {
                result.add(path + node.`val`)
                return
            }

            val newSum = sum + node.`val`
            path.add(node.`val`)
            node.left?.let { dfs(it, newSum, path) }
            node.right?.let { dfs(it, newSum, path) }
            path.removeLast()
        }
        root?.let { dfs(it, 0, mutableListOf()) }
        return result
    }

    private fun TreeNode.isLeaf() = left == null && right == null
}