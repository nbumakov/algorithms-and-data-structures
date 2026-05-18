package com.leetcode.t461

class Solution {
    fun hammingDistance(x: Int, y: Int): Int =
        (x xor y).countOneBits()
}