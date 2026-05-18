package com.timus.t1191

fun main() {
    val (l, _) = readLine()!!.split(" ").map { it.toInt() }
    val gaps = readLine()!!.split(" ").map { it.toInt() }

    val gap = gaps.fold(l) { time, k -> time - time % k }
    println(if (gap > 0) "NO" else "YES")
}