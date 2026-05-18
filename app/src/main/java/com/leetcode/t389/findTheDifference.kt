package com.leetcode.t389

import java.lang.IllegalStateException

class Solution {

    // Approach 3: Bit Manipulation
    fun findTheDifference2(s: String, t: String): Char =
        (s + t).fold(0) { acc, c -> acc xor c.code }.toChar()

    // Using HashMap
    fun findTheDifference(s: String, t: String): Char {
        val map = hashMapOf<Char, Int>()
        s.forEach { map[it] = map.getOrDefault(it, 0) + 1 }
        t.forEach {
            map[it] = map.getOrDefault(it, 0) - 1
            if (map[it] == -1) return it
        }
        throw IllegalStateException()
    }
}