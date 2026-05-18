package com.leatcode.t139

import com.leatcode.util.print

fun main() {
    Solution()
        .wordBreak("applepenapple", listOf("apple", "pen"))
        .print()
}

class Solution {

    //TODO try to use Trie
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val seen = BooleanArray(s.length) { false }
        fun dfs(i: Int): Boolean {
            if (s.length == i) return true
            if (seen[i]) return false

            wordDict.forEach { word ->
                if (s.startsWith(word, startIndex = i)) {
                    if (dfs(i + word.length)) return true
                }
            }
            seen[i] = true
            return false
        }
        return dfs(0)
    }
}