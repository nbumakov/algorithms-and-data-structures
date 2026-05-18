package com.leatcode.t142

import com.leatcode.util.ListNode
import com.leatcode.util.print

fun main() {
    Solution().detectCycle(ListNode(1))?.print()
}

class Solution {

    fun detectCycle(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return null
        }

        var fast = head
        var slow = head
        var cycleEntrance: ListNode? = null

        while (fast?.next != null) {
            fast = fast.next?.next
            slow = slow?.next
            if (fast == slow) {
                break
            }
        }

        if (fast == slow) {
            fast = head
            while (fast != slow) {
                fast = fast?.next
                slow = slow?.next
            }
            cycleEntrance = fast
        }

        return cycleEntrance
    }

    fun detectCycleHashSet(head: ListNode?): ListNode? {
        val set = hashSetOf<ListNode>()
        var node = head
        while (node != null) {
            if (set.contains(node)) {
                return node
            }
            set.add(node)
            node = node.next
        }
        return null
    }
}