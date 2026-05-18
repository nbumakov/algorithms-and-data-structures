package com.leatcode.t2196

import com.leatcode.util.TreeNode

class Solution {
    fun createBinaryTree(descriptions: Array<IntArray>): TreeNode? {
        val map = mutableMapOf<Int, TreeNode>()
        val root = (descriptions.map { it[0] }.toSet() - descriptions.map { it[1] }.toSet()).first()
        descriptions.forEach { (parent, child, isLeft) ->
            val parentNode = map.getOrPut(parent) { TreeNode(parent) }
            val childNode = map.getOrPut(child) { TreeNode(child) }
            if (isLeft == 1) parentNode.left = childNode else parentNode.right = childNode
        }
        return map[root]
    }
}