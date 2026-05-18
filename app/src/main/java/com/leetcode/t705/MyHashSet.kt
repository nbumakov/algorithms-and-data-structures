package com.leetcode.t705

class MyHashSet() {

    private val buckets = Array<MutableList<Int>>(1000) { mutableListOf() }

    fun add(key: Int) {
        if(!contains(key)) {
            buckets[key.hash()].add(key)
        }
    }

    fun remove(key: Int) {
        buckets[key.hash()].remove(key)
    }

    fun contains(key: Int): Boolean =
        buckets[key.hash()].contains(key)

    private fun Int.hash() = this % 1000

}