package com.leatcode.t707

import com.leatcode.util.print

fun main() {
    with(MyLinkedList()) {
        addAtHead(2)
        addAtIndex(0, 1)
        get(0).print()
        get(1).print()
    }
}

//TODO make it double linked
class MyLinkedList() {

    private var root: ListNode? = null

    fun get(index: Int): Int =
        getNode(index)?.`val` ?: -1

    fun addAtHead(`val`: Int) {
        root = ListNode(`val`).apply {
            next = root
        }
    }

    fun addAtTail(`val`: Int) {
        if (root == null) {
            addAtHead(`val`)
            return
        }

        var node = root
        while (node?.next != null) node = node.next
        node?.next = ListNode(`val`)
    }

    fun addAtIndex(index: Int, `val`: Int) {
        if (index == 0) {
            addAtHead(`val`)
            return
        }
        val node = getNode(index - 1)
        node?.next = ListNode(`val`).apply { next = node?.next }
    }

    fun deleteAtIndex(index: Int) {
        if (index == 0) {
            root = root?.next
            return
        }
        val node = getNode(index - 1)
        node?.next = node?.next?.next
    }

    private fun getNode(index: Int): ListNode? {
        var node = root
        repeat(index) {
            node = node?.next
        }
        return node
    }

    private class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}
