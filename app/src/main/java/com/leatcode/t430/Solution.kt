package com.leatcode.t430

import com.leatcode.util.print
import java.util.Deque
import java.util.Stack

/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var prev: Node? = null
 *     var next: Node? = null
 *     var child: Node? = null
 * }
 */

fun main() {
    Solution().flatten2(
        Solution.Node(1).apply {
            next = Solution.Node(2).apply {
                next = Solution.Node(5)
                child = Solution.Node(3).apply {
                    next = Solution.Node(4)
                }
            }
        }
    ).apply {
        var node = this
        while (node != null) {
            print("${node.`val`} ")
            node = node.next
        }
    }
}

class Solution {

    // DFS
    fun flatten(root: Node?): Node? {
        val dummyHead = Node(0).apply { next = root }
        var curr = dummyHead

        fun dfs(node: Node?) {
            if (node == null) return

            curr.next = node.apply { this.prev = curr }
            curr = node
            val next = node.next
            if (node.child != null) {
                dfs(node.child)
                node.child = null
            }
            dfs(next)
        }

        dfs(root)

        dummyHead.next?.prev = null

        return dummyHead.next
    }


    // iterative
    fun flatten2(root: Node?): Node? {
        val stack = ArrayDeque<Node>()
        var node = root
        while (node != null) {
            if (node.child == null) {
                node = node.next
            } else {
                node.next?.let(stack::addLast)
                node.next = node.child
                node.child?.prev = node
                node.child = null
            }

            if (node?.next == null && stack.isNotEmpty()) {
                val next = stack.removeLast()
                next.prev = node
                node?.next = next
            }
        }

        return root
    }

    class Node(var `val`: Int) {
        var prev: Node? = null
        var next: Node? = null
        var child: Node? = null
    }
}
