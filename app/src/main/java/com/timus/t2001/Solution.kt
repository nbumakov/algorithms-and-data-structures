package com.timus.t2001

fun main() {
    val (a1, b1) = readLine()!!.split(' ').map(String::toInt)
    val (_, b2) = readLine()!!.split(' ').map(String::toInt)
    val (a3, _) = readLine()!!.split(' ').map(String::toInt)
    println("${a1 - a3} ${b1 - b2}")
}