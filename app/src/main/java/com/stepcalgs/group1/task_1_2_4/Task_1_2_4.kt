package com.example.stepcalgs.group1.task_1_2_4

import java.lang.Integer.max
import java.util.*

fun main() {
    val q = readLine()!!.toInt()
    val stack = StackWithMax()

    repeat(q) {
        val args = readLine()!!.split(" ")
        val command = args[0]
        val value = args.getOrNull(1)
        when (command) {
            "max" -> println(stack.max)
            "pop" -> stack.pop()
            "push" -> stack.push(value!!.toInt())
        }
    }
}

class StackWithMax {

    private val stack = LinkedList<Item>()

    val max get() = stack.peek()?.max ?: 0

    fun push(value: Int) {
        val max = max(max, value)
        stack.push(Item(value, max))
    }

    fun pop(): Int? =
        runCatching { stack.pop().value }.getOrNull()

    data class Item(
        val value: Int,
        val max: Int,
    )

}
