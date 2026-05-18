package com.leatcode.t706

import com.leatcode.util.print
import kotlin.system.measureTimeMillis

fun main() {
//    val hm = MyHashMap()
//    hm.put(1234, 10)
//    hm.put(1234, 10)
//    println(hm.get(1234))
//    hm.remove(1234)
//    println(hm.get(1234))

    val hm1 = MyHashMap()
    measureTimeMillis {
        repeat(1000000) { hm1.put(it, 0) }
        repeat(1000000) { hm1.get(it) }
        repeat(1000000) { hm1.remove(it) }
    }.print()


    val hm = MyHashMap2()
    measureTimeMillis {
        repeat(1000000) { hm.put(it, 0) }
        repeat(1000000) { hm.get(it) }
        repeat(1000000) { hm.remove(it) }
    }.print()

    val hm2 = hashMapOf<Int, Int>()
    measureTimeMillis {
        repeat(1000000) { hm2[it] = 0 }
        repeat(1000000) { hm2[it] }
        repeat(1000000) { hm2.remove(it) }
    }.print()
}

/**
 * 706. Design HashMap
 */
class MyHashMap2 {

    private var buckets = Array<MutableList<Pair<Int, Int>>>(16) { mutableListOf() }
    private var loadedBuckets = 0

    fun put(key: Int, value: Int) {
        remove(key)
        bucket(key).add(key to value)
        if (bucket(key).size == 1) loadedBuckets++
        if (loadedBuckets > 0.7 * buckets.size) rehash()
    }

    fun get(key: Int): Int = bucket(key)
        .firstOrNull { it.first == key }?.second ?: -1

    fun remove(key: Int) {
        if (bucket(key).removeAll { it.first == key } && bucket(key).size == 0) loadedBuckets--
    }

    private fun rehash() = with(buckets.flatMap { it }) {
        buckets = Array(2 * size) { mutableListOf() }
        forEach { (key, value) -> bucket(key) += key to value }
    }

    private fun bucket(key: Int) = buckets[key % buckets.size]

}


// simple
class MyHashMap {

    private val buckets = Array<MutableList<Pair<Int, Int>>>(1000) { mutableListOf() }

    fun put(key: Int, value: Int) {
        remove(key)
        buckets[key.hash()].add(key to value)
    }

    fun get(key: Int): Int =
        buckets[key.hash()]
            .firstOrNull { it.first == key }
            ?.second
            ?: -1

    fun remove(key: Int) {
        buckets[key.hash()].removeIf { it.first == key }
    }

    private fun Int.hash() = this % 1000

}


// SamoylenkoDmitry
class MyHashMap3() {
    var table = Array<MutableList<Pair<Int, Int>>>(16) { mutableListOf() }
    var count = 0

    fun bucket(key: Int) = table[key % table.size]

    fun rehash() = with(table.flatMap { it }) {
        table = Array(table.size * 2) { mutableListOf() }
        for ((key, value) in this) bucket(key) += key to value
    }

    fun put(key: Int, value: Int) = with(bucket(key)) {
        if (!removeAll { it.first == key }) count++
        this += key to value
        if (count > table.size) rehash()
    }

    fun get(key: Int) = bucket(key)
        .firstOrNull { it.first == key }?.second ?: -1

    fun remove(key: Int) {
        if (bucket(key).removeAll { it.first == key }) count--
    }
}