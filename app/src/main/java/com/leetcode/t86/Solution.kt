package com.leetcode.t86

import com.leetcode.util.ListNode

class Solution {
    fun partition(head: ListNode?, x: Int): ListNode? {
        val leftHead = ListNode(-1)
        val rightHead = ListNode(-1)

        var p1 = leftHead
        var p2 = rightHead

        var curr = head
        while (curr != null) {
            if (curr.`val` < x) {
                p1.next = curr
                p1 = curr
            } else {
                p2.next = curr
                p2 = curr
            }
            curr = curr.next
        }
        p1.next = rightHead.next
        p2.next = null

        return leftHead.next
    }
}