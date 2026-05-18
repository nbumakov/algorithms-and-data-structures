package com.leatcode.t203

import com.leatcode.util.ListNode

class Solution {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        val start = ListNode(-1).apply { next = head }
        var node: ListNode? = start
        while (node?.next != null) {
            if (node.next?.`val` == `val`) {
                node.next = node.next?.next
            } else {
                node = node.next
            }
        }
        return start.next
    }
}