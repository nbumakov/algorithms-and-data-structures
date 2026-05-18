package com.leetcode.t253

import java.util.PriorityQueue

class Solution {

    // O(nlogn)
    fun minMeetingRooms(intervals: Array<IntArray>): Int {
        val heap = PriorityQueue<Int>()
        var rooms = 0
        intervals.sortBy { it.first() }
        intervals.forEach {
            // достаточно найти одну свободную, все освободившиеся доставать не обязательно
            if (heap.isNotEmpty() && heap.peek()!! <= it.first()) heap.remove()
            heap.add(it.last())
            rooms = maxOf(rooms, heap.size)
        }
        return rooms
    }

    fun minMeetingRooms_two_pointers(intervals: Array<IntArray>): Int {
        val starts = intervals.map { it.first() }.sorted()
        val ends = intervals.map { it.last() }.sorted()

        var p1 = 0
        var p2 = 0
        var rooms = 0
        while (p1 < intervals.size) {
            if (starts[p1] < ends[p2]) {
                rooms++
            } else {
                p2++
            }
            p1++
        }
        return rooms
    }
}