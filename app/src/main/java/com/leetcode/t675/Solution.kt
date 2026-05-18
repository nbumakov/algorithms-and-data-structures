package com.leetcode.t675

import com.leetcode.util.print
import java.util.LinkedList
import java.util.Queue

fun main() {
//    Solution().cutOffTree(
//        listOf(
//            listOf(1, 2, 3),
//            listOf(0, 0, 4),
//            listOf(7, 6, 5),
//        )
//    ).print()

//    [[],[],[],[],[]]
    Solution().cutOffTree(
        listOf(
            listOf(54581641, 64080174, 24346381, 69107959),
            listOf(86374198, 61363882, 68783324, 79706116),
            listOf(668150, 92178815, 89819108, 94701471),
            listOf(83920491, 22724204, 46281641, 47531096),
            listOf(89078499, 18904913, 25462145, 60813308),
        )
    ).print()
}

class Solution {

    private val directions = listOf(0 to 1, 1 to 0, -1 to 0, 0 to -1)

    fun cutOffTree(forest: List<List<Int>>): Int {
        val trees = mutableListOf<Pair<Int, Int>>()
        for (i in forest.indices) {
            for (j in forest[i].indices) {
                if (forest[i][j] > 1) trees.add(i to j)
            }
        }
        trees.sortBy { forest[it.first][it.second] }

        fun bfs(i: Int, j: Int, target: Int): Int {
            if (forest[i][j] == 0) return -1
            if (forest[i][j] == target) return 0

            val visited = hashSetOf<Pair<Int, Int>>()
            val queue: Queue<Pair<Int, Int>> = LinkedList()
            queue.add(i to j)
            var step = 0
            while (queue.isNotEmpty()) {
                step++
                repeat(queue.size) {
                    val point = queue.poll()!!

                    for (direction in directions) {
                        val i2 = point.first + direction.first
                        val j2 = point.second + direction.second
                        if (i2 !in forest.indices || j2 !in forest[i2].indices || forest[i2][j2] == 0) continue
                        if (forest[i2][j2] == target) return step

                        val newPoint = i2 to j2
                        if (visited.contains(newPoint)) continue
                        visited.add(newPoint)
                        queue.add(newPoint)
                    }
                }
            }
            return -1
        }

        var point = 0 to 0
        var resultDistance = 0
        trees.forEach { targetTree ->
            val distance = bfs(point.first, point.second, forest[targetTree.first][targetTree.second])
            if (distance == -1) return -1
            resultDistance += distance
            point = targetTree
        }
        return resultDistance
    }
}