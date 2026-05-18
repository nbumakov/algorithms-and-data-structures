package com.timus.t1877

fun main() {
    val n1 = readLine()!!.toInt()
    val n2 = readLine()!!.toInt()

    println(if (n1 % 2 == 0 || n2 % 2 == 1) "yes" else "no")
}