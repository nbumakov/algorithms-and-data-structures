package com.timus.t1330

import java.io.PrintWriter

fun main() {
    val prefixSum = mutableListOf(0)
    repeat(readLine()!!.toInt()) { i ->
        prefixSum.add(prefixSum[i] + readLine()!!.toInt())
    }
    with(PrintWriter(System.out)) {
        repeat(readLine()!!.toInt()) {
            val (i, j) = readLine()!!.split(' ').map(String::toInt)
            println(prefixSum[j] - prefixSum[i - 1])
        }
        close()
    }
}