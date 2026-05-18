package com.leetcode.t501

import com.leetcode.util.TreeNode
import com.leetcode.util.print

fun main() {
    Solution().findMode(TreeNode(1).apply {
        right = TreeNode(2)
    }).print()
}

class Solution {
    fun findMode(root: TreeNode?): IntArray {
        val result = mutableSetOf<Int>()

        var count = 0
        var curr: Int? = null
        var max = Int.MIN_VALUE

        fun dfs(node: TreeNode?) {
            if (node == null) return

            dfs(node.left)
            if (curr == node.`val`) count++ else count = 1
            when {
                max == count -> result += node.`val`
                max < count -> {
                    result.clear()
                    max = count
                    result += node.`val`
                }
            }
            curr = node.`val`
            dfs(node.right)
        }

        dfs(root)
        return result.toIntArray()
    }
}