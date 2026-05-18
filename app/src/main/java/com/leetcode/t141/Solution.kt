package com.leetcode.t141

import com.leetcode.util.ListNode

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        var pointer1: ListNode? = head ?: return false
        var pointer2: ListNode? = head.next ?: return false

        while (pointer1 != null && pointer2 != null && pointer1 !== pointer2) {
            pointer1 = pointer1.next
            pointer2 = pointer2.next?.next
        }

        return pointer1 === pointer2
    }
}