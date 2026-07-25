package com.leetcode.t3536

import java.util.PriorityQueue

class Solution {
    fun maxProduct(n: Int): Int {
        val heap = PriorityQueue<Int>()
        var x = n
        while (x > 0) {
            heap.add(x % 10)
            x /= 10
            if(heap.size > 2) heap.poll()
        }

        return heap.poll() * heap.poll()
    }
}