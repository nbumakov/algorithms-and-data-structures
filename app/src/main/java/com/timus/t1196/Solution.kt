package com.timus.t1196

fun mainSet() {
    val n = readLine()!!.toInt()
    val professorDatesSet = hashSetOf<String>()
    repeat(n) { professorDatesSet.add(readLine()!!) }
    var result = 0
    val m = readLine()!!.toInt()
    repeat(m) { if (professorDatesSet.contains(readLine()!!)) result++ }
    println(result)
}

fun main() {
    val n = readLine()!!.toInt()
    val professorsList = mutableListOf<Int>()
    repeat(n) { professorsList.add(readLine()!!.toInt()) }
    var result = 0
    val m = readLine()!!.toInt()

    repeat(m) {
        val date = readLine()!!.toInt()
        var l = 0
        var r = professorsList.lastIndex
        while (l <= r) {
            val mid = (l + r) / 2
            val midValue = professorsList[mid]
            when {
                date < midValue -> r = mid - 1
                date > midValue -> l = mid + 1
                else -> {
                    result++
                    break
                }
            }
        }
    }
    println(result)
}