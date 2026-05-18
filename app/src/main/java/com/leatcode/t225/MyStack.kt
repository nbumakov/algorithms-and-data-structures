package com.leatcode.t225

import java.util.LinkedList
import java.util.Queue


class MyStack() : Queue<Int> by LinkedList() {

    fun push(x: Int) {
        add(x)
        repeat(size - 1) { add(remove()) }
    }

    fun pop(): Int = remove()

    fun top(): Int = first()

    fun empty(): Boolean = isEmpty()

}