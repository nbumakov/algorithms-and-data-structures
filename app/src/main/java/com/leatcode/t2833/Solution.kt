package com.leatcode.t2833

class Solution {
    fun furthestDistanceFromOrigin(moves: String): Int {
        val l = moves.count { it == 'L' }
        val r = moves.count { it == 'R' }
        val spaces = moves.length - l - r
        return maxOf(l, r) + spaces - minOf(l, r)
    }
}