package com.leatcode.t637

import com.leatcode.util.TreeNode
import java.util.LinkedList

class Solution {
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        val queue = LinkedList<TreeNode>().apply { add(root!!) }
        val levelSums = mutableListOf<Double>()

        while (queue.isNotEmpty()) {
            var sum = 0L
            val size = queue.size
            repeat(size) {
                val node = queue.pop()
                sum += node.`val`
                node.left?.let(queue::add)
                node.right?.let(queue::add)
            }
            levelSums.add(sum.toDouble() / size)
        }
        return levelSums.toDoubleArray()
    }
}