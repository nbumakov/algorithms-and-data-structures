package com.leatcode.t1945

fun main() {
    Solution().getLucky("iiii", 1)
        .let(::println)
}

class Solution {
    fun getLucky(s: String, k: Int): Int {
        var result = s.convert()
        repeat(k) {
            result = result.transform()
        }
        return result.toInt()
    }

    private fun String.convert(): String = toCharArray()
        .joinToString("") { (it - 'a' + 1).toString() }

    private fun String.transform(): String =
        toString().sumOf { it - '0' }
            .toString()
}