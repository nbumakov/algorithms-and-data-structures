package com.leetcode.t1615

class Solution {

    fun maximalNetworkRank(n: Int, roads: Array<IntArray>): Int {
        val map = hashMapOf<Int, Int>()
        roads.forEach {
            map[it.first()] = map.getOrDefault(it.first(), 0) + 1
            map[it.last()] = map.getOrDefault(it.last(), 0) + 1
        }

        val max1 = map.max()
        map.remove(max1)
        val max2 = map.max()

        return roads.count { it.contains(max1) || it.contains(max2) }
    }

    private fun Map<Int, Int>.max(): Int {
        var max = 0
        var res = -1
        forEach {
            if (it.value > max) {
                max = it.value
                res = it.key
            }
        }
        return res
    }

    // O(n3)
    fun maximalNetworkRank1(n: Int, roads: Array<IntArray>): Int {
        val adj = Array(n) { mutableListOf<Int>() }
        roads.forEach {
            adj[it.first()].add(it.last())
            adj[it.last()].add(it.first())
        }

        var max = 0
        for (i in 0 until n) {
            for (j in i + 1 until n) {
                max = maxOf(
                    max,
                    adj[i].size + adj[j].size - if (adj[i].contains(j)) 1 else 0
                )
            }
        }
        return max
    }

    // O(n2)
//    fun maximalNetworkRank(n: Int, roads: Array<IntArray>): Int {
//        val fromTo = mutableMapOf<Int, HashSet<Int>>()
//        roads.forEach {
//            fromTo.getOrPut(it.first()) { HashSet() } += it.last()
//            fromTo.getOrPut(it.last()) { HashSet() } += it.first()
//        }
//
//        var max = 0
//        for (i in 0 until n) {
//            for (j in i + 1 until n) {
//                max = maxOf(
//                    max,
//                    (fromTo[i]?.size ?: 0) + (fromTo[j]?.size ?: 0) - if (fromTo[i]?.contains(j) == true) 1 else 0
//                )
//            }
//        }
//        return max
//    }
}