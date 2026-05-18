package com.leatcode.t438

import com.leatcode.util.print

fun main() {
    Solution().findAnagrams("cbaebabacd", "abc").print()
}

class Solution {
    fun findAnagrams(s: String, p: String): List<Int> {
        if (p.length > s.length) return emptyList()

        val pFreq = hashMapOf<Char, Int>().apply {
            p.forEach { this[it] = getOrDefault(it, 0) + 1 }
        }
        val curr = hashMapOf<Char, Int>().apply {
            repeat(p.length - 1) { this[s[it]] = getOrDefault(s[it], 0) + 1 }
        }
        val res = mutableListOf<Int>()
        for (i in 0..s.length - p.length) {
            val new = s[i + p.length - 1]
            curr[new] = curr.getOrDefault(new, 0) + 1
            if (pFreq.all { it.value == curr.getOrDefault(it.key, 0) }) res.add(i)
            curr[s[i]] = curr[s[i]]!! - 1
        }
        return res
    }

}