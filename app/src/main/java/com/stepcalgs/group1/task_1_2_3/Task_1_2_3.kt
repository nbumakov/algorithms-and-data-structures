package com.example.stepcalgs.group1.task_1_2_3

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val bufferSize = scanner.nextInt()
    val packagesCount = scanner.nextInt()

    val buffer = Buffer(bufferSize)
    var currentTime = 0

    repeat(packagesCount) {
        val arrival = scanner.nextInt()
        val duration = scanner.nextInt()

        when {
            // есть время сделать все текущие задачи до следующего пакета
            currentTime <= arrival -> {
                if (currentTime < arrival) {
                    currentTime = arrival
                }
                println(currentTime)
                currentTime += duration
                buffer.add(currentTime)
            }
            buffer.isBufferAvailableAtTime(arrival) -> {
                println(currentTime)
                currentTime += duration
                buffer.add(currentTime)
            }
            else -> println(-1)
        }
    }
}

private class Buffer(val size: Int) {

    private val endTimes = LinkedList<Int>()

    fun add(endTime: Int) = endTimes.add(endTime)

    fun isBufferAvailableAtTime(time: Int): Boolean {
        val iterator = endTimes.iterator()
        var count = 0
        while (iterator.hasNext() && iterator.next() <= time) count++
        return endTimes.size - count < size
    }

    fun isBufferAvailableAtTimeWrong(time: Int): Boolean =
        endTimes.count { it > time } < size

}
