package com.timus.t1026

fun main() {
    val list = MutableList(readLine()!!.toInt()) { readLine()!!.toInt() }.apply { sort() }

    readLine()

    repeat(readLine()!!.toInt()) {
        println(list[readLine()!!.toInt() - 1])
    }
}