package com.leetcode.t1318

fun main() {
    val a = 1
    val b = 2
    val c = 5
    println((a or b xor c).countOneBits())
}

class Solution {
    fun minFlips(a: Int, b: Int, c: Int): Int {
        val wrongBits = a or b xor c
        val doubleFlip = a and b and c.inv()
        return wrongBits.countOneBits() + doubleFlip.countOneBits()
    }

    fun minFlips2(a: Int, b: Int, c: Int): Int {
        var a = a
        var b = b
        var c = c
        var answer = 0
        while ((a != 0) or (b != 0) or (c != 0)) {
            if (c and 1 == 1) {
                if (a and 1 == 0 && b and 1 == 0) {
                    answer++
                }
            } else {
                answer += (a and 1) + (b and 1)
            }
            a = a shr 1
            b = b shr 1
            c = c shr 1
        }
        return answer
    }

}