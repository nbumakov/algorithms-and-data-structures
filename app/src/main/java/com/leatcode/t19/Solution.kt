package com.leatcode.t19

import com.leatcode.util.ListNode
import com.leatcode.util.asString
import com.leatcode.util.print

fun main() {
    Solution().removeNthFromEndTwoPointers(ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5)
                }
            }
        }
    }, 1).asString().print()
}

class Solution {

    // the fast pointer n+1 nodes ahead
    fun removeNthFromEndTwoPointers(head: ListNode?, n: Int): ListNode? {
        val start = ListNode(0).apply { next = head }
        var slow: ListNode? = start
        var fast: ListNode? = start

        repeat(n + 1) {
            fast = fast?.next
        }

        while (fast != null) {
            fast = fast?.next
            slow = slow?.next
        }

        slow?.next = slow?.next?.next

        return start.next
    }

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val length = head.getLength()
        val index = length - n
        if (index == 0) {
            return head?.next
        }
        var node = head
        repeat(index - 1) {
            node = node?.next
        }
        node?.next = node?.next?.next
        return head
    }

    private fun ListNode?.getLength(): Int {
        var length = 0
        var node = this
        while (node != null) {
            node = node.next
            length++
        }
        return length
    }
}