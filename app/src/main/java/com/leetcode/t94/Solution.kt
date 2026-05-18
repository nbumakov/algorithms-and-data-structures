package com.leetcode.t94

import com.leetcode.util.TreeNode

fun main() {
    val res = Solution().inorderTraversal2(
        TreeNode(1).apply {
            right = TreeNode(2).apply {
                left = TreeNode(3)
            }
        }
    )
    println(res.joinToString(","))
}

class Solution {

    // rec
    fun inorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()

        return inorderTraversal(root.left) + listOf(root.`val`) + inorderTraversal(root.right)
    }

    // rec2
    fun inorderTraversal3(root: TreeNode?): List<Int> = root?.run {
        inorderTraversal(left) + `val` + inorderTraversal(right)
    } ?: emptyList()

    // iterative
    fun inorderTraversal2(root: TreeNode?): List<Int> = mutableListOf<Int>().apply {
        val stack = ArrayDeque<TreeNode>()
        var current = root

        while (current != null || stack.isNotEmpty()) {
            while (current != null) {
                stack.addLast(current)
                current = current.left
            }
            current = stack.removeLast()
            add(current.`val`)
            current = current.right
        }
    }
}