package com.leatcode.t374

import com.leatcode.util.print

/**
 * The API guess is defined in the parent class.
 * @param  num   your guess
 * @return         -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * fun guess(num:Int):Int {}
 */
fun main() {

    Solution().guessNumber(100).print()
}

class Solution : GuessGame() {
    override fun guessNumber(n: Int): Int {
        var lo = 1
        var hi = n
        while (lo < hi) {
            val mid = lo + (hi - lo) / 2
            when (guess(mid)) {
                -1 -> hi = mid - 1
                1 -> lo = mid + 1
                else -> return mid
            }
        }

        return lo
    }
}

open class GuessGame {
    val n = 25

    open fun guessNumber(n: Int): Int {
        TODO()
    }

    fun guess(num: Int): Int = n.compareTo(num)
}