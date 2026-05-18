package com.leatcode.t110

import com.leatcode.util.TreeNode
import kotlin.math.abs

class Solution {
    fun isBalanced(root: TreeNode?): Boolean =
        root.isHeightBalanced()

    private fun TreeNode?.isHeightBalanced(): Boolean {
        if (this == null) {
            return true
        }
        val leftHeight = left.getHeight()
        val rightHeight = right.getHeight()
        val heightDiff = abs(leftHeight - rightHeight)
        return heightDiff <= 1 && left.isHeightBalanced() && right.isHeightBalanced()
    }

    private fun TreeNode?.getHeight(): Int {
        if (this == null) {
            return 0
        }
        val leftHeight = left.getHeight()
        val rightHeight = right.getHeight()
        return 1 + maxOf(leftHeight, rightHeight)
    }
}