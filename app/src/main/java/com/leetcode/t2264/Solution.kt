package com.leetcode.t2264

class Solution {

    fun largestGoodInteger2(num: String): String =
        listOf("999", "888", "777", "666", "555", "444", "333", "222", "111", "000")
            .firstOrNull { it in num } ?: ""

    fun largestGoodInteger(num: String): String =
        num.windowed(3)
            .filter { it[0] == it[1] && it[0] == it[2] }
            .maxByOrNull { it[0] } ?: ""
}