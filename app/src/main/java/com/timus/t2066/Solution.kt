package com.timus.t2066

fun main() {
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toInt()

    println(minOf(a - b - c, a - b * c))
}