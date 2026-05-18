package com.leetcode.t1167

import java.util.PriorityQueue

class Solution {
    fun connectSticks(sticks: IntArray): Int {
        val heap = PriorityQueue<Int>(sticks.size).apply {
            sticks.forEach { add(it) }
        }

        var s = 0
        while (heap.size > 1) {
            (heap.poll()!! + heap.poll()!!).let {
                s += it
                heap.add(it)
            }
        }
        return s
    }
}