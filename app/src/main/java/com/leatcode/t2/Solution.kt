package com.leatcode.t2

import com.leatcode.util.ListNode

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var node1 = l1
        var node2 = l2
        val dummyHead = ListNode(0)
        var current: ListNode = dummyHead

        var accumulator = 0
        while (node1 != null || node2 != null || accumulator != 0) {
            val sum = node1.value + node2.value + accumulator
            val node = ListNode(sum % 10)
            accumulator = sum.div(10)
            current.next = node
            current = node
            node1 = node1?.next
            node2 = node2?.next
        }
        return dummyHead.next
    }

    private val ListNode?.value: Int
        get() = this?.`val` ?: 0
}