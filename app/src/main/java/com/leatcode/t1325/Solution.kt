package com.leatcode.t1325

import com.leatcode.util.TreeNode

class Solution {
    fun removeLeafNodes(root: TreeNode?, target: Int): TreeNode? {
        fun dfs(node: TreeNode?): Boolean = node?.run {
            if (dfs(left)) left = null
            if (dfs(right)) right = null
            left == null && right == null && `val` == target
        } ?: false

        val dummy = TreeNode(-1).apply { left = root }
        dfs(dummy)
        return dummy.left
    }
}

class Solution2 {
    fun removeLeafNodes(root: TreeNode?, target: Int): TreeNode? = root?.run {
        left = removeLeafNodes(left, target)
        right = removeLeafNodes(right, target)
        if (left == null && right == null && `val` == target) null else root
    }
}