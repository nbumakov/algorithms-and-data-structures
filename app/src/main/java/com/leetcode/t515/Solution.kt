package com.leetcode.t515

import com.leetcode.util.TreeNode
import java.util.LinkedList
import java.util.Queue

class Solution {
    fun largestValues(root: TreeNode?): List<Int> {
        root ?: return emptyList()
        val queue: Queue<TreeNode> = LinkedList<TreeNode>().apply { add(root) }
        val result = mutableListOf<Int>()

        while (queue.isNotEmpty()) {
            result += queue.maxBy { it.`val` }.`val`
            repeat(queue.size) {
                val item = queue.poll()!!
                item.left?.let(queue::add)
                item.right?.let(queue::add)
            }
        }

        return result
    }
}