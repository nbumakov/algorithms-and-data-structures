package com.timus.t1585

fun main() {
    val penguinsMap = hashMapOf<String, Int>()
    repeat(readLine()!!.toInt()) {
        val penguin = readLine()!!
        penguinsMap[penguin] = penguinsMap.getOrDefault(penguin, 0) + 1
    }
    println(penguinsMap.maxBy { it.value }!!.key)
}