package com.coderun.t59

import java.util.Scanner

fun main() {
    val input = Scanner(System.`in`).useDelimiter("\\s+")
    val words = mutableSetOf<String>()

    while (input.hasNext()) {
        words.add(input.next())
    }

    println(words.size)
}