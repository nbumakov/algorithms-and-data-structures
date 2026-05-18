package com.leatcode.t207

class Solution {

    // [[1,0],[0,3],[0,2],[3,2],[2,5],[4,5],[5,6],[2,4]]
    // 1 -> 0 -> 3 -> 2
    //

    //TODO check more optimal -> Topological sort
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val adj = Array(numCourses) { mutableSetOf<Int>() }
        for (p in prerequisites) {
            adj[p[1]].add(p[0])
        }

        val visited = BooleanArray(numCourses) { false }
        val safe = BooleanArray(numCourses) { false }
        for (r in adj.indices) {
            visited.fill(false)
            if (adj.dfsCycle(r, visited, safe)) return false
        }

        return true
    }

    private fun Array<out Set<Int>>.dfsCycle(node: Int, visited: BooleanArray, safe: BooleanArray): Boolean {
        if (this[node].isEmpty()) return false
        if (safe[node]) return false
        if (visited[node]) return true
        visited[node] = true

        return this[node].any { dfsCycle(it, visited, safe) }.also {
            if (!it) {
                safe[node] = true
            }
        }
    }
}