package com.leetcode.t1291

import kotlin.toString

class Solution {
    fun sequentialDigits(low: Int, high: Int): List<Int> =
        (low.toString().length..high.toString().length)
            .flatMap { PATTERN.windowed(it) }
            .map { it.toInt() }
            .filter { it in low..high }

    companion object {
        const val PATTERN = "123456789"
    }
}

class Solution2 {
    fun sequentialDigits(low: Int, high: Int): List<Int> =
        (low.toString().length..high.toString().length).asSequence()
            .flatMap { PATTERN.windowed(it).asSequence() }
            .map { it.toInt() }
            .filter { it in low..high }
            .toList()

    companion object {
        const val PATTERN = "123456789"
    }
}