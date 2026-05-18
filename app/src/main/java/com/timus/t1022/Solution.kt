package com.timus.t1022


// TODO find the O(V+E) algorithm
// It's work. Topological sorting this graph(whith dfs), and write answer

fun main() {
    val n = readLine()!!.toInt()
    val matrix = Array(n) { mutableListOf<Int>() }

    val result = mutableSetOf<Int>()

    repeat(n) { i ->
        readLine()!!
            .split(' ')
            .asSequence()
            .map { it.toInt() - 1 }
            .filter { it >= 0 }
            .forEach { matrix[i].add(it) }
    }

    while (result.size < n) {
        for (i in 0 until n) {
            if (matrix[i].all { result.contains(it) }) {
                result.add(i)
            }
        }
    }

    println(result.reversed().map { it + 1 }.joinToString(" "))
}