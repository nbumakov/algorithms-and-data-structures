package com.leatcode.t100

import com.leatcode.util.TreeNode

fun main() {
    println(Solution().isSameTree_2(
        TreeNode(1).apply {
            left = TreeNode(2)
            right = TreeNode(3)
        },
        TreeNode(1).apply {
            left = TreeNode(2)
            right = TreeNode(3)
        }
    ))
}

class Solution {

    // iterative 2
    fun isSameTree_3(p: TreeNode?, q: TreeNode?): Boolean {
        val pDeque = ArrayDeque<TreeNode?>()
        val qDeque = ArrayDeque<TreeNode?>()

        pDeque.addLast(p)
        qDeque.addLast(q)

        while (pDeque.isNotEmpty()) {
            val a = pDeque.removeLast()
            val b = qDeque.removeLast()
            if (a == null && b == null) continue
            if (a?.`val` != b?.`val`) return false
            pDeque.addLast(a?.left)
            pDeque.addLast(a?.right)
            qDeque.addLast(b?.left)
            qDeque.addLast(b?.right)
        }

        return true
    }

    // iterative
    fun isSameTree_2(p: TreeNode?, q: TreeNode?): Boolean = with(ArrayDeque<Pair<TreeNode?, TreeNode?>>()) {
        addLast(p to q)
        while (isNotEmpty()) {
            val (a, b) = removeLast()
            if (a == null && b == null) continue
            if (a?.`val` != b?.`val`) return false
            addLast(a?.left to b?.left)
            addLast(a?.right to b?.right)
        }
        return true
    }

    // rec
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean =
        (p == null && q == null)
                || (p?.`val` == q?.`val`) && isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
}