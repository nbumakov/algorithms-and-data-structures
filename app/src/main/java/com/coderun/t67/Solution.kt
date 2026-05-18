package com.coderun.t67

fun main() {
    readln()
    val array = readln().split(' ').map { it.toInt() }

    for (i in array.indices) {
        val suffix = array.subList(i, array.size)
        if (suffix.isPalindrome()) {
            println(i)
            println(array.subList(0, i).reversed().joinToString(" "))
            return
        }
    }

}

fun List<Int>.isPalindrome(): Boolean {
    for (i in 0 .. lastIndex / 2) {
        if (this[i] != this[lastIndex - i]) return false
    }
    return true
}