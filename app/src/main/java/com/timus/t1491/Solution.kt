package com.timus.t1491

fun main() {
    val n = readLine()!!.toInt()
    val money = IntArray(n) { 0 }
    repeat(n + 1) {
        val (a, b, c) = readLine()!!.split(' ').map { it.toInt() }
        money[a - 1] += c
        if (b < n) money[b] -= c
    }

    var counter = 0
    money.map {
        counter += it
        counter
    }
        .joinToString(" ")
        .let(::println)
}