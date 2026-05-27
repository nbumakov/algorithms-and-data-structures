package com.leetcode.t3121

class Solution {
    fun numberOfSpecialChars(word: String): Int {
        val set = word.toSet()
        val candidates = ('a'..'z')
            .filter { it in set }
            .toMutableSet()
        val uppercaseSet = mutableSetOf<Char>()
        word.forEach {
            if (it.isUpperCase()) {
                uppercaseSet.add(it)
            } else {
                if (it in candidates && it.uppercaseChar() in uppercaseSet) {
                    candidates.remove(it)
                }
            }
        }
        return candidates.count { it.uppercaseChar() in set }
    }
}


/**
 * FSM Solution
 */
class Solution2 {
    fun numberOfSpecialChars(word: String): Int {
        val status = Array(26) { Status.NOT_SEEN }

        for (c in word) {
            when {
                c.isLowerCase() -> {
                    val i = c - 'a'
                    when (status[i]) {
                        Status.NOT_SEEN -> status[i] = Status.LOWER_ONLY
                        Status.SPECIAL -> status[i] = Status.INVALID
                        else -> {}
                    }
                }
                c.isUpperCase() -> {
                    val i = c - 'A'
                    when (status[i]) {
                        Status.LOWER_ONLY -> status[i] = Status.SPECIAL
                        Status.NOT_SEEN -> status[i] = Status.INVALID
                        else -> {}
                    }
                }
            }
        }

        return status.count { it == Status.SPECIAL }
    }

    private enum class Status {
        NOT_SEEN,
        LOWER_ONLY,
        SPECIAL,
        INVALID
    }
}
