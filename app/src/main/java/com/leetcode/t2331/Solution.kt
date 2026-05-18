package com.leetcode.t2331

import com.leetcode.util.TreeNode

class Solution {

    private val Int.bool
        get() = this == 1

    private val Int.func
        get() = when (this) {
            2 -> { a: Boolean, b: Boolean -> a || b }
            3 -> { a: Boolean, b: Boolean -> a && b }
            else -> throw Exception()
        }

    fun evaluateTree(root: TreeNode?): Boolean = root?.run {
        if (`val` <= 1) {
            `val`.bool
        } else {
            `val`.func(evaluateTree(left), evaluateTree(right))
        }
    } ?: false

}