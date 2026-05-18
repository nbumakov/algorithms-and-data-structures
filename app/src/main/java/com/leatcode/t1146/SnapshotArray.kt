package com.leatcode.t1146

import java.util.LinkedList
import java.util.TreeMap

fun main() {
    val l = LinkedList<LinkedList<Int>>()
    println(l[0])
}

class SnapshotArray(length: Int) {

    private val values = Array(length) { TreeMap<Int, Int>() }
    private var snapId = 0

    fun set(index: Int, `val`: Int) {
        values[index][snapId] = `val`
    }

    fun snap() = snapId++

    fun get(index: Int, snap_id: Int) =
        (values[index].floorEntry(snap_id)?.value ?: 0)

}
