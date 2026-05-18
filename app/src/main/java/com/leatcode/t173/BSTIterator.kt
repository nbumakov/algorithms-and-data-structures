package com.leatcode.t173

import com.leatcode.util.TreeNode
import com.leatcode.util.print

fun main() {
    val it = BSTIterator2(TreeNode(2).apply {
        left = TreeNode(1)
        right = TreeNode(3)
    })
    while (it.hasNext()) {
        it.next().print()
    }
}

class BSTIterator(root: TreeNode?) : Iterator<Int> by iterator({
    root?.left?.let { node -> BSTIterator(node).iterator().forEach { yield(it) } }
    root?.`val`?.let { yield(it) }
    root?.right?.let { node -> BSTIterator(node).iterator().forEach { yield(it) } }
})

class BSTIterator2(root: TreeNode?) {

    private val stack = ArrayDeque<TreeNode>()

    init {
        root.addLeftmost()
    }

    fun next(): Int = stack.removeLast().run {
        right.addLeftmost()
        `val`
    }

    fun hasNext(): Boolean = stack.isNotEmpty()

    private fun TreeNode?.addLeftmost() {
        var node = this
        while (node != null) {
            stack.addLast(node)
            node = node.left
        }
    }

}