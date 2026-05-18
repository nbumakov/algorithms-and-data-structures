package com.leatcode.util

fun Any?.print() {
    when (this) {
        is TreeNode -> printDfs()
        is ListNode -> asString().let(::println)
        is IntArray -> joinToString().let(::println)
        else -> println(this)
    }
}