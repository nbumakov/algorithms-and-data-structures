package com.leetcode.t14

class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        val prefix = strs[0]
        prefix.forEachIndexed { index, c ->
            if (strs.any { it.length == index || it[index] != c }) {
                return prefix.substring(0, index)
            }
        }
        return prefix
    }
}