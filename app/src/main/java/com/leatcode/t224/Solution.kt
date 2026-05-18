package com.leatcode.t224

import com.leatcode.util.print
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.Stack
import java.util.StringTokenizer


fun main() {
//    Solution().calculate(" 2 + 2* 2").print()
//    Solution().calculate(" 2-1 + 2 ").print()

    Solution().calculate("- (3 + (4 + 5))").print()
//    Solution().calculate("14/3*2").print()
}

//  E -> T + E | T - E | T
//  T -> T * F | T / F | F
//  F -> N     | (E)
class Solution {

    private lateinit var lexer: Lexer

    fun calculate(s: String): Int {
        lexer = Lexer(s)
        return expression()
    }

    // E -> T + E | T - E | T
    private fun expression(): Int {
        var first = term()
        while (lexer.hasNext()) {
            val operator: Any? = lexer.peek()
            if (operator !in SecondaryOperations) break

            when (lexer.next()) {
                "+" -> first += term()
                "-" -> first -= term()
            }
        }
        return first
    }

    // T -> T * F | T / F | F
    private fun term(): Int {
        var first: Int = factor()
        while (lexer.hasNext()) {
            val operator = lexer.peek()
            if (operator !in PrimaryOperations) break

            when (lexer.next()) {
                "*" -> first *= factor()
                "/" -> first /= factor()
            }
        }
        return first
    }

    // F -> N | -(E) | (E)
     private fun factor(): Int = when (val next: Any = lexer.next()) {
        "-" -> -1 * factor()
        "(" -> expression().also { lexer.next() }
        else -> (next as String).toInt()
    }

    private class Lexer(s: String) {
        private val tokens = ArrayDeque<Any>(Regex.findAll(s).map { it.value }.toList())

        fun next(): Any = tokens.removeFirst()

        fun hasNext(): Boolean = tokens.isNotEmpty()

        fun peek(): Any? = tokens.firstOrNull()

        companion object {
            val Regex = Regex("([0-9]+|\\+|-|\\*|/|\\(|\\))")
        }
    }

    companion object {
        private val PrimaryOperations = setOf("*", "/")
        private val SecondaryOperations = setOf("+", "-")
    }
}