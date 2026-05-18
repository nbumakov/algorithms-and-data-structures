package com.leetcode.t1556

fun thousandSeparator(n: Int): String {
    if (n == 0) return "0"
    var x = n.toString()
    return buildString {
        while (x.isNotEmpty()) {
            insert(0, x.takeLast(3))
            x = x.dropLast(3)
            if (x.isNotEmpty()) insert(0, '.')
        }
    }
}