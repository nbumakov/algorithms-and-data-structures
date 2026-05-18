package com.leetcode.t2402

import com.leetcode.util.print

fun main() {
//    Solution().mostBooked(
//        n = 2,
//        meetings = arrayOf(
//            intArrayOf(0, 10),
//            intArrayOf(1, 5),
//            intArrayOf(2, 7),
//            intArrayOf(3, 4),
//        )
//    ).print()

    Solution().mostBooked(
        n = 4,
        meetings = arrayOf(
            intArrayOf(18, 19),
            intArrayOf(3, 12),
            intArrayOf(17, 19),
            intArrayOf(2, 13),
            intArrayOf(7, 10),
        )
    ).print()

}

class Solution {
    fun mostBooked(n: Int, meetings: Array<IntArray>): Int {

        data class MeetingRoom(
            val number: Int,
            var held: Int = 0,
            var freeSince: Long = 0L,
        )

        val rooms = List(n) { MeetingRoom(it) }
        meetings.sortedBy { it[0] }.forEach { (meetingStart, meetingEnd) ->
            val meetingRoom = rooms.firstOrNull { it.freeSince <= meetingStart }
                ?: rooms.minOfWith(compareBy({ it.freeSince }, { it.number })) { it }

            with(meetingRoom) {
                freeSince = if (freeSince <= meetingStart) meetingEnd.toLong() else freeSince + meetingEnd - meetingStart
                held += 1
            }
            rooms.print()
        }

        return rooms.maxOfWith(
            comparator = compareBy<MeetingRoom> { it.held } then compareByDescending { it.number },
            selector = { it }
        ).number
    }
}