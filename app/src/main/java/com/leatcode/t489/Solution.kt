package com.leatcode.t489

import com.leatcode.util.print

interface Robot {
    // returns true if next cell is open and robot moves into the cell.
    // returns false if next cell is obstacle and robot stays on the current cell.
    fun move(): Boolean

    // Robot will stay on the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    fun turnLeft()
    fun turnRight()

    // Clean the current cell.
    fun clean()
}

class RobotImpl() : Robot {

    var x = 2
    var y = 2
    var d = 3

    val space = arrayOf(
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 1, 1, 1, 0),
        intArrayOf(0, 1, 1, 1, 0),
        intArrayOf(0, 1, 1, 1, 0),
        intArrayOf(0, 0, 0, 0, 0),
    )

    override fun move(): Boolean = when (d) {
        0 -> if (space[y][x + 1] > 0) {
            x++
            true
        } else false

        1 -> if (space[y + 1][x] > 0) {
            y++
            true
        } else false

        2 -> if (space[y][x - 1] > 0) {
            x--
            true
        } else false

        3 -> if (space[y - 1][x] > 0) {
            y--
            true
        } else false

        else -> false
    }

    override fun turnLeft() {
        d = (d + 3) % 4
    }

    override fun turnRight() {
        d = (d + 1) % 4
    }

    override fun clean() {
        space[y][x]++
    }

}

fun main() {
    val robot = RobotImpl()
    Solution().cleanRoom(robot)
    robot.space.forEach { it.print() }
}

class Solution {

    fun cleanRoom(robot: Robot) {
        val visited = hashSetOf<Pair<Int, Int>>()

        fun dfs(i: Int, j: Int, direction: Int) {
            robot.clean()
            visited.add(i to j)

            for (turns in direction until direction + 4) {
                when (val d = turns % 4) {
                    0 -> if (!visited.contains(i to j + 1) && robot.move()) dfs(i, j + 1, d)
                    1 -> if (!visited.contains(i + 1 to j) && robot.move()) dfs(i + 1, j, d)
                    2 -> if (!visited.contains(i to j - 1) && robot.move()) dfs(i, j - 1, d)
                    3 -> if (!visited.contains(i - 1 to j) && robot.move()) dfs(i - 1, j, d)
                }
                robot.turnRight()
            }
            repeat(2) { robot.turnRight() }
            robot.move()
            repeat(2) { robot.turnRight() }
        }
        dfs(0, 0, 0)
    }

}