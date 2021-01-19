package com.sudzu.trtlmtest.ui.util

import com.sudzu.trtlmtest.data.model.Bug
import kotlin.random.Random

class TestModelGenerator {

    private var random: Random = Random

    fun generateBug(): Bug {
        return Bug(
            (0 until 9999999).random(),
            getRandomString(1),
            getRandomString(1),
            (0 until 1).random(),
            getRandomString(1),
            getRandomString(1),
            getRandomString(1),
            random.nextBoolean(),
            random.nextBoolean(),
            random.nextBoolean(),
            random.nextBoolean(),
            getRandomString(1),
            getRandomString(1),
            getRandomString(1),
            getRandomString(1),
            getRandomString(1),
            getRandomString(1),
            getRandomString(1),
            getRandomString(1),
            status = getRandomString(1),
            getRandomString(1),
            getRandomString(1),
            type = getRandomString(10),
            getRandomString(1),
            getRandomString(1),
            (0 until 1).random(),
            getRandomString(1)
        )
    }

    private fun getRandomString(length: Int): String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }
}