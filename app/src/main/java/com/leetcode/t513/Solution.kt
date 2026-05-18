package com.leetcode.t513

import com.leetcode.util.TreeNode
import java.util.LinkedList

class Solution {
    fun findBottomLeftValue(root: TreeNode): Int {
        val queue = LinkedList<TreeNode>().apply { add(root) }
        var leftmost = root.`val`
        while(queue.isNotEmpty()) {
            leftmost = queue.element().`val`
            repeat(queue.size) {
                val node = queue.remove()
                node.left?.let(queue::add)
                node.right?.let(queue::add)
            }
        }
        return leftmost
    }
}