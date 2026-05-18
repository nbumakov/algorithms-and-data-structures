package com.leatcode.t70

import com.leatcode.util.print

fun main() {
    Solution().climbStairs(30).print()
}

class Solution {

    private val cachedClimb = { n: Int -> climb(n) }.cached(1 to 1, 2 to 2)

    fun climbStairs(n: Int): Int = cachedClimb(n)

    private fun climb(n: Int): Int = cachedClimb(n - 1) + cachedClimb(n - 2)

    private class Cache<in T, out R>(val f: (T) -> R, vararg initPairs: Pair<T, R>) : (T) -> R {
        private val values = hashMapOf(*initPairs)
        override fun invoke(x: T): R = values.getOrPut(x) { f(x) }
    }

    private fun <T, R> ((T) -> R).cached(vararg initPairs: Pair<T, R>): (T) -> R = Cache(this, *initPairs)

}