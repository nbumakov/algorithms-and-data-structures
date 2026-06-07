package com.leetcode.t2196

import com.leetcode.util.TreeNode

class Solution {
    fun createBinaryTree(descriptions: Array<IntArray>): TreeNode? {
        val map = mutableMapOf<Int, TreeNode>()
        val children = HashSet<Int>()
        descriptions.forEach { (parent, child, isLeft) ->
            children.add(child)
            val parentNode = map.getOrPut(parent) { TreeNode(parent) }
            val childNode = map.getOrPut(child) { TreeNode(child) }
            if (isLeft == 1) parentNode.left = childNode else parentNode.right = childNode
        }
        val root = map.keys.first { it !in children }
        return map[root]
    }
}