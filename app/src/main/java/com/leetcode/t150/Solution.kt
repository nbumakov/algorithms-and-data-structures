package com.leetcode.t150

import com.leetcode.util.print
import java.util.Stack

fun main() {
    Solution().evalRPN(arrayOf("2", "1", "+", "3", "*")).print()
}

class Solution {

    fun evalRPN(tokens: Array<String>): Int = with(Stack<Int>()) {
        tokens.forEach { push(Operations[it]?.invoke(pop(), pop()) ?: it.toInt()) }
        pop()
    }

    companion object {
        private val Operations = hashMapOf(
            "+" to { a: Int, b: Int -> a + b },
            "*" to { a: Int, b: Int -> a * b },
            "-" to { a: Int, b: Int -> b - a },
            "/" to { a: Int, b: Int -> b / a },
        )
    }
}