package com.fjbg.weather.animation

import kotlin.random.Random


data class ObjectPosition(
    val x: Float,
    val y: Float,
    val z: Int,
)

fun generatePosition(size: Int): List<ObjectPosition> {
    val data: MutableList<ObjectPosition> = mutableListOf()

    for (obj in 1..size) {
        data.add(
            ObjectPosition(
                x = Random.nextFloat(),
                y = Random.nextFloat(),
                z = Random.nextInt(1, 5),
            )
        )
    }
    return data
}