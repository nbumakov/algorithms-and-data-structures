package com.leetcode.t83

import com.leetcode.util.ListNode
import com.leetcode.util.asString
import com.leetcode.util.toListNodes

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
 * var li = com.leetcode.util.ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class com.leetcode.util.ListNode(var `val`: Int) {
 *     var next: com.leetcode.util.ListNode? = null
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

