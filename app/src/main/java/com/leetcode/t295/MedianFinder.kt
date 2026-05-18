package com.leetcode.t295

import com.leetcode.util.print
import java.util.PriorityQueue

fun main() {
    MedianFinder().apply {
        addNum(-1)
        addNum(-2)
        addNum(-3)
        findMedian().print()
    }
}

class MedianFinder() {

    private val bigHeap = PriorityQueue<Int>()
    private val smallHeap = PriorityQueue<Int>(reverseOrder())

    fun addNum(num: Int) {
        if (smallHeap.size == bigHeap.size) {
            smallHeap.add(num)
            bigHeap.add(smallHeap.poll()!!)
        } else {
            bigHeap.add(num)
            smallHeap.add(bigHeap.poll()!!)
        }
    }

    fun findMedian(): Double =
        if (bigHeap.size == smallHeap.size) {
            (bigHeap.peek()!! + smallHeap.peek()!!) * 0.5
        } else {
            bigHeap.peek()!!.toDouble()
        }
}

class MedianFinder_ArrayList() {

    private val list = ArrayList<Int>()

    fun addNum(num: Int) {
        var index = list.binarySearch(num)
        if (index < 0) {
            index = -index - 1
        }
        list.add(index, num)
    }

    fun findMedian(): Double =
        if (list.size % 2 == 0) {
            (list[list.size / 2] + list[list.size / 2 + 1]) * 0.5
        } else {
            list[list.size / 2].toDouble()
        }
}