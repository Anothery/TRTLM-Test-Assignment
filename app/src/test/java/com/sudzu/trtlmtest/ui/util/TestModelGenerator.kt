package com.sudzu.trtlmtest.ui.util

import com.sudzu.trtlmtest.data.model.Bug
import kotlin.random.Random

class TestModelGenerator {

    private var random: Random = Random

    fun generateBug(): Bug {
        return Bug(
            (0 until 9999999).random(),
            "", "", 0, "", "", "",
            false, false, false, false, "",
            "", "", "", "", "", "", "",
            getRandomString(10),
            "", "", getRandomString(10), "", "", 0, ""
        )
    }

    private fun getRandomString(length: Int): String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }
}