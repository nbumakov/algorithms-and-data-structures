package com.timus.t1044

import kotlin.math.pow

fun main() {
    val n = readLine()!!.toInt()
    val sums = HashMap<Int, Int>()
    for (k in 0 until 10.0.pow(n / 2).toInt()) {
        val sum = k.sum()
        sums[sum] = sums.getOrDefault(sum, 0) + 1
    }
    println(sums.values.fold(0) { sum, value -> sum + value * value })
}

fun main_TLE() {
    val n = readLine()!!.toInt()
    val max = 10.0.pow(n / 2).toInt()
    var sum = 0
    for (i in 0 until max) {
        for (j in 0 until max) {
            if (i.sum() == j.sum()) sum++
        }
    }
    println(sum)
}

private fun Int.sum(): Int {
    var n = this
    var sum = 0
    while (n > 0) {
        sum += n % 10
        n /= 10
    }
    return sum
}