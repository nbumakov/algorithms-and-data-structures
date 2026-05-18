package com.leetcode.t314

import com.leetcode.util.TreeNode

class Solution {
    fun verticalOrder(root: TreeNode?): List<List<Int>> {
        if(root == null) return emptyList()

        val map = mutableMapOf<Int, MutableList<Int>>()
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE

        val queue = ArrayDeque<Pair<TreeNode, Int>>()
        queue.add(root to 0)
        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val (node, column) = queue.removeFirst()
                map.getOrPut(column) { mutableListOf() }.add(node.`val`)
                node.left?.let { queue.add(it to column - 1) }
                node.right?.let { queue.add(it to column + 1) }
                min = minOf(min, column)
                max = maxOf(max, column)
            }
        }

        return buildList {
            for (i in min..max) {
                map[i]?.let(::add)
            }
        }
    }
}