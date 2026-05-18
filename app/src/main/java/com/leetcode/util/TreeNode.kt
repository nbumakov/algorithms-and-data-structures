package com.leetcode.util

import kotlin.math.abs

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun TreeNode?.isHeightBalanced(): Boolean {
    if (this == null) {
        return true
    }
    val leftHeight = left.getHeight()
    val rightHeight = right.getHeight()
    val heightDiff = abs(leftHeight - rightHeight)
    return heightDiff <= 1 && left.isHeightBalanced() && right.isHeightBalanced()
}

fun TreeNode?.getHeight(): Int {
    if (this == null) {
        return 0
    }
    val leftHeight = left.getHeight()
    val rightHeight = right.getHeight()
    return 1 + maxOf(leftHeight, rightHeight)
}

fun TreeNode?.printDfs(){
    if(this == null) {
        print("null ")
        return
    }
    print("${this.`val`} ")
    left.printDfs()
    right.printDfs()
}