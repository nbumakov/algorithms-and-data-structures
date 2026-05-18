package com.timus.t2142

fun main() {
    var (a, b, c) = readLine()!!.split(' ').map(String::toLong)
    val (x, y, z) = readLine()!!.split(' ').map(String::toLong)

    a -= x
    if (a < 0) {
        c += a
        a = 0
    }
    b -= y
    if (b < 0) {
        c += b
        b = 0
    }
    println(if (c < 0 || z > a + b + c) "There are no miracles in life" else "It is a kind of magic")
}