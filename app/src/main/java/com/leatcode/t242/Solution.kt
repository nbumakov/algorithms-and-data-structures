package com.leatcode.t242

import com.leatcode.util.print

fun main() {
    Solution().isAnagram2("car", "rac").print()
}

class Solution {

    fun isAnagram2(s: String, t: String): Boolean =
        s.toCharArray().sorted() == t.toCharArray().sorted()

    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }
        val dic = HashMap<Char, Int>()
        s.forEach {
            dic[it] = dic.getOrDefault(it, 0).inc()
        }
        t.forEach {
            val count = dic.getOrDefault(it, 0)
            if (count > 0) {
                dic[it] = count - 1
            } else {
                return false
            }
        }
        return true
    }
}