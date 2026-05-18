package com.leatcode.t101

import com.leatcode.util.TreeNode
import com.leatcode.util.print

fun main() {
    Solution().isSymmetric(
        TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(3)
                right = TreeNode(4)
            }
            right = TreeNode(2).apply {
                left = TreeNode(4)
                right = TreeNode(3)
            }
        }
    ).print()
}

class Solution {
    fun isSymmetric(root: TreeNode?): Boolean =
        isMirror(root?.left, root?.right)

    private fun isMirror(a: TreeNode?, b: TreeNode?): Boolean {
        if (a == null && b == null) return true
        if (a?.`val` != b?.`val`) return false

        return isMirror(a?.left, b?.right) && isMirror(a?.right, b?.left)
    }
}