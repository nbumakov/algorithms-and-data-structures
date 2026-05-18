package com.leetcode.t2433

import com.leetcode.util.print

fun main() {
    println(5 xor 0)
//    println(5 xor 7 xor 2)
//    println(5 xor 7 xor 2 xor 3)
//    println(5 xor 7 xor 2 xor 3 xor 2)
    Solution().findArray(intArrayOf(5, 2, 0, 3, 1)).print()
}

class Solution {

    fun findArray(pref: IntArray): IntArray =
        IntArray(pref.size) { pref[it] xor pref.getOrElse(it - 1) { 0 } }

    fun findArray2(pref: IntArray): IntArray {
        var xor = pref[0]
        val result = IntArray(pref.size).apply { this[0] = xor }
        for (i in 1..pref.lastIndex) {
            result[i] = (pref[i] or xor) and (pref[i] and xor).inv() // dumb xor reverse
            xor = xor xor result[i]
        }
        return result
    }
}