package com.leetcode.t3517

// You are given a palindromic string s.
//
// Return the lexicographically smallest palindromic permutation of s.
//
// Since s is already a palindrome, every letter occurs an even number of times
// except at most one, which sits in the middle. Sorting the first half
// ascending gives the smallest result; the second half is its mirror.
class Solution {

    fun smallestPalindrome(s: String): String {
        val occurrences = IntArray(ALPHABET_SIZE)
        for (c in s) {
            occurrences[c - 'a']++
        }

        val firstHalf = buildString {
            occurrences.forEachIndexed { letter, times ->
                repeat(times / 2) { append('a' + letter) }
            }
        }
        val middle = occurrences.indexOfFirst { it % 2 == 1 }
        val center = if (middle >= 0) ('a' + middle).toString() else ""

        return firstHalf + center + firstHalf.reversed()
    }

    private companion object {
        const val ALPHABET_SIZE = 26
    }
}
