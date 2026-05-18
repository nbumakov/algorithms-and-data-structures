package com.leatcode.t1903

class Solution {
    fun largestOddNumber(num: String): String =
        num.indexOfLast { it in Odds }
            .takeIf { it >= 0 }
            ?.let { num.substring(0..it) }
            ?: ""

    companion object {
        val Odds = setOf('1', '3', '5', '7', '9')
    }
}