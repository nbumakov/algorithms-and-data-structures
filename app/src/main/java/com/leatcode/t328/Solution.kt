package com.leatcode.t328

import com.leatcode.util.ListNode
import com.leatcode.util.asString
import com.leatcode.util.print
import com.leatcode.util.toListNodes

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