package com.leetcode.t880

import com.leetcode.util.print

fun main() {
    Solution().decodeAtIndex("leet2code3", 10).print()
    Solution().decodeAtIndex("a2345678999999999999999", 1).print()
}

class Solution {

    // leet2code3 leetleetcodeleetleetcodeleetleetcode
    fun decodeAtIndex(s: String, k: Int): String {
        var size = 0L
        s.forEach { if (it.isLetter()) size++ else size *= it.digitToInt() }

        var curr = k.toLong()
        for (i in s.lastIndex downTo 0) {
            curr %= size
            if (curr == 0L && s[i].isLetter()) return s[i].toString()
            if (s[i].isDigit()) {
                val digit = s[i].digitToInt()
                size /= digit
            } else {
                size--
            }
        }
        throw IllegalStateException()
    }
}