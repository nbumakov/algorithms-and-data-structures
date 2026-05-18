package com.leetcode.t2982


fun main() {
//    Solution().maximumLength("aaaa").let(::println)
//    Solution().maximumLength("abcdef").let(::println)
//    Solution().maximumLength("abcaba").let(::println)
    Solution().maximumLength("atttttnlll").let(::println)
    com.leetcode.t2981.Solution().maximumLength("atttttnlll").let(::println)
}

class Solution {
    fun maximumLength(s: String): Int {
        val freq = Array(26) { IntArray(s.length + 1) }
        var j = 0
        for (i in s.indices) {
            if (s[j] != s[i]) {
                j = i
            }
            freq[s[i] - 'a'][i - j + 1]++
        }


        // Calculate the cumulative sum from the end for every character and find the
        // maximum possible answer.
        var result = -1
        for (charIdx in freq.indices) {
            for (len in s.length - 1 downTo 1) {
                freq[charIdx][len] += freq[charIdx][len + 1]
                if (freq[charIdx][len] >= 3) {
                    result = maxOf(result, len)
                    break
                }
            }
        }

        return result
    }
}