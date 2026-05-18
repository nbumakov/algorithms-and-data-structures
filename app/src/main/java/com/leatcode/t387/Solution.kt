package com.leatcode.t387

class Solution {
    fun firstUniqChar(s: String): Int {
        val counterMap = hashMapOf<Char, Int>()
        s.forEachIndexed { index, c ->
            counterMap[c] = counterMap.getOrDefault(c, 0) + 1
        }

        s.forEachIndexed { index, c ->
            if (counterMap[c] == 1) return index
        }

        return -1
    }
}