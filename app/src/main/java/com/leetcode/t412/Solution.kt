package com.leetcode.t412

class Solution {
    fun fizzBuzz(n: Int): List<String> = List(n) {
        val i = it + 1
        when {
            i % 15 == 0 -> "FizzBuzz"
            i % 3 == 0 -> "Fizz"
            i % 5 == 0 -> "Buzz"
            else -> i.toString()
        }
    }

    fun fizzBuzz2(n: Int): List<String> = ArrayList<String>(n).apply {
        val sb = StringBuilder()
        for (i in 1..n) {
            if (i % 3 == 0) {
                sb.append("Fizz")
            }
            if (i % 5 == 0) {
                sb.append("Buzz")
            }
            if (sb.isEmpty()) {
                sb.append(i)
            }
            add(sb.toString())
            sb.clear()
        }
    }
}