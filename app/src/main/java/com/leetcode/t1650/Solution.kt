package com.leetcode.t1650

import com.leetcode.util.TreeNode

class Solution {
    fun lowestCommonAncestor(p: Node?, q: Node?): Node? {
        fun Node.level(): Int {
            var level = 0
            var node: Node? = this
            while (node != null) {
                level++
                node = node.parent
            }
            return level
        }

        var pHeight = p?.level() ?: 0
        var qHeight = q?.level() ?: 0

        var currentP = p
        var currentQ = q

        while (pHeight > qHeight) {
            currentP = currentP?.parent
            pHeight--
        }
        while (qHeight > pHeight) {
            currentQ = currentQ?.parent
            qHeight--
        }
        while (currentP != currentQ) {
            currentP = currentP?.parent
            currentQ = currentQ?.parent
        }

        return currentP
    }
}

class Node(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    var parent: Node? = null
}