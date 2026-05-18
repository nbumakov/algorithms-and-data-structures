package com.leatcode.t1448

import com.leatcode.util.TreeNode
import java.util.LinkedList
import java.util.Queue

class Solution {
    fun goodNodes(root: TreeNode?): Int {
        var goodNodes = 0

        fun dfs(root: TreeNode?, max: Int) {
            if (root == null) return
            if (root.`val` >= max) {
                goodNodes++
            }

            val max = maxOf(root.`val`, max)
            dfs(root.left, max)
            dfs(root.right, max)
        }
        dfs(root, root!!.`val`)

        return goodNodes
    }
}