package com.leetcode.t328

import com.leetcode.util.ListNode
import com.leetcode.util.print
import com.leetcode.util.toListNodes

fun main() {
    Solution().oddEvenList(
        intArrayOf(1, 2, 3, 4, 5).toListNodes()
    ).print()
}

class Solution {
    fun oddEvenList(head: ListNode?): ListNode? {
        val oddHead = head?.next
        var oddNode = oddHead
        var evenNode = head

        var node = oddHead
        var isEven = false
        while (node?.next != null) {
            node = node.next
            isEven = !isEven
            if (isEven) {
                evenNode?.next = node
                evenNode = node
            } else {
                oddNode?.next = node
                oddNode = node
            }
        }
        oddNode?.next = null
        evenNode?.next = oddHead

        return head
    }
}