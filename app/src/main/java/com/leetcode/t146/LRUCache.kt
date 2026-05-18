package com.leetcode.t146

fun main() {
    LRUCache(2).apply {
        put(1, 1)
        put(2, 2)
        println(get(1))
        put(3, 3)
        println(get(2))
        put(4, 4)
        println(get(1))
        println(get(3))
        println(get(4))
    }
}

//TODO: make double linked list version
class LRUCache(private val capacity: Int) {

    private val cache = LinkedHashMap<Int, Int>(capacity, 1f, true)

    fun get(key: Int): Int = cache.getOrDefault(key, -1)

    fun put(key: Int, value: Int) {
        if (cache.size >= capacity && !cache.contains(key)) {
            cache.remove(cache.keys.first())
        }
        cache[key] = value
    }

}