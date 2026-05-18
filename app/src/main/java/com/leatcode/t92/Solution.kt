package com.leatcode.t92

import com.leatcode.util.ListNode
import com.leatcode.util.print

fun main() {
    Solution().reverseBetween(
        ListNode(1).apply {
            next = ListNode(2).apply {
                next = ListNode(3).apply {
                    next = ListNode(4)
                }
            }
        },
        1, 2
    ).print()
}

class Solution {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        val dummyHead = ListNode(-1).apply {
            next = head
        }
        var curr = head
        var i = 1
        val reversedHead = ListNode(-1)
        var first: ListNode? = dummyHead
        var last: ListNode? = null

        // 1 -> 2 -> 3
        while (curr != null) {
            val next = curr.next
            if (i == left - 1) {
                first = curr
            }
            if (i == left) {
                last = curr
            }
            if (i in left..right) {
                val reversedNext = reversedHead.next
                reversedHead.next = curr
                curr.next = reversedNext
            }
            if (i == right) {
                first?.next = reversedHead.next
                last?.next = next
                break
            }
            i++
            curr = next
        }

        return dummyHead.next
    }
}