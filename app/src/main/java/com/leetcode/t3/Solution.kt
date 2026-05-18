package com.leetcode.t3

import com.leetcode.util.print

fun main() {
    Solution().lengthOfLongestSubstring("").print()
}

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var length = 0
        var l = 0
        val set = hashSetOf<Char>()

        for (r in 0..s.lastIndex) {
            while (set.contains(s[r])) set.remove(s[l++])
            set.add(s[r])
            length = maxOf(length, r - l + 1)
        }

        return length
    }
}