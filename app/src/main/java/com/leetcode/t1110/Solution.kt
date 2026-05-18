package com.leetcode.t1110

import com.leetcode.util.TreeNode

class Solution {
    fun delNodes(root: TreeNode?, to_delete: IntArray): List<TreeNode?> {
        val set = to_delete.toSet()
        val result = mutableListOf<TreeNode?>()
        fun TreeNode.dfs():TreeNode? {
            left = left?.dfs()
            right = right?.dfs()
            val remove = `val` in set
            if (remove) {
                left?.let(result::add)
                right?.let(result::add)
            }
            return takeIf { !remove }
        }
        root?.dfs()?.let(result::add)
        return result
    }
}