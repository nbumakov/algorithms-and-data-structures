package com.leetcode.t2710

import com.leetcode.util.print

fun main() {
    Solution().removeTrailingZeros("0000").print()
}

class Solution {
    fun removeTrailingZeros(num: String): String {
        if (num.last() != '0') {
            return num
        }
        var i = num.lastIndex
        while (i >= 0 && num[i] == '0') {
            i--
        }
        return num.substring(0..i)
    }
}