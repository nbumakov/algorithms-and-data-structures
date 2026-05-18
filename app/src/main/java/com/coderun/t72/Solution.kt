package com.coderun.t72

fun main() {
    readln()
        .split(' ')
        .map { it.toInt() }
        .windowed(2)
        .all { it.first() < it.last() }
        .let { println(if (it) "YES" else "NO") }
}
