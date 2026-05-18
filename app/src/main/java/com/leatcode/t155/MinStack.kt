package com.leatcode.t155

import java.util.Stack
import kotlin.math.min

class MinStack() {

    private val stack = Stack<Item>()

    fun push(`val`: Int) {
        stack.push(Item(value = `val`, min = min(getMin(), `val`)))
    }

    fun pop() {
        stack.pop()
    }

    fun top(): Int = stack.peek().value

    fun getMin(): Int = runCatching { stack.peek().min }.getOrDefault(Int.MAX_VALUE)

    class Item(
        val value: Int,
        val min: Int
    )

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */