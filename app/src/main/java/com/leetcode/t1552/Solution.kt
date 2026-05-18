package com.leetcode.t1552

import com.leetcode.util.print

fun main() {
//    Solution().maxDistance(
//        position = intArrayOf(1,2,3,4,7),
//        m = 3
//    ).print()

    Solution().maxDistance(
        position = intArrayOf(79,74,57,22),
        m = 4
    ).print()
}

class Solution {
    fun maxDistance(position: IntArray, m: Int): Int {
        position.sort()

        fun canFit(distance: Int): Boolean {
            var balls = m
            var i = 0
            var targetDistance = position[0]
            while (i < position.size && balls > 0) {
                if (position[i] >= targetDistance){
                    balls--
                    targetDistance = position[i] + distance
                }
                i++
            }
            return balls == 0
        }

        var h = (position.max() - position.min()) / (m - 1)
        var l = 1
        while (l <= h) {
            val m = (l + h) / 2
            if (canFit(m).also { println("$m, $it") }) {
                l = m + 1
            } else {
                h = m - 1
            }
        }

        return l - 1
    }
}

class SolutionGpt {
    fun maxDistance(position: IntArray, m: Int): Int {
        position.sort()

        fun canFit(distance: Int): Boolean {
            var count = 1
            var lastPosition = position[0]

            for (i in 1 until position.size) {
                if (position[i] - lastPosition >= distance) {
                    count++
                    lastPosition = position[i]
                    if (count == m) return true
                }
            }
            return false
        }

        var low = 1
        var high = (position.last() - position.first()) / (m - 1)

        while (low <= high) {
            val mid = (low + high) / 2
            if (canFit(mid)) {
                low = mid + 1
            } else {
                high = mid - 1
            }
        }

        return high
    }
}