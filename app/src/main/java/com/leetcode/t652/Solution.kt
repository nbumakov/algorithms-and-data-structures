package com.leetcode.t652

import com.leetcode.util.TreeNode

class Solution {
    fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode?> {
        val map = hashMapOf<String, MutableList<TreeNode>>()
        val result = mutableListOf<TreeNode>()

        fun TreeNode?.dfs(map: HashMap<String, MutableList<TreeNode>>, result: MutableList<TreeNode>): String {
            if (this == null) return ""

            val id = "(${left.dfs(map, result)})$`val`${right.dfs(map, result)}"
            map.getOrPut(id) { mutableListOf() }.also {
                it.add(this)
                if (it.size == 2) result.add(this)
            }

            return id
        }

        root.dfs(map, result)

        return result
    }

}

