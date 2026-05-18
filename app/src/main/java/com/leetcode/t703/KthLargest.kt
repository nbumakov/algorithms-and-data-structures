package com.leetcode.t703

import java.util.PriorityQueue

class KthLargest(val k: Int, nums: IntArray) {

    private val heap = PriorityQueue<Int>()

    init {
        nums.forEach(::add)
    }

    fun add(`val`: Int): Int = with(heap) {
        add(`val`); if (size > k) remove()
        peek()!!
    }

}