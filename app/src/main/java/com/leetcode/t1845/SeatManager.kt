package com.leetcode.t1845

import java.util.PriorityQueue

class SeatManager(n: Int) {
    private var first = 1
    private val available = PriorityQueue<Int>()

    fun reserve(): Int =
        if (available.isNotEmpty()) {
            available.first().also { available.remove(it) }
        } else first++

    fun unreserve(seatNumber: Int) {
        available.add(seatNumber)
    }

}