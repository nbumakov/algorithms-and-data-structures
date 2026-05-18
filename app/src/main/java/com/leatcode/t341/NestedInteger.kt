package com.leatcode.t341

interface NestedInteger {
    fun isInteger(): Boolean
    fun getInteger(): Int?
    fun setInteger(value: Int): Unit
    fun add(ni: NestedInteger): Unit
    fun getList(): List<NestedInteger>?
}

fun main() {

}

class NestedIterator(nestedList: List<NestedInteger>) : Iterator<Int> by iterator({
    for (item in nestedList) {
        item.getInteger()?.let { yield(it) }
        item.getList()?.let { yieldAll(NestedIterator(it)) }
    }
})


// Approach 1: Make a Flat List with Recursion
class NestedIterator1(nestedList: List<NestedInteger>) {

    private var curr = 0
    private val list = mutableListOf<Int>()

    init {
        filList(nestedList)
    }

    fun next(): Int = list[curr++]

    fun hasNext(): Boolean = curr in list.indices

    private fun filList(nestedList: List<NestedInteger>) {
        nestedList.forEach {
            if (it.isInteger()) {
                list.add(it.getInteger()!!)
            } else {
                filList(it.getList()!!)
            }
        }
    }
}