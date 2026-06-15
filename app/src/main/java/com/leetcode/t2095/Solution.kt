package com.leetcode.t2095

import com.leetcode.util.ListNode

/**
 * LeetCode 2095 — Delete the Middle Node of a Linked List.
 *
 * Fast/slow pointers from a sentinel: `slow` lands just before the ⌊n/2⌋-th node,
 * then unlinks it. The sentinel handles the empty/single-node cases for free.
 * Time: O(n), Space: O(1).
 */
class Solution {
    fun deleteMiddle(head: ListNode?): ListNode? {
        val dummy = ListNode(0).apply { next = head }
        var slow = dummy
        var fast = head
        while (fast?.next != null) {
            slow = slow.next!!
            fast = fast.next?.next
        }
        slow.next = slow.next?.next     // unlink the middle node
        return dummy.next
    }
}