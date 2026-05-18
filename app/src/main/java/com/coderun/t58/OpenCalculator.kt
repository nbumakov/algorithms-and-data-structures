package com.coderun.t58

fun main() {
    val keys = readln().replace(" ", "").toSet()
    val number = readln()
    val result = (number.toSet() - keys).size
    println(result)
}