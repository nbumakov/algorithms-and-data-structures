package com.leetcode.t2981

import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

@OptIn(ExperimentalTime::class)
fun main() {
    Solution().maximumLength("aaaa").let(::println)
    Solution().maximumLength("abcdef").let(::println)
    Solution().maximumLength("abcaba").let(::println)

    val string =     buildString {
            repeat(2) {
                for (i in 'a'..'z') {
                    append(i)
                }
            }
        }

    measureTime {
        Solution().maximumLength(string).let(::println)
    }.let(::println)
    measureTime {
        Solution2().maximumLength(string).let(::println)
    }.let(::println)

}

// найти все подстроки, которые состоят из одинаковых символов
// осортировать их по длине
// пытаться найти количество вхождений символов в строку
class Solution {
    fun maximumLength(s: String): Int {
        val specialSubstrings = mutableSetOf<String>()
        for (i in s.indices) {
            var j = i
            while (j < s.length && s[j] == s[i]) {
                specialSubstrings.add(s.substring(i, j + 1))
                j++
            }
        }
        val specialSubstringsCandidates = specialSubstrings.sortedByDescending { it.length }.toMutableList()
        specialSubstringsCandidates.forEach { candidate ->
            if (s.windowed(candidate.length).count { it == candidate } >= 3) {
                return candidate.length
            }
        }
        return -1
    }
}

class Solution2 {

    // n3
    fun maximumLength(s: String) =
        (s.length - 2 downTo 1).firstOrNull { len -> // n
            val f = IntArray(128)
            s.windowed(len).any { w -> w.all { it == w[0] } && ++f[w[0].code] > 2 }
        } ?: -1
}