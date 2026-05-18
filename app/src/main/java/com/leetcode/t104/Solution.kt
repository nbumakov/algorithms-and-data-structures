package com.leetcode.t104

import com.leetcode.util.TreeNode
import com.leetcode.util.print
import java.util.Stack
import kotlin.math.max


/**
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 */
fun main() {
    Solution().maxDepth(
        TreeNode(3).apply {
            left = TreeNode(9)
            right = TreeNode(20).apply {
                left = TreeNode(15)
                right = TreeNode(7)
            }
        }
    ).print()
}

class Solution {
    fun maxDepth(root: TreeNode?): Int =
        root?.run { max(maxDepth(left), maxDepth(right)) + 1 } ?: 0


    fun maxDepth2(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        val callStack = Stack<Pair<TreeNode, Int>>().apply { push(Pair(root, 1)) }
        var result = 0
        while (callStack.isNotEmpty()) {
            val (node, depth) = callStack.pop()

            result = maxOf(result, depth)
            node.left?.let { callStack.push(it to depth + 1) }
            node.right?.let { callStack.push(it to depth + 1) }
        }

        return result
    }
}