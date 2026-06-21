package com.leetcode.t1833

/**
 * LeetCode 1833 - Maximum Ice Cream Bars.
 *
 * Given ice cream [costs] and a budget of [coins], return the maximum number of
 * bars buyable. Greedy: buy from cheapest to most expensive. Because prices are
 * small (1..1e5), both solutions sort via counting instead of comparison.
 *
 * - [Solution]  : counting sort -> linear greedy scan. Time O(n + max), space O(max).
 * - [Solution2] : same idea fused into one pass over the count array, no output buffer.
 */
class Solution {
    fun maxIceCream(costs: IntArray, coins: Int): Int {
        val costs = countingSort(costs)
        var coins = coins
        var result = 0
        for (cost in costs) {
            if (coins >= cost) {
                result++
                coins -= cost
            } else {
                break
            }
        }
        return result
    }

    fun countingSort(arr: IntArray): IntArray {
        val max = arr.max()
        val count = IntArray(max + 1)
        for (x in arr) count[x]++

        val result = IntArray(arr.size)
        var i = 0
        for (x in 0..max) {
            repeat(count[x]) { result[i++] = x }
        }
        return result
    }
}

class Solution2 {
    fun maxIceCream(costs: IntArray, coins: Int): Int {
        val max = costs.max()
        val count = IntArray(max + 1)
        for (x in costs) count[x]++

        var coins = coins
        return (1..max).sumOf { x ->
            count[x].coerceAtMost(coins / x)
                .also { coins -= it * x }
        }
    }

}