package com.leatcode.t138

import com.leatcode.util.Node

fun main() {
    Solution().copyRandomList(
        Node(1).apply {
            next = Node(2).apply {
                next = Node(3)
            }
        }
    )
}

class Solution {
    fun copyRandomList(node: Node?): Node? {
        val cache = hashMapOf<Node, Node>()

        var curr = node
        while (curr != null) {
            val newNode = Node(curr.`val`).apply {
                random = curr?.random
                next = curr?.next
            }
            cache[curr] = newNode
            curr = curr.next
        }

        curr = node
        while (curr != null) {
            val newNode = cache[curr]
            newNode?.next = cache[curr.next]
            newNode?.random = cache[curr.random]
            curr = curr.next
        }

        return cache[node]
    }
}