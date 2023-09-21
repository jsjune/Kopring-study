package com.example.advanced_kotlin.generic

fun main() {
    val cage2 = Cage2<Carp>()
    cage2.put(Carp("잉어"))
    val carp: Carp = cage2.getFirst()

    val fishCage = Cage2<Fish>()
    val goldFishCage = Cage2<GoldFish>()
    goldFishCage.put(GoldFish("금붕어"))

    fishCage.moveFrom(goldFishCage) // out 생산자, 공변
    goldFishCage.moveTo(fishCage) // in 소비자. 반공변

//    val cage: Cage2<Fish> = Cage2<GoldFish>()
}

class Cage2<T : Any> {
    private val animals: MutableList<T> = mutableListOf()

    fun getFirst(): T {
        return animals.first()
    }

    fun put(animal: T) {
        this.animals.add(animal)
    }

    fun moveFrom(otherCage: Cage2<out T>) { // <? extends T>
        this.animals.addAll(otherCage.animals)
    }

    fun moveTo(otherCage: Cage2<in T>) { // <? super T>
        otherCage.animals.addAll(this.animals)
    }
}
