package com.leatcode.t143

import com.leatcode.util.ListNode
import java.util.LinkedList
import java.util.Queue

class Solution {

    //TODO: solve it with reversing second half of the list
    fun reorderList(head: ListNode?) {
        val queue = LinkedList<ListNode>()
        var node = head
        while (node != null) {
            queue.add(node)
            node = node.next
        }
        node = queue.removeFirst()
        for (i in 0..queue.lastIndex) {
            if (i % 2 == 0) {
                node!!.next = queue.removeLast()
            } else {
                node!!.next = queue.removeFirst()
            }
            node = node.next!!
        }
        node?.next = null
    }
}