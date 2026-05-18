package com.leetcode.t901

import com.leetcode.util.print
import java.util.Stack

fun main() {
    with(StockSpanner()) {
        next(100).print()
        next(80).print()
        next(60).print()
        next(70).print()
        next(60).print()
        next(75).print()
        next(85).print()
    }
}

class StockSpanner() {

    private val stack = Stack<Pair<Int, Int>>()

    fun next(price: Int): Int = with(stack) {
        var count = 0
        while (stack.isNotEmpty() && stack.peek().first <= price){
            count += stack.pop().second
        }

        val current = price to count + 1
        push(current)
        current.second
    }

}
