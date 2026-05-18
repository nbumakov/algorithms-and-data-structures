package com.leatcode.t445

import com.leatcode.util.ListNode
import java.util.Stack

fun main() {
//    Solution().reverse(
//        ListNode(1).apply {
//            next = ListNode(2).apply {
//                next = ListNode(3)
//            }
//        }
//    ).print()
}

class ReverseSolution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var reverseL1 = reverse(l1)
        var reverseL2 = reverse(l2)

        var overflow = 0
        var result: ListNode? = null

        while (overflow > 0 || reverseL1 != null || reverseL2 != null) {
            var value = overflow

            if (reverseL1 != null) {
                value += reverseL1.`val`
                reverseL1 = reverseL1.next
            }

            if (reverseL2 != null) {
                value += reverseL2.`val`
                reverseL2 = reverseL2.next
            }

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

    // 1 -> 2 -> 3
    private fun reverse(node: ListNode?): ListNode? {
        if (node?.next == null) return node

        val head = reverse(node.next)
        node.next?.next = node
        node.next = null

        return head
    }
}

class StackSolution {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val stack1 = Stack<Int>().apply { addAll(l1) }
        val stack2 = Stack<Int>().apply { addAll(l2) }
        var overflow = 0
        var result: ListNode? = null
        while (stack1.isNotEmpty() || stack2.isNotEmpty() || overflow > 0) {
            var value = overflow
            if (stack1.isNotEmpty()) value += stack1.pop()
            if (stack2.isNotEmpty()) value += stack2.pop()
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

    private fun Stack<Int>.addAll(l1: ListNode?) {
        var node = l1
        while (node != null) {
            push(node.`val`)
            node = node.next
        }
    }
}

class CheatSolution {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var reverseL1 = reverse(l1)
        var reverseL2 = reverse(l2)

        var overflow = 0
        var result: ListNode? = null

        while (overflow > 0 || reverseL1 != null || reverseL2 != null) {
            var value = overflow
            var node: ListNode? = null

            if (reverseL1 != null) {
                value += reverseL1.`val`
                node = reverseL1
                reverseL1 = reverseL1.next
            }

            if (reverseL2 != null) {
                value += reverseL2.`val`
                node = reverseL2
                reverseL2 = reverseL2.next
            }

            if (value > 9) {
                overflow = 1
                value %= 10
            } else {
                overflow = 0
            }

            result = (node ?: ListNode(value)).apply {
                `val` = value
                next = result
            }
        }

        return result
    }

    // 1 -> 2 -> 3
    private fun reverse(node: ListNode?): ListNode? {
        if (node?.next == null) return node

        val head = reverse(node.next)
        node.next?.next = node
        node.next = null

        return head
    }
}