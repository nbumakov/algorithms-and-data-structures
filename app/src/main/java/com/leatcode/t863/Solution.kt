package com.leatcode.t863

import com.leatcode.util.TreeNode

class Solution {


    fun distanceK(root: TreeNode?, target: TreeNode?, k: Int): List<Int> {
        if (root == null) return emptyList()

        val parents = hashMapOf<TreeNode, TreeNode>()
        fun addParents(node: TreeNode, parent: TreeNode?) {
            parent?.let { parents[node] = it }
            node.left?.let { addParents(it, node) }
            node.right?.let { addParents(it, node) }
        }
        addParents(root, null)

        val visited = hashSetOf<TreeNode>()
        val result = mutableListOf<Int>()

        fun dfs(node: TreeNode?, k: Int) {
            if (node == null || node in visited) return

            visited.add(node)

            if (k == 0) {
                result.add(node.`val`)
            } else {
                dfs(parents[node], k - 1)
                dfs(node.left, k - 1)
                dfs(node.right, k - 1)
            }
        }
        dfs(target, k)

        return result
    }


//    fun distanceK(root: TreeNode?, target: TreeNode?, k: Int): List<Int> {
//        if (root == null) return emptyList()
//        if (root == target) return getChildrenAtLevel(target, k)
//
//        val parentsMap = hashMapOf<TreeNode, TreeNode>()
//        val queue = LinkedList<TreeNode>().apply { add(root) }
//        val addNode = { node: TreeNode, parent: TreeNode ->
//            parentsMap[node] = parent
//            queue.add(node)
//        }
//        while (queue.isNotEmpty()) {
//            if (queue.contains(target)) break
//            repeat(queue.size) {
//                val node = queue.pop()!!
//                node.left?.let { addNode(it, node) }
//                node.right?.let { addNode(it, node) }
//            }
//        }
//
//        val result = mutableListOf<Int>().apply {
//            addAll(getChildrenAtLevel(target, k))
//        }
//
//        var level = k
//        var current = target
//        var parent = parentsMap[current]
//        while (parent != null && level > 0) {
//            result.addAll(getChildrenAtLevel(parent, --level, current))
//            current = parent
//            parent = parentsMap[current]
//        }
//
//        return result
//    }
//
//    private fun getChildrenAtLevel(root: TreeNode?, level: Int, exclude: TreeNode? = null): List<Int> {
//        if (root == null) return emptyList()
//        if (level == 0) return listOf(root.`val`)
//        val result = mutableListOf<Int>()
//
//        if (root.left != exclude) {
//            result.addAll(getChildrenAtLevel(root.left, level - 1))
//        }
//        if (root.right != exclude) {
//            result.addAll(getChildrenAtLevel(root.right, level - 1))
//        }
//        return result
//    }


}