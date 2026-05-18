package com.leatcode.t71


class Solution {
    fun simplifyPath(path: String): String {
        val stack = ArrayDeque<String>()
        for (directory in path.split("/")) {
            when {
                directory == "." || directory.isEmpty() -> continue   // A no-op for a "." or an empty string
                directory == ".." -> if (!stack.isEmpty()) stack.removeLast()
                else -> stack.add(directory)
            }
        }

        // Stich together all the directory names together
        val result = buildString {
            for (dir in stack) append("/$dir")
        }

        return result.ifEmpty { "/" }
    }
}