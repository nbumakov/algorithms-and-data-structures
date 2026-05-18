package com.leetcode.t340

class Solution {
    fun lengthOfLongestSubstringKDistinct(s: String, k: Int): Int {
        if (k == 0) return 0

        val qtyMap = hashMapOf<Char, Int>()
        var p1 = 0
        var p2 = 0
        var maxLength = 0
        var uniqChars = 0

        while (p2 < s.length) {
            val newChar = s[p2++]
            qtyMap[newChar] = qtyMap.getOrDefault(newChar, 0) + 1
            if (qtyMap[newChar]!! == 1) uniqChars++

            while (uniqChars > k) {
                val oldChar = s[p1++]
                qtyMap[oldChar] = qtyMap[oldChar]!! - 1
                if (qtyMap[oldChar]!! == 0) uniqChars--
            }
            maxLength = maxOf(maxLength, p2 - p1)
        }

        return maxLength
    }
}