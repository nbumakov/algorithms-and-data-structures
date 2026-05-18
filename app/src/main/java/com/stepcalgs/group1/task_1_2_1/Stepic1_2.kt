package com.example.stepcalgs.group1.task_1_2_1

import java.util.*

val OPENING_BRACKETS = listOf('{', '[', '(')
val CLOSING_BRACKETS = listOf('}', ']', ')')
val BRACKETS = OPENING_BRACKETS + CLOSING_BRACKETS


val bracketsStack = Stack<Pair<Char, Int>>()

/**
 * []{}()
 * [{{}()}]
 */
fun main() {
    runCatching { validateBrackets(Scanner(System.`in`).next()) }
        .onFailure(::handleValidationError)
        .onSuccess { handleValidationSuccess() }
}

private fun validateBrackets(text: String) {
    text.forEachIndexed(::validateLetter)
    if (!bracketsStack.isEmpty()) {
        throw WrongBracketsSequenceException(bracketsStack[0].second)
    }
}

private fun handleValidationError(throwable: Throwable) {
    if (throwable is WrongBracketsSequenceException) {
        println(throwable.position + 1)
    } else {
        println(throwable)
    }
}

private fun handleValidationSuccess() = println("Success")

private fun validateLetter(position: Int, char: Char) {
    if (char !in BRACKETS) {
        return
    }
    if (char in OPENING_BRACKETS) {
        bracketsStack.add(Pair(char, position))
    } else {
        if (bracketsStack.isEmpty()) {
            throw WrongBracketsSequenceException(position)
        }
        val (openingBracket, _) = bracketsStack.pop()
        if (openingBracket != getOppositeOpeningBracket(char)) {
            throw WrongBracketsSequenceException(position)
        }
    }
}

private fun getOppositeOpeningBracket(char: Char): Char =
    OPENING_BRACKETS[CLOSING_BRACKETS.indexOf(char)]

private class WrongBracketsSequenceException(val position: Int) : Exception("Wrong brackets sequence at $position")