package com.leatcode.t700

import com.leatcode.util.TreeNode
import java.util.Stack

class Solution {
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) return null

        return when {
            `val` > root.`val` -> searchBST(root.right, `val`)
            `val` < root.`val` -> searchBST(root.left, `val`)
            else -> root
        }
    }

    fun searchBST_WithoutRec(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) return null

        val stack = Stack<TreeNode>().apply { add(root) }

        while (stack.isNotEmpty()) {
            val node = stack.pop()

            when {
                `val` > node.`val` -> node.right?.let(stack::push)
                `val` < node.`val` -> node.left?.let(stack::push)
                else -> return node
            }
        }

        return null
    }
}