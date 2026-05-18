package com.leetcode.t725

import com.leetcode.util.ListNode
import com.leetcode.util.print

fun main() {
    Solution().splitListToParts(
        ListNode(1).apply {
            next = ListNode(2).apply {
                next = ListNode(3)
            }
        },
        2
    ).forEach {
        it.print()
    }
}

class Solution {
    fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
        val length = head.getLength()
        val quotient = length / k
        var reminder = length % k

        var curr = head

        val result = Array<ListNode?>(k) { null }
        for (i in 0 until k) {
            result[i] = curr
            curr = curr.skip(quotient + if (reminder-- > 0) 1 else 0)
        }
        return result
    }

    private fun ListNode?.skip(n: Int): ListNode? {
        var curr = this
        repeat(n - 1) {
            curr = curr?.next
        }
        return curr?.next.also { curr?.next = null }
    }

    private fun ListNode?.getLength(): Int {
        var length = 0
        var curr = this
        while (curr != null) {
            length++
            curr = curr.next
        }
        return length
    }
}