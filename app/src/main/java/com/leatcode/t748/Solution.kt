package com.leatcode.t748

import com.leatcode.util.print
import java.lang.IllegalArgumentException

fun main() {
//    val map = hashMapOf('a' to 1)
//    val map2 = map.toMutableMap()
//    map2['a'] = 2
//
//    println(map['a'])

    Solution()
        .shortestCompletingWord("1s3 PSt", arrayOf("step", "steps", "stripe", "stepple"))
        .print()
}


class Solution {
    fun shortestCompletingWord(licensePlate: String, words: Array<String>): String {
        val map = hashMapOf<Char, Int>()
        licensePlate.lowercase().asSequence()
            .filter { it.isLetter() }
            .forEach { map[it] = map.getOrDefault(it, 0) + 1 }

        words.sortBy { it.length }
        words.forEach { w ->
            val currMap = map.toMutableMap()
            w.forEach { currMap[it] = currMap.getOrDefault(it, 0) - 1 }
            if (currMap.values.all { it <= 0 }) return w
        }
        throw IllegalArgumentException()
    }
}