package com.leatcode.t383

class Solution {

    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val sortedMagazine = magazine.toCharArray().apply { sort() }
        val sortedRansomNote = magazine.toCharArray().apply { sort() }
        var p = 0
        for (c in sortedRansomNote) {
            while (p <= sortedMagazine.lastIndex && sortedMagazine[p] != c) p++
            if (p > sortedMagazine.lastIndex) return false else p++
        }
        return true
    }

    // count
    fun canConstruct1(ransomNote: String, magazine: String): Boolean {
        val counter = hashMapOf<Char, Int>()
        magazine.forEach { counter[it] = counter.getOrDefault(it, 0) + 1 }

        return ransomNote.groupBy { it }.all { it.value.size <= counter.getOrDefault(it.key, 0) }
    }
}