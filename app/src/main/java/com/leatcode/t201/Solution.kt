package com.leatcode.t201

import com.leatcode.util.print

fun main() {
    Solution().rangeBitwiseAnd(2147483646, 2147483647).print()
}

class Solution {
    fun rangeBitwiseAnd(left: Int, right: Int): Int {
        if (0 in left..right) return 0
        if (left == Int.MAX_VALUE) return Int.MAX_VALUE

        var p = left + 1
        var res = left

        while (res != 0 && p <= right) {
            res = res and p
            if (p == Int.MAX_VALUE) break else p++
        }

        return res
    }
}