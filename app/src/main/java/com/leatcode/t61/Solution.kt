package com.leatcode.t61

import com.leatcode.util.ListNode

class Solution {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        var node = head ?: return null
        var length = 1

        while (node.next != null) {
            node = node.next!!
            length++
        }

        node.next = head
        var rotations = length - k % length
        while (rotations > 0) {
            node = node.next!!
            rotations--
        }

        return node.next.also {
            node.next = null
        }
    }
}