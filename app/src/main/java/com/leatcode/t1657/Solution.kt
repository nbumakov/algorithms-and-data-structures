package com.leatcode.t1657

import com.leatcode.util.print

fun main() {
    Solution().closeStrings("cabbba", "abbccc").print()
}

class Solution {
    fun closeStrings(word1: String, word2: String): Boolean {
        if (word1.length != word2.length) return false

        val map1 = word1.toCharQtyMap()
        val map2 = word2.toCharQtyMap()

        return map1.values.sorted() == map2.values.sorted() && map1.keys == map2.keys
    }

    private fun String.toCharQtyMap() =
        hashMapOf<Char, Int>().apply {
            this@toCharQtyMap.forEach {
                this[it] = this.getOrDefault(it, 0) + 1
            }
        }
}