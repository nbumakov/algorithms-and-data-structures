package com.leetcode.t1290

import com.leetcode.util.ListNode

class Solution {

    // String
    fun getDecimalValue(head: ListNode?): Int {
        var node = head
        return buildString {
            while (node != null) append(node?.`val`)
            node = node?.next
        }.toInt(2)
    }

    fun getDecimalValue2(head: ListNode?): Int {
        var result = 0
        var node = head
        while (node != null) {
            result = (result shl 1) or node.`val`
            node = node.next
        }
        return result
    }
}