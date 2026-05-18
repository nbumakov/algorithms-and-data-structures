package com.leatcode.t334

import com.leatcode.util.print
import kotlin.random.Random

fun main() {
    Solution().increasingTriplet(intArrayOf(5, 4, 3, 2, 1)).print()
}

class Solution {

    fun increasingTriplet(nums: IntArray): Boolean {
        var ni = Int.MAX_VALUE
        var nj = Int.MAX_VALUE

        nums.forEach {
            when {
                it <= ni -> ni = it
                it <= nj -> nj = it
                else -> return true
            }
        }

        return false
    }
}
