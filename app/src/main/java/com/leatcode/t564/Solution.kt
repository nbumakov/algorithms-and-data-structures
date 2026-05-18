package com.leatcode.t564

import kotlin.math.abs

class Solution {
    fun nearestPalindromic(n: String): String {
        val half = n.take((n.length + 1) / 2)

        // This creates a palindrome by appending the reverse of half to itself,
        // possibly excluding the middle digit if n has an odd length. For example, if half = "123", then a = "12321".
        val a = half + half.reversed().drop(n.length % 2)

        // Generating Nearby Palindromes:
        // These two lines create palindromes by adjusting half up or down by 1
        // and then creating palindromes in the same way as a.
        // For instance, if half = "123", then b might be "12221" and c might be "12421".
        val b = (half.toInt() - 1).toString().let { it + it.reversed().drop(n.length % 2) }
        val c = (half.toInt() + 1).toString().let { it + it.reversed().drop(n.length % 2) }

        // Adding Edge Cases
        // handles the case where the nearest palindrome is a string of 9s (e.g., "999" for n = "1000")
        val d = "0" + "9".repeat(n.length - 1)

        // handles cases like "1001" for n = "999".
        val e = "1" + "0".repeat(n.length - 1) + "1"

        //This line filters out the original number (since it should not be considered as a nearest palindrome),
        // converts the remaining strings to longs,
        // and finds the one that has the smallest difference from n.
        // If there's a tie, it chooses the smaller palindrome.
        return listOf(a, b, c, d, e)
            .filter { it != n }
            .map { it.toLong() }
            .minWith(compareBy({ abs(it - n.toLong()) }, { it }))
            .toString()
    }
}