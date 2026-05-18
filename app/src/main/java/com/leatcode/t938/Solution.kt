package com.leatcode.t938

import com.leatcode.util.TreeNode

class Solution {
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        fun dfs(node: TreeNode?): Int = node?.run {
            dfs(left) + (`val`?.takeIf { it in low..high } ?: 0) + dfs(right)
        } ?: 0

        return dfs(root)
    }
}