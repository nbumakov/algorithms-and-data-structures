package com.leatcode.t145

import com.leatcode.util.TreeNode
import java.util.LinkedList

// Approach 1: Recursive Postorder Traversal
class Solution {
    fun postorderTraversal(root: TreeNode?): List<Int> = mutableListOf<Int>().apply {
        fun dfs(node: TreeNode?) {
            if (node == null) return
            dfs(node.left)
            dfs(node.right)
            add(node.`val`)
        }
        dfs(root)
    }
}

// Approach 4: Single Stack Postorder Traversal (Iterative)
class Solution4 {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()

        val stack = ArrayDeque<TreeNode>().apply { addFirst(root) }
        val result = LinkedList<Int>()

        while (stack.isNotEmpty()) {
            val node = stack.removeFirst()
            result.add(0, node.`val`)
            node.left?.let { stack.addFirst(it) }
            node.right?.let { stack.addFirst(it) }
        }
        return result
    }
}