package com.coderun.t1

fun main() {
    readln()
        .split(" ")
        .map { it.toInt() }
        .sorted()[1]
        .let { println(it) }
}