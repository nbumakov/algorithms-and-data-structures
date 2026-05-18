package com.leatcode.t872

import com.leatcode.util.ListNode
import com.leatcode.util.TreeNode

class Solution {

    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean =
        root1.leaves() == root2.leaves()

    private fun TreeNode?.leaves(): List<Int> = mutableListOf<Int>().apply {
        fun TreeNode?.dfs() {
            if (this == null) return

            if (left == null && right == null) {
                add(`val`)
            }
            left?.dfs()
            right.dfs()
        }
        dfs()
    }
}