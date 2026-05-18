package com.leatcode.t237

import com.leatcode.util.ListNode

class Solution {

    // O(n)
    fun deleteNode(node: ListNode?) {
        var curr = node
        while (curr != null){
            curr.`val` = curr.next!!.`val`
            if(curr.next!!.next == null){
                curr.next = null
            }
            curr = curr.next
        }
    }
}

class Solution2 {

    // O(1)
    fun deleteNode(node: ListNode?) {
        node!!.`val` = node.next!!.`val`
        node.next = node.next?.next
    }
}