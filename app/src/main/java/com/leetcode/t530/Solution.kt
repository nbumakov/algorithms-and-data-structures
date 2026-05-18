package com.leetcode.t530

import com.leetcode.util.TreeNode
import com.leetcode.util.print
import kotlin.math.min

fun main() {
    Solution()
        .getMinimumDifference(
            TreeNode(236).apply {
                left = TreeNode(104).apply {
                    right = TreeNode(227)
                }
                right = TreeNode(701).apply {
                    right = TreeNode(911)
                }
            }
        )
        .print()
}

class Solution {

    fun getMinimumDifference(root: TreeNode?): Int {
        val list = mutableListOf<Int>()
        fillList(root, list)

        var minDiff = Int.MAX_VALUE
        for (i in 1 until list.size) {
            minDiff = min(minDiff, list[i] - list[i - 1])
        }
        return minDiff
    }

    private fun fillList(node: TreeNode?, list: MutableList<Int>) {
        if (node == null) return

        fillList(node.left, list)
        list.add(node.`val`)
        fillList(node.right, list)
    }

}