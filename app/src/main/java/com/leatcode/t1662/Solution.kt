package com.leatcode.t1662

import com.leatcode.util.print

fun main() {
    Solution().arrayStringsAreEqual(
        arrayOf("a", "cb"),
        arrayOf("ab", "c")
    ).print()
}

class Solution {

    fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
        var i1 = 0
        var j1 = 0
        var i2 = 0
        var j2 = 0

        while (i1 < word1.size && i2 < word2.size) {
            val c1 = word1.getOrNull(i1)?.getOrNull(j1)
            val c2 = word2.getOrNull(i2)?.getOrNull(j2)
            if (c1 != c2) return false

            if (j1 < word1[i1].lastIndex) {
                j1++
            } else {
                i1++
                j1 = 0
            }

            if (j2 < word2[i2].lastIndex) {
                j2++
            } else {
                i2++
                j2 = 0
            }
        }

        return j1 == 0 && j2 == 0
    }

    fun arrayStringsAreEqual2(word1: Array<String>, word2: Array<String>): Boolean {
        val iterator = sequence { word1.forEach { yieldAll(it.asIterable()) } }.iterator()

        return word2.all { w -> w.all { c -> iterator.hasNext() && c == iterator.next() } } && !iterator.hasNext()
    }

    fun arrayStringsAreEqual1(word1: Array<String>, word2: Array<String>): Boolean =
        word1.joinToString("") == word2.joinToString("")
}