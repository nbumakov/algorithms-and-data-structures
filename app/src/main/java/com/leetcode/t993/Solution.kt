package com.leetcode.t993

import com.leetcode.util.TreeNode
import java.util.LinkedList

class Solution {
    fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
        val queue = LinkedList<TreeNode>().apply { add(root!!) }
        while (queue.isNotEmpty()) {
            var xParent: TreeNode? = null
            var yParent: TreeNode? = null

            fun addNode(node: TreeNode?, parent: TreeNode) {
                node ?: return
                queue.add(node)
                if (node.`val` == x) xParent = parent
                if (node.`val` == y) yParent = parent
            }

            repeat(queue.size) {
                val node = queue.pop()
                addNode(node.left, node)
                addNode(node.right, node)
            }

            if (xParent != null && yParent != null && xParent != yParent) return true
            if (xParent != null || yParent != null) return false
        }
        return false
    }
}