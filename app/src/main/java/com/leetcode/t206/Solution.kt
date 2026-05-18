package com.leetcode.t206

import com.leetcode.util.ListNode
import com.leetcode.util.asString
import com.leetcode.util.print

fun main() {
    Solution().reverseList3(
        ListNode(1).apply {
            next = ListNode(2).apply {
                next = ListNode(3)
            }
        }
    ).asString().print()
}

class Solution {

    // 1 -> 2 -> 3
    fun reverseListRec4(head: ListNode?): ListNode? {
        if (head?.next == null) return head

        val newHead = reverseListRec4(head.next)
        head.next?.next = head
        head.next = null

        return newHead
    }

    // 1 -> 2 -> 3
    fun reverseList4(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var curr = head
        while (curr != null) {
            val next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        }
        return prev
    }

    // 1 -> 2 -> 3
    fun reverseListRec3(head: ListNode?): ListNode? {
        if (head?.next == null) return head

        val newHead = reverseListRec3(head.next)
        head.next?.next = head
        head.next = null

        return newHead
    }

    fun reverseList2(head: ListNode?): ListNode? {
        var newHead: ListNode? = null
        var curr = head
        while (curr != null) {
            val next = curr.next
            newHead = curr.also { it.next = newHead }
            curr = next
        }
        return newHead
    }

    fun reverseListRec2(head: ListNode?): ListNode? {
        if (head?.next == null) return head

        val newHead = reverseListRec2(head.next)
        head.next?.next = head
        head.next = null

        return newHead
    }

    fun reverseList3(head: ListNode?): ListNode? {
        var newHead: ListNode? = head

        while (head?.next != null) {
            val temp = newHead
            newHead = head.next
            head.next = head.next?.next
            newHead?.next = temp
        }

        return newHead
    }

    fun reverseList(head: ListNode?): ListNode? {
        var previous: ListNode? = null
        var current: ListNode? = head

        while (current != null) {
            val next = current.next
            current.next = previous
            previous = current
            current = next
        }

        return previous
    }

    fun reverseListRecursive(head: ListNode?): ListNode? {
        if (head?.next == null) return head

        val newHead = reverseList(head.next)
        head.next!!.next = head
        head.next = null

        return newHead
    }
}