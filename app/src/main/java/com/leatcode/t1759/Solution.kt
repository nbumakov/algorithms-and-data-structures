package com.leatcode.t1759

import com.leatcode.util.print

fun main() {
    Solution().countHomogenous("abbcccaa").print()
    "abbcccaa".groupBy { it }.forEach { (_, u) ->
        u.size.print()
    }
}

class Solution {

    // abbcccaa   c t
    // a          1 1
    //  b         1 2
    //   b        2 4
    //    c       1 5
    //     c      2 7
    //      c     3 10
    //       a    1 11
    //        a   2 13
    fun countHomogenous(s: String): Int {
        var count = 0
        var prev = '.'
        var res = 0
        for (c in s) {
            if (c == prev) count++ else count = 1
            res = (res + count) % Mod
            prev = c
        }
        return res
    }

    companion object {
        const val Mod = 1_000_000_007
    }
}