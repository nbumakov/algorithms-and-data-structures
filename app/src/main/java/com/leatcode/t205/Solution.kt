package com.leatcode.t205

import com.leatcode.util.print

fun main() {
    Solution().isIsomorphic2("badc", "baba").print()
}

class Solution {

    fun isIsomorphic2(s: String, t: String): Boolean {
        val map = hashMapOf<Char, Char>()
        val used = hashSetOf<Char>()
        s.forEachIndexed { i, c ->
            val replacingChar = map.getOrPut(c) {
                if (used.contains(t[i])) {
                    return false
                }
                t[i].also { used.add(it) }
            }
            if (replacingChar != t[i]) return false
        }
        return true
    }

    // TODO: add this solution
    fun isIsomorphic(s: String, t: String): Boolean =
        s.encode() == t.encode()

    private fun String.encode(): String {
        val sb = StringBuilder()
        val map = hashMapOf<Char, Char>()
        var char = 'a'
        forEach { sb.append(map.getOrPut(it) { char++ }) }
        return sb.toString()
    }
}