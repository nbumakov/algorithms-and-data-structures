package com.leetcode.t3217

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
    fun modifiedList(nums: IntArray, head: ListNode?): ListNode? {
        val set = nums.toSet()
        val dummy = ListNode(0).apply {
            next = head
        }
        var prev =  dummy
        while (prev.next != null) {
            if (set.contains(prev.next!!.`val`)) {
                prev.next = prev.next!!.next
            } else {
                prev = prev.next!!
            }
        }
        return dummy.next
    }
}