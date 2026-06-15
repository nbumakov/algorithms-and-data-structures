package com.leetcode.t2095

import com.leetcode.util.ListNode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun deleteMiddle(head: ListNode?): ListNode? {
        if (head?.next == null) return null

        var fast = head
        var slow = head
        var prev:ListNode? = null
        while (fast != null && fast.next != null) {
            fast = fast.next?.next
            prev = slow
            slow = slow?.next
        }
        prev?.next = slow?.next

        return head
    }
}