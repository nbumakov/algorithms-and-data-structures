package com.leetcode.t1475

import com.leetcode.util.print

class Solution {
    fun finalPrices(prices: IntArray): IntArray {
        val previous = mutableSetOf<Int>()
        for (i in prices.indices) {
            val it = previous.iterator()
            while (it.hasNext()) {
                val j = it.next()
                if (prices[j] >= prices[i]) {
                    prices[j] -= prices[i]
                    it.remove()   // удаляем через итератор, а не через коллекцию
                }
            }
            previous.add(i)
        }

        return prices
    }
}

/**
 * Монотонный стек: индексы хранятся так, что цены по стеку не возрастают.
 * Каждый индекс кладётся и снимается ровно один раз → O(n) по времени, O(n) по памяти.
 * Массив меняется на месте (как и в Solution).
 */
class Solution2 {
    fun finalPrices(prices: IntArray): IntArray {
        val stack = ArrayDeque<Int>() // индексы «неразрешённых» товаров, цены по невозрастанию
        for (i in prices.indices) {
            // i — первый более поздний товар с ценой <= цены товара на вершине → даём скидку
            while (stack.isNotEmpty() && prices[stack.last()] >= prices[i]) {
                prices[stack.removeLast()] -= prices[i]
            }
            stack.addLast(i)
        }
        return prices
    }
}

fun main() {
    Solution().finalPrices(intArrayOf(8, 4, 6, 2, 3)).print()   // [4, 2, 4, 2, 3]
    Solution2().finalPrices(intArrayOf(8, 4, 6, 2, 3)).print()  // [4, 2, 4, 2, 3]
    Solution2().finalPrices(intArrayOf(2, 2, 2)).print()        // [0, 0, 2]
}
