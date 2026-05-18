package com.leatcode.t539

import java.util.Collections.min
import kotlin.math.abs
import kotlin.math.min

fun main() {
    SolutionSD().findMinDifference(listOf("23:59", "00:00"))
        .let(::println)
}

class Solution {
    fun findMinDifference(timePoints: List<String>): Int {
        val times = timePoints.map {
            val (h, m) = it.split(":").map { it.toInt() }
            h * 60 + m
        }.sorted()

       val min = times.windowed(2)
           .minOf { abs(it[0] - it[1]) }
        return min(min, 1440 - (times.last() - times.first()))
    }
}

class SolutionSD {
    fun findMinDifference(timePoints: List<String>) =
        timePoints.map { it.split(":").let { it[0].toInt() * 60 + it[1].toInt() }}
            .sorted()
            .let { it + (it[0] + 24 * 60) }
            .windowed(2).minOf { it[1] - it[0] }
}