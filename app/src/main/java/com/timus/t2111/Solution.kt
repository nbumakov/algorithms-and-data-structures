package com.timus.t2111

fun main() {
    readLine()!!
    val result = readLine()!!
        .split(' ')
        .map(String::toLong)
        .sum()
        .let { it * it }
    println(result)
}