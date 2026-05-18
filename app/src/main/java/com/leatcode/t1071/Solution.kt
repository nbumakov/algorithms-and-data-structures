package com.leatcode.t1071

class Solution {

    fun gcdOfStrings(str1: String, str2: String): String {
        if (str1 + str2 != str2 + str1) return ""

        return str1.substring(0, gcd(str1.length, str2.length))
    }

    private fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}