package com.timus.t1290

fun main() {
    val array = IntArray(readLine()!!.toInt()) { readLine()!!.toInt() }
    array.sortDescending()
    array.forEach(::println)
}