package com.timus.t2149

fun main() {
    val n = readLine()!!.toInt()
    val line = readLine()!!.filterIndexed { i, _ -> (i + 1) % 5 != 0 }
    val pidgins = mutableListOf<Boolean>()
    for (c in 0..line.lastIndex step 4) {
        pidgins.add(line[c] == '<')
    }
    val variants = mutableListOf<Int>()

    val left = pidgins.slice(0 until n / 2).count { it }
    val right = pidgins.slice(n / 2 until n).count { !it }
    variants.add(left + right)
    variants.add(n - left - right)

    val even = pidgins.filterIndexed { index, b -> index % 2 == 0 && b }.count()
    val odd = pidgins.filterIndexed { index, b -> index % 2 == 1 && !b }.count()

    variants.add(even + odd)
    variants.add(n - even - odd)

    println(variants.min())
}