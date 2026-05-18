package com.leetcode.t443

import com.leetcode.util.print

fun main() {
    val a = charArrayOf('a', 'a', 'b', 'b', 'c', 'c', 'c')
    Solution().compress(a).print()
    a.joinToString().print()
}

class Solution {
    fun compress(chars: CharArray): Int {
        var current = chars[0]
        var count = 1
        var p1 = 0
        var p2 = 1

        fun compressCurrentChar(){
            val sb = StringBuilder()
            sb.append(current)
            if (count > 1) {
                sb.append(count.toString())
            }
            sb.forEach { c -> chars[p1++] = c }
        }

        while (p2 <= chars.lastIndex) {
            if (current == chars[p2]) {
                p2++
                count++
            } else {
                compressCurrentChar()
                current = chars[p2++]
                count = 1
            }
        }
        compressCurrentChar()
        return p1
    }
}