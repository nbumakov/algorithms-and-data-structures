package com.coderun.t153

fun main() {
    val (h, n) = readln().split(' ').map(String::toInt)
    val x = readln().split(' ').map(String::toInt)

    var r = x.sum() / h
    var l = 0
    while (l <= r) {
        val m = l + (r - l) / 2
        var i = 0
        var j = 0
        var sum = 0
        while (j < h && i < n) {
            sum += x[i]
            i++
            if (sum >= m) {
                sum = 0
                j++
            }
        }
        if (j == h) l = m + 1 else r = m - 1
    }
    println(r)
}