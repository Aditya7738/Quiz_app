package com.example.quizapp

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Questions> {
        val questionList = arrayListOf<Questions>()

        val question1 = Questions(
            1,
            "Who is this famous celebrity of Hollywood?",
            R.drawable.christian_bale,
            "Brad Pitt",
            "Christian Bale",
            "Mark Walhberg",
            "James Brolin",
            2
        )
        val question2 = Questions(
            2,
            "Who is this famous celebrity of Hollywood?",
            R.drawable.natalie_portman,
            "Keira Knightley",
            "Lana Del Rey",
            "Natalie Portman",
            "Lindsay Lohan",
            3
        )
        val question3 = Questions(
            3,
            "Who is this famous celebrity of Hollywood?",
            R.drawable.kate_winslet,
            "Rachel Weisz",
            "Kate Winslet",
            "Kate Middleton",
            "Geena Davis",
            2
        )
        val question4 = Questions(
            4,
            "Who is this famous celebrity of Hollywood?",
            R.drawable.emma_stone,
            "Lindsay Lohan",
            "Mila Kunis",
            "Emma Stone",
            "Natalie Portman",
            3
        )
        val question5 = Questions(
            5,
            "Who is this famous celebrity of Hollywood?",
            R.drawable.paul_rudd,
            "Tony Romo",
            "Paul Rudd",
            "Luke Evans",
            "Thomas Gibson",
            2
        )
        val question6 = Questions(
            6,
            "Who is this famous celebrity of Hollywood?",
            R.drawable.hugh_jackman,
            "Hugh Jackman",
            "Clint Eastwood",
            "Hugh Dancy",
            "Dermot Mulroney",
            1
        )
        val question7 = Questions(
            7,
            "Who is this famous celebrity of Hollywood?",
            R.drawable.mark_wahlberg,
            "Matt Damon",
            "Mark Wahlberg",
            "Michael Raymond",
            "Neal Cassidy",
            2
        )

        val question8 = Questions(
            8,
            "Who is this famous celebrity of Hollywood?",
            R.drawable.john_mayer,
            "Morgan Freeman",
            "Skeet Ulrich",
            "John Mayer",
            "Heath Ledger",
            3
        )

        val question9 = Questions(
            9,
            "Who is this famous celebrity of Hollywood?",
            R.drawable.ryan_reynolds,
            "Ryan Gosling",
            "Jason Lee",
            "Kris Humphries",
            "Ryan Reynolds",
            4
        )

        val question10 = Questions(
            10,
            "Who is this famous celebrity of Hollywood?",
            R.drawable.jessica_chastain,
            "Bryce Dallas Howard",
            "Hilary Swank",
            "Jessica Chastain",
            "Jennifer Garner",
            3
        )

        questionList.add(question1)
        questionList.add(question2)
        questionList.add(question3)
        questionList.add(question4)
        questionList.add(question5)
        questionList.add(question6)
        questionList.add(question7)
        questionList.add(question8)
        questionList.add(question9)
        questionList.add(question10)

        return questionList
    }
}