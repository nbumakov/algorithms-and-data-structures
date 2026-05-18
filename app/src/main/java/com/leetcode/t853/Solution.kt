package com.leetcode.t853

import com.leetcode.util.print

fun main() {
    Solution().carFleet(12, intArrayOf(10, 8, 0, 5, 3), intArrayOf(2, 4, 1, 1, 3)).print()
}

class Solution {


    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {

        val cars = position.zip(speed).sortedBy { it.first }
        val getTime: (car: Pair<Int, Int>) -> Double = { (p, s) -> (target - p) / s.toDouble() }

        var fleets = 1
        var lastTime = getTime(cars.last())

        for (i in cars.lastIndex - 1 downTo 0) {
            val time = getTime(cars[i])
            if (time > lastTime) {
                lastTime = time
                fleets++
            }
        }

        return fleets


        // target = 12
        // position = [0,3,5,8,10],
        // speed    = [1,3,1,4,2]

        // 2/2 = 1h
        // 4/4 = 1h
        // 7/1 = 7h
        // 9/3 = 3h -> 7h
        // 12/1 = 12h

    }
}