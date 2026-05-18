package com.leetcode.t933

import java.util.LinkedList

class RecentCounter() {

    private val queue = LinkedList<Int>()

    fun ping(t: Int): Int {
        queue.add(t)
        while (queue.peek()!! < t - 3000) queue.pop()
        return queue.size
    }

}