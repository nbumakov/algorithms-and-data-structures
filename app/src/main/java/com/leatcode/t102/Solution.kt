package com.leatcode.t102

import com.leatcode.util.TreeNode
import java.util.LinkedList

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()
        val result = mutableListOf<List<Int>>()
        val queue = LinkedList<TreeNode>().apply { add(root) }
        while (queue.isNotEmpty()) {
            result += queue.map { it.`val` }
            repeat(queue.size) {
                queue.pop().run {
                    left?.let(queue::add)
                    right?.let(queue::add)
                }
            }
        }
        return result
    }
}