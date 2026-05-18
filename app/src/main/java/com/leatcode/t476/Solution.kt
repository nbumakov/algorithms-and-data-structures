package com.leatcode.t476

fun main() {
    println(
        31.takeHighestOneBit()
    )
}

// hint how takeHighestOneBit works
// The takeHighestOneBit function returns an integer that has only the highest bit set,
// and all other bits as 0.
// For example:
// val number = 22           // Binary: 10110
// val highestBit = number.takeHighestOneBit()  // Binary: 10000, Decimal: 16
// println(highestBit)       // Output: 16

class Solution {
    fun findComplement(num: Int): Int {
        val mask = (num.takeHighestOneBit() shl 1) - 1
        return num xor mask
    }
}