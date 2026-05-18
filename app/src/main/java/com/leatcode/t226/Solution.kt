package com.leatcode.t226

import com.leatcode.util.TreeNode

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? = root?.apply {
        val temp = invertTree(left)
        left = invertTree(right)
        right = temp
    }
}