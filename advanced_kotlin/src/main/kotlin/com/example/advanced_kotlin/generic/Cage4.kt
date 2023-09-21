package com.example.advanced_kotlin.generic

class Cage4<in T> { // 소비
    private val animals: MutableList<T> = mutableListOf()

    fun put(animal: T) {
        this.animals.add(animal)
    }

    fun putAll(animals: List<T>) {
        this.animals.addAll(animals)
    }
}

fun main() {
    val cage = Cage4<Fish>()
    cage.put(GoldFish("금붕어"))
    cage.put(Carp("잉어"))

    val goldFish: Cage4<GoldFish> = cage
}
