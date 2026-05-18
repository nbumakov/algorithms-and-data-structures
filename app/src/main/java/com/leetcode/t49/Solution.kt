package com.leetcode.t49

import com.leetcode.util.print

fun main() {
    Solution().groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")).forEach {
        it.print()
    }
}

class Solution {

    fun groupAnagrams2(strs: Array<String>): List<List<String>> =
        strs.groupBy { it.toCharArray().sorted() }
            .map { it.value }

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = HashMap<Int, MutableMap<List<Int>, MutableList<String>>>()

        strs.forEach {
            map.getOrPut(it.length) { mutableMapOf() }
                .getOrPut(it.toQtyList()) { mutableListOf() }
                .add(it)
        }

        return map.values.flatMap { it.values }
    }

    private fun String.toQtyList(): List<Int> {
        val list = Array(26) { 0 }
        forEach { list[it - 'a']++ }
        return list.toList()
    }
}