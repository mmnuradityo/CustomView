package com.aditya.mycustomview.widget.randomnumber

import java.util.Random

internal object NumberGenerator {
    fun generate(max: Int): Int {
        val random = Random()
        return random.nextInt(max)
    }
}