package com.leatcode.t319

import com.leatcode.util.print
import kotlin.math.sqrt

fun main() {
//    Solution().bulbSwitch(3).print()
//    Solution().bulbSwitch(4).print()
    Solution().bulbSwitch(5).print()
//    Solution().bulbSwitch(6).print()
}

class Solution {

    // 0 0 0 0 0
    // 1 1 1 1 1 1  1 = n
    // 1 0 1 0 1 0  1 = n / 2
    // 1 0 0 0 1 1  1 = n / 3
    // 1 0 0 1 1 1  2 = n / 2
    // 1 0 0 1 0 1  2
    // 1 0 0 1 0 0  3
    fun bulbSwitch(n: Int): Int = sqrt(n.toDouble()).toInt()

}