package com.leetcode.t2353

import java.util.TreeSet

class FoodRatings(foods: Array<String>, cuisines: Array<String>, ratings: IntArray) {

    private val cuisineCache = hashMapOf<String, TreeSet<Dish>>()
    private val foodCache = hashMapOf<String, Dish>()

    init {
        for (i in foods.indices) {
            val dish = Dish(
                food = foods[i],
                cuisine = cuisines[i],
                rating = ratings[i]
            )
            cuisineCache.getOrPut(dish.cuisine) {
                TreeSet(compareByDescending<Dish> { it.rating }.thenBy { it.food })
            }.add(dish)
            foodCache[dish.food] = dish
        }
    }

    fun changeRating(food: String, newRating: Int) {
        val dish = foodCache[food]!!
        val updatedDish = dish.copy(rating = newRating)
        foodCache[food] = updatedDish
        cuisineCache[dish.cuisine]!!.run {
            remove(dish)
            add(updatedDish)
        }
    }

    fun highestRated(cuisine: String): String =
        cuisineCache[cuisine]!!.first().food

    private data class Dish(
        val food: String,
        val cuisine: String,
        val rating: Int,
    )

}
