package com.leetcode.t2816

import com.leetcode.util.ListNode
import com.leetcode.util.print

fun main() {
    Solution().doubleIt(
        ListNode(3).apply {
            next = ListNode(5)
        }
    ).print()
}

class Solution {

    fun doubleIt(head: ListNode?): ListNode? {
        var reversed = reverse(head)

        var overflow = 0
        var result: ListNode? = null

        while (overflow > 0 || reversed != null) {
            var value = overflow

            value += reversed?.`val`?.let { 2 * it } ?: 0
            reversed = reversed?.next

            if (value > 9) {
                overflow = 1
                value %= 10
            } else {
                overflow = 0
            }
            result = ListNode(value).apply { next = result }
        }

        return result
    }

    private fun reverse(node: ListNode?): ListNode? {
        if (node?.next == null) return node

        val head = reverse(node.next)
        node.next?.next = node
        node.next = null

        return head
    }


//    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
//        var reverseL1 = reverse(l1)
//        var reverseL2 = reverse(l2)
//
//        var overflow = 0
//        var result: ListNode? = null
//
//        while (overflow > 0 || reverseL1 != null || reverseL2 != null) {
//            var value = overflow
//
//            if (reverseL1 != null) {
//                value += reverseL1.`val`
//                reverseL1 = reverseL1.next
//            }
//
//            if (reverseL2 != null) {
//                value += reverseL2.`val`
//                reverseL2 = reverseL2.next
//            }
//
//            if (value > 9) {
//                overflow = 1
//                value %= 10
//            } else {
//                overflow = 0
//            }
//            result = ListNode(value).apply { next = result }
//        }
//
//        return result
//    }

    // 1 -> 2 -> 3


//    fun doubleIt(head: ListNode?): ListNode? {
//        var node = head
//        val sb = StringBuilder()
//        while (node != null) {
//            sb.append(node.`val`)
//        }
//        val i = BigInteger(sb.toString()).multiply()
//
//        return null
//    }
}