package com.leatcode.t787

import com.leatcode.util.print
import java.util.LinkedList

fun main() {
//    Solution()
//        .findCheapestPrice(
//            n = 4,
//            flights = arrayOf(
//                intArrayOf(0, 1, 100),
//                intArrayOf(1, 2, 100),
//                intArrayOf(2, 0, 100),
//                intArrayOf(1, 3, 600),
//                intArrayOf(2, 3, 200),
//            ),
//            src = 0,
//            dst = 3,
//            k = 1,
//        ).print()

    //0,1,100],[1,2,100],[0,2,500
//    Solution()
//        .findCheapestPrice(
//            n = 3,
//            flights = arrayOf(
//                intArrayOf(0, 1, 100),
//                intArrayOf(1, 2, 100),
//                intArrayOf(0, 2, 500),
//            ),
//            src = 0,
//            dst = 2,
//            k = 1,
//        ).print()

    Solution()
        .findCheapestPrice(
            n = 5,
            flights = arrayOf(
                intArrayOf(0, 1, 100),
                intArrayOf(0, 2, 100),
                intArrayOf(0, 3, 10),
                intArrayOf(1, 2, 100),
                intArrayOf(1, 4, 10),
                intArrayOf(2, 1, 10),
                intArrayOf(2, 3, 100),
                intArrayOf(2, 4, 100),
                intArrayOf(2, 4, 100),
                intArrayOf(3, 2, 10),
                intArrayOf(3, 4, 100),
            ),
            src = 0,
            dst = 4,
            k = 3,
        ).print()
}

class Solution {


    //DFS:
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        val adj = Array(n) { IntArray(n) { -1 } }
        flights.forEach { (from, to, price) -> adj[from][to] = price }

        val cache = hashMapOf<Pair<Int, Int>, Int>()

        fun dfs(node: Int, level: Int): Int {
            if (node == dst) return 0
            if (level > k) return -1

            return cache.getOrPut(level to node) {
                adj[node]
                    .withIndex()
                    .filter { it.value > 0 }
                    .mapNotNull { route ->
                        dfs(route.index, level + 1).takeIf { it >= 0 }?.let { it + route.value }
                    }
                    .minOrNull() ?: -1
            }
        }

        return dfs(src, 0)
    }
}