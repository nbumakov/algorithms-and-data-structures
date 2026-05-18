package com.leetcode.t409

class Solution {
    fun longestPalindrome(s: String): Int {
        val map = hashMapOf<Char, Int>()
        s.forEach { map[it] = map.getOrDefault(it, 0) + 1 }
        var oddChars = 0
        var eventChars = 0
        map.forEach { (_, qty) ->
            val reminder = qty % 2
            eventChars += qty - reminder
            oddChars += reminder
        }
        return eventChars + oddChars.coerceAtMost(1)
    }

    fun longestPalindrome2(s: String): Int {
        val set = hashSetOf<Char>()
        var result = 0
        s.forEach {
            if (set.contains(it)) {
                result += 2
                set.remove(it)
            } else {
                set.add(it)
            }
        }
        return result + set.size.coerceAtMost(1)
    }
}