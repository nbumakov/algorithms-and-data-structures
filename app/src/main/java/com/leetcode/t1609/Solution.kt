package com.leetcode.t1609

import com.leetcode.util.TreeNode
import java.util.LinkedList

class Solution {
    fun isEvenOddTree(root: TreeNode): Boolean {
        val queue = LinkedList<TreeNode>().apply { add(root) }
        var level = 0
        while (queue.isNotEmpty()) {
            if (!queue.validate(
                    parityCheckPredicate = { it == (level + 1) % 2 },
                    monotonousPredicate = { a, b -> if (level % 2 == 0) a < b else a > b })
            ) return false

            repeat(queue.size) {
                val node = queue.remove()
                node.left?.let(queue::add)
                node.right?.let(queue::add)
            }
            level++
        }

        return true
    }

    private inline fun List<TreeNode>.validate(
        parityCheckPredicate: (Int) -> Boolean,
        monotonousPredicate: (Int, Int) -> Boolean,
    ): Boolean = map { it.`val` }
        .run { all { parityCheckPredicate(it % 2) } && windowed(2).all { (a, b) -> monotonousPredicate(a, b) } }

}