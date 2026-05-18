package com.example.stepcalgs.group1.task_1_2_3

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val bufferSize = scanner.nextInt()
    val packagesCount = scanner.nextInt()

    val endTimes = PriorityQueue<Int>()

    var currentTime = 0

    for (i in 0 until packagesCount) {
        val arrival = scanner.nextInt()
        val duration = scanner.nextInt()

        if (currentTime <= arrival) {
            currentTime = arrival
        } else if (bufferSizeAtTime2(endTimes, arrival) >= bufferSize) {
            println(-1)
            continue
        }

        println(currentTime)
        currentTime += duration
        endTimes.offer(currentTime)

    }
}

fun bufferSizeAtTime2(endTimes: PriorityQueue<Int>, time: Int): Int {
    val iterator = endTimes.iterator()
    var count = 0
    while (iterator.hasNext() && iterator.next() <= time) {
        count++
    }
    return endTimes.size - count
}