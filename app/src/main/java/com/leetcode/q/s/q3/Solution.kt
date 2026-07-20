package com.leetcode.q.s.q3

class Solution {
    // Input: n = 2, logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
    fun exclusiveTime(n: Int, logs: List<String>): IntArray {
        val times = IntArray(n)
        val stack = ArrayDeque<Int>()   // стек id функций
        var prevTime = 0

        for (log in logs) {
            val (id, type, time) = log.split(":").let { (id, type, time) ->
                Triple(id.toInt(), type, time.toInt())
            }

            when (type) {
                "start" -> {
                    if (stack.isNotEmpty()) {
                        times[stack.last()] += time - prevTime
                    }
                    stack.addLast(id)
                    prevTime = time
                }

                "end" -> {
                    stack.removeLast()
                    times[id] += time - prevTime + 1
                    prevTime = time + 1
                }
            }
        }
        return times
    }
}