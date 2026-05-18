package com.leatcode.t1372

import com.leatcode.util.TreeNode

class Solution {
    fun longestZigZag(root: TreeNode?): Int {
        fun dfs(node: TreeNode?, fromLeft: Boolean): Int {
            if (node == null) return 0

            return maxOf(
                dfs(node.left, true) + if (fromLeft) 0 else 1,
                dfs(node.right, false) + if (fromLeft) 1 else 0
            )
        }

        return maxOf(
            dfs(root?.left, true),
            dfs(root?.right, false)
        )
    }
}