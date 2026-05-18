package com.example.stepcalgs.group1.task_1_2_2

import java.util.*


/**
 * 5
 * 4 -1 4 1 1
 *
 * 3
 */
fun main() {
    val scanner = Scanner(System.`in`)
    val length = scanner.nextInt()
    val treeParentsArray = IntArray(length)

    for (i in 0 until length) {
        treeParentsArray[i] = scanner.nextInt()
    }

    //#region поиск глубины от вершины
    val adjacencyList = Array<MutableList<Int>>(length) { mutableListOf() }

    treeParentsArray.forEachIndexed { index, parentIndex ->
        if (parentIndex != -1) {
            adjacencyList[parentIndex].add(index)
        }
    }

    val rootIndex = treeParentsArray.indexOf(-1)

    println(height(adjacencyList, rootIndex))

    //#endregion
}

private fun height(adjacencyList: Array<MutableList<Int>>, node: Int): Int {
    if (adjacencyList[node].isEmpty()) {
        return 1
    }

    return adjacencyList[node].maxOf { child ->
        height(adjacencyList, child) + 1
    }
}

