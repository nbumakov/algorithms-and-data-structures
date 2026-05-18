package com.leetcode.t232

import com.leetcode.util.print

fun main() {
    MyQueue2().apply {
        for (i in 0..3) push(i)
        while (!empty()){
            pop().print()
        }
    }
}

// O(1)
class MyQueue2() {

    private val stack = ArrayDeque<Int>()
    private val stack2 = ArrayDeque<Int>()

    fun push(x: Int) {
        stack.add(x)
    }

    fun pop(): Int {
        fillStack2IfNeeded()
        return stack2.removeLast()
    }

    fun peek(): Int {
        fillStack2IfNeeded()
        return stack2.last()
    }

    fun empty(): Boolean = stack.isEmpty() && stack2.isEmpty()

    private fun fillStack2IfNeeded() {
        if (stack2.isEmpty()) {
            while (stack.isNotEmpty()) {
                stack2.add(stack.removeLast())
            }
        }
    }
}

// O(n)
class MyQueue() {

    private val stack = ArrayDeque<Int>()

    fun push(x: Int) {
        val tempStack = ArrayDeque<Int>()
        while (stack.isNotEmpty()) {
            tempStack.add(stack.removeLast())
        }
        stack.add(x)
        while (tempStack.isNotEmpty()) {
            stack.add(tempStack.removeLast())
        }
    }

    fun pop(): Int = stack.removeLast()

    fun peek(): Int = stack.last()

    fun empty(): Boolean = stack.isEmpty()

}