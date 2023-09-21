package com.example.advanced_kotlin.generic

fun main() {
    val cage = Cage()
    cage.put(Carp("잉어"))
//    val carp: Carp = cage.getFirst() // Error: Type Mismatch

}

class Cage {
    private val animals: MutableList<Animal> = mutableListOf()

    fun getFirst(): Animal {
        return animals.first()
    }

    fun put(animal: Animal) {
        this.animals.add(animal)
    }

    fun moveFrom(cage: Cage) {
        this.animals.addAll(cage.animals)
    }
}

