package com.timus.t1260

import kotlin.math.abs

fun main() {
    val n = readLine()!!.toInt()
    val a = IntArray(n).apply {
        for (i in 0..this.lastIndex) {
            this[i] = when (i) {
                0 -> 1
                1 -> 1
                2 -> 2
                else -> this[i - 1] + this[i - 3] + 1
            }
        }
    }
    println(a.last())
}

fun mainBruteForce() {
    val n = readLine()!!.toInt()

    val set = hashSetOf<Int>().apply {
        for (i in 2..n) add(i)
    }

    val cache = hashMapOf<String, Int>()

    var count = 0
    var count2 = 0

    fun calc(i: Int, previous: Int, set: HashSet<Int>): Int {
        if (i == n) {
            return if (abs(set.first() - previous) <= 2) 1 else 0
        }

        val cacheId = "i:$i, p:$previous, set:${set.joinToString()}"
        if (cache.contains(cacheId)) {
            count++
            return cache[cacheId]!!
        }
        count2++

        fun checkNext(next: Int): Int {
            if (set.contains(next)) {
                set.remove(next)
                val nextCount = calc(i + 1, next, set)
                set.add(next)
                return nextCount
            }
            return 0
        }

        return (checkNext(previous - 2) + checkNext(previous - 1) + checkNext(previous + 1) + checkNext(previous + 2))
            .also {
                cache[cacheId] = it
            }
    }

    println(calc(2, 1, set))
    println("inCache: $count, miss: $count2")
}