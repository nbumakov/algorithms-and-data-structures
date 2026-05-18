package com.leatcode.t1160

class Solution {
    fun countCharacters(words: Array<String>, chars: String): Int {
        val map = hashMapOf<Char, Int>().apply {
            chars.forEach { this[it] = getOrDefault(it, 0) + 1 }
        }

        return words.filter { word ->
            word.groupBy { it }.all { it.value.size <= map.getOrDefault(it.key, 0) }
        }.sumOf { it.length }
    }
}