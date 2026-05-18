package com.leatcode.t82

import com.leatcode.util.ListNode
import com.leatcode.util.print

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
fun main() {
    Solution().deleteDuplicates(
        ListNode(1).apply {
            next = ListNode(2).apply {
                next = ListNode(2)
            }
        }
    ).print()
}

class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        val dummyHead = ListNode(-1).apply { next = head }
        var lastNode: ListNode? = dummyHead
        var curr = head

        while (curr != null) {
            if (curr.`val` == curr.next?.`val`) {
                while (curr?.`val` == curr?.next?.`val`) curr = curr?.next
                lastNode?.next = curr?.next
            } else {
                lastNode = lastNode?.next
            }

            curr = curr?.next
        }

        return dummyHead.next
    }
}