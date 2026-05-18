package com.leetcode.t362

class HitCounter() {

    private val map = hashMapOf<Int, Record>()

    data class Record(
        var timestamp: Int,
        var count: Int
    )

    fun hit(timestamp: Int) {
        val record = map.getOrPut(timestamp % 300) { Record(timestamp, 0) }
        if (record.timestamp == timestamp) {
            record.count++
        } else {
            record.timestamp = timestamp
            record.count = 1
        }
    }

    fun getHits(timestamp: Int): Int {
        var count = 0
        map.forEach { (t, record) ->
            if (record.timestamp + 300 > timestamp ) count += record.count
        }
        return count
    }

}
