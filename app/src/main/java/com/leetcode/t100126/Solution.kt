package com.leetcode.t100126

import com.leetcode.util.print

fun main() {
    Solution().stringCount(4).print()
    Solution().stringCount(10).print()
}

class Solution {

    fun stringCount(n: Int): Int {
        var leet = 0L
        var (lee, let, eet) = listOf(0L, 0L, 0L)
        var (le, ee, lt, et) = listOf(0L, 0L, 0L, 0L)
        var (l, e, t) = listOf(0L, 0L, 0L)
        var everything = 1L

        repeat(n) {
            leet = (lee + let + eet + 23 * leet) % Mod
            lee = (le + ee + 24 * lee) % Mod
            let = (le + lt + et + 23 * let) % Mod
            eet = (ee + et + 24 * eet) % Mod
            le = (l + e + 24 * le) % Mod
            ee = (e + 25 * ee) % Mod
            lt = (l + t + 24 * lt) % Mod
            et = (e + t + 24 * et) % Mod
            ((everything + 25 * l) % Mod).run {
                l = this
                e = this
                t = this
            }
            everything = (everything * 26) % Mod

        }
        return leet.toInt()
    }

    companion object {
        const val Mod = 1_000_000_007
    }
}