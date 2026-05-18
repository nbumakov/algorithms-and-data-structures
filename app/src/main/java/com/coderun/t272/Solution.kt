package com.coderun.t272

fun main() {
    val n = readln().toInt()
    val map = mutableMapOf<Char, Int>()
    repeat(n) {
        val c = readln().first()
        map[c] = map.getOrDefault(c, 0) + 1
    }
    println(map.maxBy { it.value }.key)
}