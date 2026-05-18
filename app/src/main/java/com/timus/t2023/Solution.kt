package com.timus.t2023

import kotlin.math.abs

fun main() {
    var position = 0
    var steps = 0
    repeat(readLine()!!.toInt()) {
        val newPosition = readLine()!!.position()
        steps += abs(position - newPosition)
        position = newPosition
    }
    println(steps)
}

private fun String.position(): Int = when (first()) {
    'A', 'P', 'O', 'R' -> 0
    'B', 'M', 'S' -> 1
    else -> 2
}