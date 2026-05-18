package com.leetcode.t359

class Logger() {

    private val messages = hashMapOf<String, Int>()

    fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
        if (messages.containsKey(message) && messages[message]!! + 10 > timestamp) {
            return false
        }
        messages[message] = timestamp
        return true
    }

}