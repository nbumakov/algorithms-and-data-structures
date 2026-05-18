package com.leatcode.t111

import com.leatcode.util.TreeNode
import com.leatcode.util.print
import java.util.LinkedList

fun main() {
    Solution()
        .minDepth(
            TreeNode(1).apply {
                left = TreeNode(2).apply {
                    left = TreeNode(4)
                    right = TreeNode(5)
                }
                right = TreeNode(3)
            }
        ).print()
}

class Solution {

    fun minDepthDfs(root: TreeNode?): Int = dfs(root)

    private fun dfs(root: TreeNode?): Int {
        if (root == null) return 0

        if (root.left == null) {
            return dfs(root.right) + 1
        } else if (root.right == null) {
            return dfs(root.left) + 1
        }

        return minOf(dfs(root.left), dfs(root.right)) + 1
    }

    fun minDepth(root: TreeNode?): Int {

        val queue = LinkedList<TreeNode>()
        root?.let(queue::add)
        var depth = 1

        while (queue.isNotEmpty()) {

            for (i in 0 until queue.size) {
                val node = queue.poll()!!
                val left = node.left
                val right = node.right

                if (left == null && right == null) return depth
                if (left != null) queue.add(left)
                if (right != null) queue.add(right)
            }
            depth++
        }

        return 0
    }

    fun breadthFirstTraversal(root: TreeNode): MutableList<TreeNode> {
        val queue = LinkedList<TreeNode>()
        val traversalList = mutableListOf<TreeNode>()

        // Add first node.
        queue.add(root)

        // Use queue to create breadth first traversal.
        while (queue.isNotEmpty()) {
            val node = queue.poll()!!

            // Add left node first.
            if (node.left != null)
                queue.add(node.left!!)

            // Add right node next.
            if (node.right != null)
                queue.add(node.right!!)

            // Add the node to the traversal list.
            traversalList.add(node)
        }

        return traversalList
    }
}