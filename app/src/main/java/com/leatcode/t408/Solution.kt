package com.leatcode.t408

class Solution {

    fun validWordAbbreviation(word: String, abbr: String): Boolean = runCatching {
        val lexer = Lexer(abbr)
        var p = 0
        while (p < word.length && lexer.hasNext()) {
            when (val next = lexer.next()) {
                is Lexer.Lexeme.Char -> if (word[p++] != next.value) return false
                is Lexer.Lexeme.Int -> p += next.value
            }
        }
        return p == word.length && !lexer.hasNext()
    }.getOrElse { false }

    private class Lexer(private val input: String) {
        private var pointer = 0

        fun hasNext(): Boolean =
            pointer < input.length

        fun next(): Lexeme =
            if (input[pointer].isDigit()) nextInt() else nextChar()

        private fun nextInt(): Lexeme.Int {
            if (input[pointer] == '0') throw LeadingZeroException()
            val value = input.drop(pointer).takeWhile { it.isDigit() }
            pointer += value.length
            return Lexeme.Int(value.toInt())
        }

        private fun nextChar(): Lexeme.Char =
            Lexeme.Char(input[pointer])
                .also { pointer++ }

        sealed interface Lexeme {
            class Char(val value: kotlin.Char) : Lexeme
            class Int(val value: kotlin.Int) : Lexeme
        }

        private class LeadingZeroException : RuntimeException()
    }

}

class Solution2 {
    fun validWordAbbreviation(word: String, abbr: String): Boolean {
        var i = 0
        var j = 0

        while (i < word.length && j < abbr.length) {
            if (abbr[j].isDigit()) {
                if (abbr[j] == '0') return false
                var num = 0
                while (j < abbr.length && abbr[j].isDigit()) {
                    num = num * 10 + (abbr[j] - '0')
                    j++
                }
                i += num
            } else {
                if (word[i] != abbr[j]) return false
                i++
                j++
            }
        }

        return i == word.length && j == abbr.length
    }
}