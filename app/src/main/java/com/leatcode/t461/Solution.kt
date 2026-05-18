package com.leatcode.t461

class Solution {
    fun hammingDistance(x: Int, y: Int): Int =
        (x xor y).countOneBits()
}