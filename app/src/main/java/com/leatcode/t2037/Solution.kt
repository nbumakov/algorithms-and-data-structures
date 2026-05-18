package com.leatcode.t2037

import kotlin.math.abs

class Solution {
    fun minMovesToSeat(seats: IntArray, students: IntArray): Int {
        seats.sort()
        students.sort()
        return seats.foldIndexed(0){ index, acc, i ->
            acc + abs(i - students[index])
        }
    }
}