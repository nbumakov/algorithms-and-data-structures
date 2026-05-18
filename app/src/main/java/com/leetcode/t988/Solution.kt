package com.leetcode.t988

import com.leetcode.util.TreeNode

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun smallestFromLeaf(root: TreeNode?): String {
        var result: String? = null
        val curr = StringBuilder()

        fun backtrack(node: TreeNode) {
            if (node.left == null && node.right == null) {
                val value = node.charValue + curr.reversed().toString()
                if (result == null || value < result.orEmpty()) {
                    result = value
                }
                return
            }

            curr.append(node.charValue)
            node.left?.let(::backtrack)
            node.right?.let(::backtrack)
            curr.deleteAt(curr.lastIndex)
        }

        root?.let(::backtrack)
        return result.orEmpty()
    }

    private val TreeNode.charValue get() = 'a' + `val`
}

class SolutionSD {
    fun smallestFromLeaf(root: TreeNode?, s: String = ""): String = root?.run {
        val s = "${'a' + `val`}" + s
        if (left == null && right == null) s
        else minOf(smallestFromLeaf(left, s), smallestFromLeaf(right, s))
    } ?: "${ 'z' + 1 }"
}