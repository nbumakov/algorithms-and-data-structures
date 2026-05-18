package com.leetcode.t708

import com.leetcode.util.Node

class Solution {
    fun insert(head: Node?, insertVal: Int): Node? {
        if (head == null) {
            return Node(insertVal).also { it.next = it }
        }
        var pivot: Node = head
        while (pivot.next!!.`val` >= pivot.`val` && pivot.next != head) pivot = pivot.next!!

        var curr: Node = pivot
        while (insertVal > curr.next!!.`val` && curr.next != pivot) curr = curr.next!!

        if(insertVal > curr.next!!.`val` && curr.next == pivot){
            curr = curr.next!!
        }

        curr.next = Node(insertVal).also { it.next = curr.next }
        return head
    }
}

