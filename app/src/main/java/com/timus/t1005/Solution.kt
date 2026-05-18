package com.timus.t1005

import java.util.Stack
import kotlin.math.abs

// Brut force
fun main() {
    readLine()
    val stones = readLine()!!.split(' ').map(String::toInt)

    fun dp(left: Int, right: Int, stones: Stack<Int>): Int {
        if (stones.isEmpty()) return abs(right - left)

        val stone = stones.pop()!!
        return minOf(dp(left + stone, right, stones), dp(left, right + stone, stones))
            .also { stones.push(stone) }
    }

    println(dp(0, 0, Stack<Int>().apply { addAll(stones) }))
}


