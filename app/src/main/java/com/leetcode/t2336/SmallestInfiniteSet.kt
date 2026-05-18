package com.leetcode.t2336

import java.util.PriorityQueue

class SmallestInfiniteSet() {

    private var heap = PriorityQueue<Int>()
    private var curr = 1

    fun popSmallest(): Int =
        if (heap.isEmpty()) curr++ else heap.poll()!!

    fun addBack(num: Int) {
        if(num >= curr) return
        if (!heap.contains(num)) {
            heap.add(num)
        }
    }

}