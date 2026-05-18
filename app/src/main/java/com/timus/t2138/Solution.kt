package com.timus.t2138

fun main() {
    readLine()
    println(readLine()!!.toLong().decode().reversed().encode())
}

private fun Long.decode(): List<Int> {
    val res = mutableListOf<Int>()
    var x = this
    while (x > 0) {
        res.add(0, (x % 256).toInt())
        x /= 256
    }
    while (res.size < 4) res.add(0, 0)
    return res
}

private fun List<Int>.encode(): Long {
    var multiplayer = 1
    return foldRight(0L) { n, acc ->
        acc + n.toLong() * multiplayer.also { multiplayer *= 256 }
    }
}