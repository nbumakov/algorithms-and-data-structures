package com.coderun.t70

import kotlin.math.abs

fun main() {
    readln()
    val array = readln().split(' ').map { it.toInt() }
    val x = readln().toInt()
    val closest = array.minBy { abs( it - x) }
    println(closest)
}