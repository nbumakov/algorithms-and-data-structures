package com.leetcode.t234

import com.leetcode.util.ListNode
import com.leetcode.util.print
import com.leetcode.util.toListNodes


fun main() {
    Solution().isPalindrome(intArrayOf(1).toListNodes()).print()
}

class Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        var length = 0
        var node = head
        while (node != null) {
            node = node.next
            length++
        }
        val middleIndex = length - length / 2

        var middle = head
        repeat(middleIndex - 1) {
            middle = middle?.next
        }
        middle?.next = reverse(middle?.next)

        node = head
        var node2 = middle?.next

        while (node2 != null) {
            if (node?.`val` != node2.`val`) return false
            node = node.next
            node2 = node2.next
        }
        return true
    }

    // 1 -> 2 -> 3
    private fun reverse(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var curr = head
        while (curr != null) {
            val nextTemp = curr.next
            curr.next = prev
            prev = curr
            curr = nextTemp
        }
        return prev
    }
}