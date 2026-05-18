package com.leatcode.t22

import com.leatcode.util.print
import java.util.Stack
import kotlin.math.pow

fun main() {
    Solution()
        .generateParenthesis2(2)
        .print()
}

class Solution {

    // iterative
    fun generateParenthesis2(n: Int): List<String> = mutableListOf<String>().apply {
        val stack = ArrayDeque<Triple<String, Int, Int>>()
            .apply { add(Triple("", n, 0)) }

        while (stack.isNotEmpty()) {
            val (curr, i, openCount) = stack.removeLast()
            if (i == 0 && openCount == 0) {
                add(curr)
                continue
            }

            if (openCount > 0) stack.addLast(Triple("$curr)", i, openCount - 1))
            if (i > 0) stack.addLast(Triple("$curr(", i - 1, openCount + 1))
        }
    }

    //rec
    fun generateParenthesis(n: Int): List<String> = mutableListOf<String>().apply {
        val curr = StringBuilder()
        fun generateBalancedBrackets(n: Int, openCount: Int) {
            if (n == 0 && openCount == 0) {
                add(curr.toString())
                return
            }

            if (openCount > 0) {
                curr.append(')')
                generateBalancedBrackets(n, openCount - 1)
                curr.deleteCharAt(curr.lastIndex)
            }
            if (n > 0) {
                curr.append('(')
                generateBalancedBrackets(n - 1, openCount + 1)
                curr.deleteCharAt(curr.lastIndex)
            }
        }
        generateBalancedBrackets(n, 0)
    }

}