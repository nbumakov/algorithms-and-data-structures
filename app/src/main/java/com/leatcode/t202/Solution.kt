package com.leatcode.t202

import com.leatcode.util.print

fun main() {
    Solution().isHappy(2).print()
}

class Solution {
    fun isHappy(n: Int): Boolean {
        val set = hashSetOf<Int>()
        var x = n
        while (x != 1 && !set.contains(x)) {
            set.add(x)
            x = x.square()
        }
        return x == 1
    }

    private fun Int.square(): Int {
        var n = this
        var result = 0
        while (n > 0) {
            result += (n % 10).let { it * it }
            n /= 10
        }
        return result
    }
}