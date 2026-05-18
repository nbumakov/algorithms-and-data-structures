package com.leetcode.t23

import com.leetcode.util.ListNode
import java.util.PriorityQueue

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val heap = PriorityQueue<ListNode> { a, b -> a.`val` - b.`val` }
        lists.asSequence().filterNotNull().forEach { heap.add(it) }
        val dummyHead = ListNode(-1)
        var curr: ListNode = dummyHead
        while (heap.isNotEmpty()) {
            val node = heap.remove()!!
            curr.next = node
            curr = node
            node.next?.let(heap::add)
        }

        return dummyHead.next
    }
}