package com.leetcode.t199

import com.leetcode.util.TreeNode
import java.util.LinkedList
import java.util.Queue

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        val result = mutableListOf<Int>()
        while (queue.isNotEmpty()) {
            val lastIndex = queue.size - 1
            for (i in 0..lastIndex) {
                val node = queue.poll()!!
                node.left?.let(queue::add)
                node.right?.let(queue::add)
                if (i == lastIndex) result.add(node.`val`)
            }
        }

        return result
    }
}