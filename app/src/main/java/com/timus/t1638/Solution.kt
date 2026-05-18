package com.timus.t1638

import kotlin.math.abs

fun main() {
    val (thickness, cover, start, end) = readLine()!!.split(' ').map(String::toInt)

    val result = abs(end - start) * (2 * cover + thickness) +
            if (end > start) -thickness else thickness

    println(result)
}