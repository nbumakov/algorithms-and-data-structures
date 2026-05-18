package com.leatcode.t148

import com.leatcode.util.ListNode


class Solution {

    fun sortList(head: ListNode?): ListNode? = head.qsort()

    private fun ListNode?.qsort(): ListNode? {
        if (this?.next == null) return this

        val (left, middle, right) = partition(middle()!!.`val`)

        return left.qsort() + middle + right.qsort()
    }

    private fun ListNode?.partition(threshold: Int): Triple<ListNode?, ListNode?, ListNode?> {
        val dummyLeft = ListNode(-1)
        val dummyMiddle = ListNode(-1)
        val dummyRight = ListNode(-1)
        var left = dummyLeft
        var middle = dummyMiddle
        var right = dummyRight
        var curr = this
        while (curr != null) {
            when {
                curr.`val` < threshold -> {
                    left.next = curr
                    left = curr
                }
                curr.`val` > threshold -> {
                    right.next = curr
                    right = curr
                }
                else -> {
                    middle.next = curr
                    middle = curr
                }
            }
            curr = curr.next
        }

        left.next = null
        middle.next = null
        right.next = null

        return Triple(dummyLeft.next, dummyMiddle.next, dummyRight.next)
    }

    private fun ListNode?.middle(): ListNode? {
        var slow = this
        var fast = this
        while (fast != null) {
            fast = fast.next?.next
            slow = slow?.next
        }
        return slow
    }

    private operator fun ListNode?.plus(b: ListNode?): ListNode? {
        var curr = this
        while (curr?.next != null) curr = curr.next
        curr?.next = b
        return this ?: b
    }

}