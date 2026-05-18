package com.leetcode.t1441

class Solution {
    fun buildArray(target: IntArray, n: Int): List<String> = buildList {
        var stream = 1
        target.forEach {
            while (stream++ != it) addAll(pushAndPop)
            add("Push")
        }
    }

    companion object {
        private val pushAndPop = listOf("Push", "Pop")
    }
}