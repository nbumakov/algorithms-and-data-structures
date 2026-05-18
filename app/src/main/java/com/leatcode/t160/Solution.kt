package com.leatcode.t160

import com.leatcode.util.ListNode

class Solution {

    // both pointers will pass a+b
    fun getIntersectionFastest(headA: ListNode?, headB: ListNode?): ListNode? {
        var p1 = headA
        var p2 = headB

        while (p1 != p2) {
            p1 = if (p1 == null) headB else p1.next
            p2 = if (p2 == null) headA else p2.next
        }

        return p1
    }

    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {

        var (tailA, lengthA) = headA.getTail()
        var (tailB, lengthB) = headB.getTail()

        if (tailA != tailB) return null

        var nodeA = headA
        var nodeB = headB
        while (lengthA > lengthB) {
            nodeA = nodeA?.next
            lengthA--
        }
        while (lengthA < lengthB) {
            nodeB = nodeB?.next
            lengthB--
        }
        while (nodeA != nodeB) {
            nodeA = nodeA?.next
            nodeB = nodeB?.next
        }
        return nodeA
    }

    private fun ListNode?.getTail(): Pair<ListNode?, Int> {
        var length = 0
        var node = this
        while (node?.next != null) {
            node = node.next
            length++
        }
        return node to length
    }
}