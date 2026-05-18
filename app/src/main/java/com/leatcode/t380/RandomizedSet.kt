package com.leatcode.t380

import kotlin.random.Random


// TODO: make realization on hashtable ans list
class RandomizedSet() {

    private val set = mutableSetOf<Int>()

    fun insert(`val`: Int): Boolean = set.add(`val`)

    fun remove(`val`: Int): Boolean = set.remove(`val`)

    fun getRandom(): Int = set.elementAt(Random.nextInt(set.size))

}