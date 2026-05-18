package com.coderun.t81

fun main() {
    val edges = listOf(
        readln().toInt(),
        readln().toInt(),
        readln().toInt(),
    ).sorted()
    println(
        if (edges[0] + edges[1] > edges[2]) "YES" else "NO"
    )
}