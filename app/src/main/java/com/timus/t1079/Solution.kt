package com.timus.t1079

fun main() {
    val a = mutableListOf<Pair<Int, Int>>()
    a.add(0 to 0)
    a.add(1 to 1)
    var max = 1
    for (i in 2 until 100000) {
        if (i % 2 == 0) {
            a.add(a[i / 2].first to max)
        } else {
            val value = a[i / 2].first + a[i / 2 + 1].first
            max = maxOf(max, value)
            a.add(value to max)
        }
    }

    while (true) {
        val n = readLine()!!.toInt()
        if (n == 0) break
        println(a[n].second)
    }
}

fun main_simple() {
    val array = IntArray(100000)
    array[0] = 0
    array[1] = 1
    for (i in 0 until 100000) {
        if (i % 2 == 0) {
            array[i] = array[i / 2]
        } else {
            array[i] = array[i / 2] + array[i / 2 + 1]
        }
    }

    while (true) {
        val n = readLine()!!.toInt()
        if (n == 0) break
        println(array.slice(0..n).max())
    }
}