package com.leetcode.t735

import com.leetcode.util.print
import java.util.Stack

fun main() {
    Solution().asteroidCollision(intArrayOf(-2, -2, 1, -1)).print()
}

class Solution {
    fun asteroidCollision(asteroids: IntArray): IntArray = with(Stack<Int>()) {
        for (a in asteroids) {
            if (isEmpty() || a >= 0 || peek() < 0) {
                push(a)
            } else {
                var last: Int? = null
                while (isNotEmpty() && peek() > 0 && peek() <= -a) pop().also { last = it }
                if (last != -a) {
                    if (isEmpty() || isNotEmpty() && peek() < 0) push(a)
                }
            }
        }

        return@with toIntArray()
    }
}