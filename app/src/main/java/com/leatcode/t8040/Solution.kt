package com.leatcode.t8040

import com.leatcode.util.print

fun main() {
//    Solution().minimumOperations("2245047").print()
    Solution().minimumOperations("1").print()
}

class Solution {
    fun minimumOperations(num: String): Int {

        fun removeSymbolsCount(sub: List<Char>): Int {
            var index = num.length
            sub.reversed().forEach { char ->
                if (index >= 0) {
                    index = num.substring(0, index).indexOfLast { it == char }
                }
            }
            // 12235
            return if (index >= 0) num.length - (index + 2) else num.length
        }

        return minOf(
            num.count { it != '0' },
            removeSymbolsCount(listOf('0', '0')),
            removeSymbolsCount(listOf('2', '5')),
            removeSymbolsCount(listOf('5', '0')),
            removeSymbolsCount(listOf('7', '5')),
        )
    }

}