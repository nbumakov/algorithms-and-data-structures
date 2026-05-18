package com.leatcode

import com.leatcode.util.print

fun main() {
    val a = listOf(Test(1))
    val b = a.toMutableList().onEach { it.a = 2 }

    a.forEach { println(it.a) }
    b.forEach { println(it.a) }

    var toCamelCase = false
    val c = "<the>-stealth-warrior".mapNotNull {
        when{
            it.isLetter() && toCamelCase -> {
                toCamelCase = false
                it.uppercaseChar()
            }
            !it.isLetter() ->{
                toCamelCase = true
                null
            }
            else -> it
        }
    }.joinToString("").print()
}

class Test(var a: Int)