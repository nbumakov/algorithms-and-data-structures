package com.leetcode.t95

import com.leetcode.util.TreeNode
import com.leetcode.util.print

fun main() {
    Solution().generateTrees(5).forEach {
        it.print()
        println()
    }
}

class Solution {

    private val cache = hashMapOf<IntRange, List<TreeNode?>>()

    fun generateTrees(n: Int): List<TreeNode?> =
        generateTreesInRange(1..n)

    private fun generateTreesInRange(range: IntRange): List<TreeNode?> {
        if (cache.contains(range)) {

            return cache[range]!!
        }
        if (range.isEmpty()) return Empty
        return mutableListOf<TreeNode?>().apply {
            range.forEach { k ->
                val leftSubTrees = generateTreesInRange((range.first until k))
                val rightSubTrees = generateTreesInRange((k + 1..range.last))

                leftSubTrees.forEach { l ->
                    rightSubTrees.forEach { r ->
                        add(TreeNode(k).apply {
                            left = l
                            right = r
                        })
                    }
                }
            }
        }.also {
            cache[range] = it
        }
    }

    companion object {
        private val Empty = listOf(null)
    }

}

//    private fun TreeNode.copy(): TreeNode =
//        TreeNode(`val`).also {
//            it.left = left?.copy()
//            it.right = right?.copy()
//        }

class Solution_WA {
    fun generateTrees(n: Int): List<TreeNode?> {
        val usedNums = hashSetOf<Int>()

        val trees: MutableList<TreeNode?> = mutableListOf()
        fun backtrack(root: TreeNode, node: TreeNode, range: IntRange) {
            if (usedNums.size == n) {
                trees.add(root.copy())
                return
            }

            for (k in range) {
                if (usedNums.contains(k)) continue

                usedNums.add(k)
                if (k < node.`val`) {
                    node.left = TreeNode(k)
                    backtrack(root, node.left!!, 1 until node.`val`)
                    node.left = null
                }
                if (k > node.`val`) {
                    node.right = TreeNode(k)
                    backtrack(root, node.right!!, node.`val` + 1..n)
                    node.right = null
                }

                usedNums.remove(k)
            }
        }
        for (i in 1..n) {
            usedNums.add(i)
            TreeNode(i).let { backtrack(it, it, 1..n) }
            usedNums.remove(i)
        }
        return trees
    }

    private fun TreeNode.copy(): TreeNode =
        TreeNode(`val`).also {
            it.left = left?.copy()
            it.right = right?.copy()
        }
}