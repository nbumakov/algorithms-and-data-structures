package com.coderun.t279

fun main() {
    val n = readln().toInt()
    val teams = readln().split(' ').map { it.toInt() }.sorted()
    val k = readln().toInt()
    val rooms = sortedMapOf<Int, Int>()
    repeat(k) {
        val (size, qty) = readln().split(' ').map { it.toInt() }
        rooms[size] = rooms.getOrDefault(size, 0) + qty
    }
    teams.forEach {team ->
        while (rooms.isNotEmpty() && rooms.firstKey() < team) rooms.remove(rooms.firstKey())
        if (rooms.isEmpty()) {
            println("No")
            return
        }
        rooms[rooms.firstKey()] = rooms[rooms.firstKey()]!! - 1
        if (rooms[rooms.firstKey()] == 0) rooms.remove(rooms.firstKey())
    }
    println("Yes")
}