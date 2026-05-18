package com.leatcode.t190

import com.leatcode.util.print

fun main() {
    Solution().reverseBits(10).print()
}

class Solution {
    // you need treat n as an unsigned value
    fun reverseBits(n: Int): Int {
        var result = 0
        var x = n
        repeat(32) {
            val bit = x and 1
            x = x ushr 1
            result = ( result shl 1) or bit
        }
        return result
    }
}