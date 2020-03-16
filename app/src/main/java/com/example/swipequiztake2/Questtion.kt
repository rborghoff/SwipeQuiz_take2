package com.example.swipequiz



data class Question (
    val question :String,
    val answer: Boolean
){
    companion object{
        val QUESTION_LIST = arrayOf(
    "A 'val' and 'var' are the same.",
       "Mobile Application Development grants 12 ECTS.",
       "A unit in Kothlin correspondents to a void in Java.",
        "In Kothlin 'when' replaces the 'switch' operator in java.",
            "Kerst valt op 25 en 26 december.",
            "een haai is een zoogdier.",
        "Maaskantj ligt in Noord-Holland",
            "De zon komt op in het westen."
        )



        val QUESTION_ANSWER = arrayOf(
            false,
            true,
            false,
            true,
            true,
            false,
            false,
            false

        )}

}