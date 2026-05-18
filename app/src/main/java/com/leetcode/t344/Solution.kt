package com.leetcode.t344

import com.leetcode.util.print

fun main() {
    Solution().reverseStringRec("String").print()
}

class Solution {

    fun reverseStringRec(s: String): String {
        if (s.length == 1) return s

        return reverseStringRec(s.substring(1)) + s[0]
    }

    fun reverseString(s: CharArray) {
        //s.reverse()
        var l = 0
        var r = s.lastIndex
        while (l < r) {
            val temp = s[l]
            s[l] = s[r]
            s[r] = temp
            l++
            r--
        }
    }

    fun reverseStringRec(s: CharArray) =
        reverse(s, 0, s.lastIndex)

    private tailrec fun reverse(s: CharArray, start: Int, end: Int) {
        if (start > end) return
        val temp = s[start]
        s[start] = s[end]
        s[end] = temp
        reverse(s, start + 1, end - 1)
    }

}