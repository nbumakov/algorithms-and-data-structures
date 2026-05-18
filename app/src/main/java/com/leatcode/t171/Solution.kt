package com.leatcode.t171

import com.leatcode.util.print

fun main() {
    Solution().titleToNumber("AB").print()
}

class Solution {

    fun titleToNumber(columnTitle: String): Int =
        columnTitle.fold(0) { acc, c -> 26 * acc + c.int() }

    private fun Char.int() = toInt() - 'A'.toInt() + 1
}