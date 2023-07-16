package com.example.quiz

object realquestions {
    const val username:String="username"
    const val totalquestion:String="totalquestion"
    const val correctanswer:String="Correctanswer"

    fun getquestions():ArrayList<questions>{
        val questionlist=ArrayList<questions>()
        val questiona=questions(
            0,
            "what is the name of this flag",
            R.drawable.unitedstate,
            "USA",
            "NEPAL",
            "INDIA",
            "CHINA",
            0
        )
        questionlist.add(questiona)

        val questionb=questions(
            1,
            "what is the name of this flag",
            R.drawable.s,
            "USA",
            "Germany",
            "INDIA",
            "CHINA",
            1
        )
        questionlist.add(questionb)

        val questionc=questions(
            3,
            "what is the name of this flag",
            R.drawable.download,
            "USA",
            "Germany",
            "INDIA",
            "CHINA",
            3
        )
        questionlist.add(questionc)
        val questiond=questions(
            1,
            "what is the name of this flag",
            R.drawable.india,
            "USA",
            "Germany",
            "INDIA",
            "CHINA",
            2


        )
        questionlist.add(questiond)

        return questionlist
    }
}