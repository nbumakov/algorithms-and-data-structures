package com.timus.t1243

private val KEY = mapOf(0 to 1, 1 to 3, 2 to 2, 3 to -1, 4 to -3, 5 to -2)

fun main() {
    println(readLine()!!.mod7())
}

private fun String.mod7(): Int = foldRightIndexed(0) { i, c, sum ->
    sum + Character.getNumericValue(c) * KEY[(lastIndex - i) % 6]!!
}
    .mod(7)
    .let { if (it < 0) it + 7 else it }

private fun Int.mod(other: Int): Int = this % other