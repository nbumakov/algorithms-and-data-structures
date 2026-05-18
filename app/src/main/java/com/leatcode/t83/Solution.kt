package com.leatcode.t83

import com.leatcode.util.ListNode
import com.leatcode.util.asString
import com.leatcode.util.toListNodes

/**
 * Given the head of a sorted linked list,
 * delete all duplicates such that each element appears only once.
 * Return the linked list sorted as well.
 */
fun main() {
    println(
        Solution().deleteDuplicates(
            intArrayOf(1, 1, 2, 3, 3).toListNodes()
        ).asString()
    )
}


/**
 * Example:
 * var li = com.example.leatcode.util.ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class com.example.leatcode.util.ListNode(var `val`: Int) {
 *     var next: com.example.leatcode.util.ListNode? = null
 * }
 */
class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        var node = head
        while (node != null) {
            if (node.`val` == node.next?.`val`) {
                node.next = node.next?.next
            } else {
                node = node.next
            }
        }
        return head
    }
}

