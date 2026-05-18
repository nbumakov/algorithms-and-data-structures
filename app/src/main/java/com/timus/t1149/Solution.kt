package com.timus.t1149

fun main() {
    val n = readLine()!!.toInt()

    fun Int.sign(): Char = if (this % 2 == 0) '+' else '-'

    fun an(max: Int, n: Int = 1): String {
        if (n > max) return ""
        if (n == max) return "sin($n)"

        return "sin($n${n.sign()}${an(max, n + 1)})"
    }

    fun sn(c: Int): String {
        if (c == 1) return "${an(1)}+${n - c + 1}"
        return "(${sn(c - 1)})${an(c)}+${n - c + 1}"
    }

    println(sn(n))
}