package com.leetcode.t1201

import java.util.PriorityQueue

fun main() {
    val result = Solution().nthUglyNumber(5, 2, 11, 13)
    println("Result: $result")
}
class Solution {
    fun nthUglyNumber(n: Int, a: Int, b: Int, c: Int): Int {
        val factors = setOf(a, b, c)
        val seenNumbers = mutableSetOf<Long>().apply { add(1) }
        val heap = PriorityQueue<Long>().apply { add(1) }
        repeat(n-1){
            val min = heap.poll()!!
            factors.map { it * min }
                .filter { it !in seenNumbers }
                .run {
                    heap.addAll(this)
                    seenNumbers.addAll(this)
                }
        }
        return heap.peek()!!.toInt()
    }
}