package com.leatcode.util

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun IntArray.toListNodes(): ListNode? =
    foldRight<ListNode?>(null) { value, acc ->
        ListNode(value).apply { next = acc }
    }

fun ListNode?.asString(): String = buildString {
    var node: ListNode? = this@asString
    while (node != null) {
        append(node.`val`)
        append(", ")
        node = node.next
    }
}


