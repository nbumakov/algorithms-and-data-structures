package com.leetcode.t2130

import com.leetcode.util.ListNode
import java.util.LinkedList
import kotlin.math.max

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
/**
 * Approach 1: Stack
 * - Push all values to stack while traversing
 * - Pop from both ends: first element pairs with last (twins in O(1))
 * - Track maximum sum across all pairs
 *
 * Time: O(n), Space: O(n)
 */
class Solution {
    fun pairSum(head: ListNode?): Int {
        val stack = LinkedList<Int>()

        var cur = head
        while (cur != null) {
            stack.addLast(cur.`val`)
            cur = cur.next
        }

        var max = 0
        while (stack.isNotEmpty()) {
            max = max(max, stack.pollFirst() + stack.pollLast())
        }

        return max
    }
}

/**
 * Approach 2: Reverse First Half + Two Pointers
 * - Find middle using slow/fast pointers
 * - Reverse the first half in-place
 * - Traverse from both ends simultaneously, summing twins
 * - Restore the list by reversing back (optional, not needed for result)
 *
 * Time: O(n), Space: O(1)
 */
class Solution2 {
    fun pairSum(head: ListNode?): Int {
        var prev: ListNode? = null
        var slow = head
        var fast = head

        while (fast != null && fast.next != null) {
            fast = fast.next?.next
            val next = slow?.next
            slow?.next = prev
            prev = slow
            slow = next
        }

        var max = 0
        while (slow != null && prev != null) {
            max = max(max, slow.`val` + prev.`val`)
            slow = slow.next
            prev = prev.next
        }

        return max
    }
}