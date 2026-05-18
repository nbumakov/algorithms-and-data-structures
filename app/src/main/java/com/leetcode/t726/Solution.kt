package com.leetcode.t726

import com.leetcode.util.print

fun main() {
//    Solution().countOfAtoms("H2O").print()
    Solution().countOfAtoms("Mg(OH)2").print()
}

class Solution {

    private lateinit var lexer: Lexer

    // (H2O2)3
    //  E -> TE | T
    //  T -> T  | TN | (E)N
    fun countOfAtoms(formula: String): String {
        lexer = Lexer(formula)
        return parseExpression()
            .toSortedMap()
            .map { (element, count) -> if (count > 1) "$element$count" else element }
            .joinToString("")
    }

    // E -> TE | T
    private fun parseExpression(): Map<String, Int> {
        val result = mutableMapOf<String, Int>()
        while (lexer.hasNext() && lexer.peek() != ")") {
            val term = parseTerm()
            for ((element, count) in term) {
                result[element] = result.getOrDefault(element, 0) + count
            }
        }
        return result
    }

    // T -> T  | TN | (E)N
    private fun parseTerm(): Map<String, Int> = when (val next: Any = lexer.next()) {
        "(" -> {
            val expression = parseExpression()
            lexer.next() // Consume ')'
            val factor = if (lexer.peek()?.isNumeric() == true) lexer.next().toInt() else 1
            expression multiply factor
        }
        else -> {
            val element = next as String
            val count = if (lexer.peek()?.isNumeric() == true) lexer.next().toInt() else 1
            mapOf(element to count)
        }
    }

    private infix fun Map<String, Int>.multiply(factor: Int): Map<String, Int> =
        mapValues { it.value * factor }

    private fun String.isNumeric(): Boolean = all { char -> char.isDigit() }

    private class Lexer(s: String) {
        private val tokens = ArrayDeque(s.tokenize())

        fun next(): String = tokens.removeFirst()
        fun hasNext(): Boolean = tokens.isNotEmpty()
        fun peek(): String? = tokens.firstOrNull()

        companion object {
            val Regex = Regex("(\\d+|[A-Z][a-z]*|\\(|\\))")

            private fun String.tokenize(): List<String> =
                Regex.findAll(this).map { it.value }.toList()
        }
    }
}