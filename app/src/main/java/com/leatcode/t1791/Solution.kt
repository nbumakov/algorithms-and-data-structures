package com.leatcode.t1791

class Solution {
    fun findCenter(edges: Array<IntArray>): Int =
        edges[0].first { it in edges[1] }
}