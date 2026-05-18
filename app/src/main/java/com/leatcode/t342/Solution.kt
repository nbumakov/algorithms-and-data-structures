package com.leatcode.t342

import kotlin.math.log
import kotlin.math.log10


fun main() {
    println(0b100)
    println(0b10000)
    println(0b1000000)
//    Solution().isPowerOfFour2(123)
}

class Solution {

    fun isPowerOfFour_Log(n: Int): Boolean =
        log(n.toDouble(), 4.0) % 1 == 0.0


    fun isPowerOfFour(n: Int): Boolean =
        n.countOneBits() == 1 && n.countTrailingZeroBits() % 2 == 0

    fun isPowerOfFour_Stupid(n: Int): Boolean {
        if (n <= 0) return false
        var x = n
        while (x != 1) {
            if (x % 4 != 0) return false
            x /= 4
        }
        return true
    }
}