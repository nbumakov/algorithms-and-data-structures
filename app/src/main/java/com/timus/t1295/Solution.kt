package com.timus.t1295

//1n+2n+3n+4n. = 1 + 2^n*(1 + 2^n) + 3^n
// 1 + 2 + 3 + 4 = 10
// 1 + 4 + 9 + 16 = 30
// 1 + 8 + 27 + 64 = 100

//    for (n in 1..25) {
//        println("n=$n: " + (1L + 2.pow(n) + 3.pow(n) + 4.pow(n)))
//    }

fun main() {
    val n = readLine()!!.toInt()
    println(
        when {
            n % 4 == 0 -> 0
            n % 4 == 3 -> 2
            (n - 5) % 20 == 0 -> 2
            else -> 1
        }
    )
}

private fun Int.pow(n: Int): Long {
    var r = 1L
    repeat(n) { r *= this }
    return r
}
