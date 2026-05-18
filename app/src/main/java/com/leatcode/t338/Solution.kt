package com.leatcode.t338

class Solution {
    fun countBits(n: Int): IntArray = IntArray(n + 1) {
        it.bitCount()
    }

    private fun Int.bitCount(): Int {
        var x = this
        var count = 0
        while (x != 0) {
            x = x and (x - 1)
            count++
        }
        return count
    }
}