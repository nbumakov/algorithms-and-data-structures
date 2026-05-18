package com.leetcode.t1161

import com.leetcode.util.TreeNode
import com.leetcode.util.print
import java.util.LinkedList

fun main() {
    Solution()
        .maxLevelSum(TreeNode(1))
        .print()
}

class Solution {
    fun maxLevelSum(root: TreeNode?): Int {
        val queue = LinkedList<TreeNode>()
        root?.let(queue::add)

        return generateSequence {
            if (queue.isEmpty()) {
                null
            } else {
                (1..queue.size)
                    .map { queue.poll()!! }
                    .onEach { node ->
                        node.left?.let(queue::add)
                        node.right?.let(queue::add)
                    }
                    .map(TreeNode::`val`)
                    .sum()
            }
        }.withIndex().maxBy { it.value }?.index?.inc() ?: 0
    }

    fun maxLevelSum2(root: TreeNode?) = with(LinkedList<TreeNode>()) {
        root?.let { add(it) }
        generateSequence {
            if (isEmpty()) null else (1..size).map {
                with(poll()) {
                    `val`.also {
                        left?.let { add(it) }
                        right?.let { add(it) }
                    }
                }
            }.sum()
        }.withIndex().maxBy { it.value }?.index?.inc() ?: 0
    }
}