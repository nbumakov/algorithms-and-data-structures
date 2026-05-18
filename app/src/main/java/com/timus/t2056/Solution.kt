package com.timus.t2056

fun main() {
    val marks = IntArray(readLine()!!.toInt()) {
        readLine()!!.toInt()
    }

    println(when {
        marks.any { it < 4 } -> "None"
        marks.all { it == 5 } -> "Named"
        marks.average() >= 4.5 -> "High"
        else -> "Common"
    })
}