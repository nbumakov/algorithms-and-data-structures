package com.leetcode.t28

import com.leetcode.util.print

fun main(){
    Solution().strStr("sadbutsadt", "sadt").print()
}

class Solution {
    fun strStr(haystack: String, needle: String): Int {
        for (i in 0 .. haystack.length - needle.length) {
            for (j in needle.indices) {
                if (haystack[i + j] != needle[j]) break
                if (j == needle.lastIndex) return i
            }
        }
        return -1
    }
}