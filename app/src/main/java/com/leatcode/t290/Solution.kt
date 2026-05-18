package com.leatcode.t290

import com.leatcode.util.print

fun main() {
//    Solution().wordPattern("abba", "dog cat cat dog").print()
//    Solution().wordPattern("abba", "dog cat cat fish").print()
//    Solution().wordPattern("aaaa", "dog cat cat dog").print()
    Solution().wordPattern("abba", "dog dog dog dog").print()
}

class Solution {

    fun wordPattern(pattern: String, s: String): Boolean {
        val bijection1 = hashMapOf<Char, String>()
        val bijection2 = hashMapOf<String, Char>()
        val chars = pattern.toList()
        val words = s.split(" ")
        return chars.size == words.size && pattern.toList().zip(s.split(" "))
            .all { (char, word) -> bijection1.getOrPut(char) { word } == word && bijection2.getOrPut(word) { char } == char }
    }
}