package com.timus.t1563

fun main() {
    val shops = hashSetOf<String>()
    var count = 0
    repeat(readLine()!!.toInt()) {
        val shop = readLine()!!
        if (shops.contains(shop)) count++
        shops.add(shop)
    }
    println(count)
}