package com.leatcode.t24

import com.leatcode.util.ListNode

class Solution {
    fun swapPairs(head: ListNode?): ListNode? {
        if (head?.next == null) return head

        return head.next?.apply {
            next = head.apply {
                next = swapPairs(head.next?.next)
            }
        }
    }
}