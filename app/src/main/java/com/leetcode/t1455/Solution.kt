package com.leetcode.t1455

fun main() {
//    Solution().isPrefixOfWord("i love eating burger", "burg")
//        .let(::println)

    Solution().isPrefixOfWord("leetcode corona", "leetco")
        .let(::println)
}

class Solution {
    fun isPrefixOfWord(sentence: String, searchWord: String): Int {
        var searchWordIndex = 0
        var wordIndex = 1
        var currWordPosition = 0

        for (i in sentence.indices){
            if (sentence[i] == ' '){
                searchWordIndex = 0
                wordIndex++
                currWordPosition = 0
            } else {
                if (sentence[i] == searchWord[searchWordIndex] && currWordPosition == searchWordIndex){
                    searchWordIndex++
                    if (searchWordIndex == searchWord.length){
                        return wordIndex
                    }
                }
                currWordPosition++
            }
        }
        return -1
    }
}