package com.leatcode.t394

import com.leatcode.util.print
import java.util.Stack

fun main() {
    Solution().decodeString2("3[a]2[bc]").print()
}

class Solution {

    // add everything into stack until ']'
    fun decodeString(s: String): String = with(Stack<Char>()) {
        s.forEach { c ->
            if (c != ']') {
                push(c)
            } else {
                val word = StringBuilder().also {
                    while (peek() != '[') it.append(pop())
                    it.reverse()
                }
                pop()
                val count = StringBuilder().also {
                    while (isNotEmpty() && peek().isDigit()) it.append(pop())
                }.reverse().toString().toInt()

                repeat(count) { word.forEach { add(it) } }
            }
        }
        joinToString("")
    }

    // efficient but hard to understand
    fun decodeString2(s: String): String {
        val stack = Stack<Any>()
        var curr = StringBuilder()
        var n = 0
        s.forEach { c ->
            when {
                c.isDigit() -> n = 10 * n + Character.digit(c, 10)
                c == '[' -> {
                    stack.push(n)
                    stack.push(curr.toString())
                    n = 0
                    curr.clear()
                }

                c == ']' -> {
                    val str = stack.pop() as String
                    val num = stack.pop() as Int
                    curr = StringBuilder(str + curr.repeat(num))
                }

                else -> curr.append(c)
            }
        }
        return curr.toString()
    }

}