package com.leetcode.t2126

import java.util.PriorityQueue

class Solution {
    fun asteroidsDestroyed(mass: Int, asteroids: IntArray): Boolean {
        asteroids
            .sorted()
            .fold(mass.toLong()) { m, a ->
                if (a > m) return false
                if (m >= 100_000) return true
                m + a
            }
        return true
    }
}

class Solution2 {
    fun asteroidsDestroyed(mass: Int, asteroids: IntArray): Boolean {
        asteroids.sort()
        var currentMass = mass.toLong()
        for (a in asteroids) {
            if (a > currentMass) return false
            currentMass += a
            if (currentMass >= 100_000) return true
        }
        return true
    }
}

class Solution3 {
    fun asteroidsDestroyed(mass: Int, asteroids: IntArray): Boolean {
        val pq = PriorityQueue<Int>()
        var currentMass = mass.toLong()

        for (a in asteroids) {
            pq.add(a)
            while (pq.isNotEmpty() && currentMass >= pq.peek()) {
                currentMass += pq.poll()
                if (currentMass >= 100_000) return true
            }
        }

        return pq.isEmpty()
    }
}
