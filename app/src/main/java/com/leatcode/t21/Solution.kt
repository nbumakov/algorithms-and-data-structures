package com.leatcode.t21

import com.leatcode.util.ListNode
import com.leatcode.util.asString
import com.leatcode.util.toListNodes

/**
 * Example:
 * var li = com.example.leatcode.util.ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class com.example.leatcode.util.ListNode(var `val`: Int) {
 *     var next: com.example.leatcode.util.ListNode? = null
 * }
 */

fun main() {
    val result = Solution().mergeTwoListsRecursion(
        (IntArray(3) { it }).toListNodes()
            .also { println("First: ${it.asString()}") },
        (IntArray(3) { it * 2 }).toListNodes()
            .also { println("Second: ${it.asString()}") },
    )

    println("Result: ${result.asString()}")
}

class Solution {

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var l = list1
        var r = list2

        val start = ListNode(0)
        var current = start
        while (l != null && r != null) {
            if (l.`val` < r.`val`) {
                current.next = l
                current = l
                l = l.next

            } else {
                current.next = r
                current = r
                r = r.next
            }
        }
        if (l != null) current.next = l
        if (r != null) current.next = r

        return start.next
    }

    fun mergeTwoListsRecursion(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null && list2 == null) {
            return null
        }
        if (list1 == null) {
            return list2
        }
        if (list2 == null) {
            return list1
        }

        return if (list1.`val` < list2.`val`) {
            list1.apply {
                next = mergeTwoListsRecursion(list1.next, list2)
            }
        } else {
            list2.apply {
                next = mergeTwoListsRecursion(list1, list2.next)
            }
        }
    }

}


