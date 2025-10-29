package com.example.yourappname

// We reuse the VocabLesson data class from our shared DataModels.kt file.

// --- JLPT N4 GRAMMAR DATA ---
fun getN4GrammarLessons(): List<VocabLesson> {
    val urls = listOf(
        "https://youtu.be/Ly3Tn2MkHIQ?si=IIkd0PXXojAOmcmj", "https://youtu.be/Y6XkLTEbmR8?si=X_qhZASXULZfA7x_",
        "https://youtu.be/pOrBePf-3pM?si=fWrxu08DyndLXGV-", "https://youtu.be/iIVraKWfdE4?si=Uu3SRI46AiDi2Zwu",
        "https://youtu.be/vY32ZM1gMpw?si=2fWmDqcAwSWbh-mt", "https://youtu.be/L7UK0QZTK9A?si=4QbvAeCH8YLmBfVw",
        "https://youtu.be/uUSw9a44k-g?si=0vss2fmjWqpA5SmT", "https://youtu.be/K2sbYid6xAU?si=WRYNonIDAAvYt0lv",
        "https://youtu.be/Jw4eVCeMBHY?si=TK8KvV3WVlidvBCR", "https://youtu.be/vRmU4O76wC0?si=vt3n_uTqvb6Mm-L-",
        "https://youtu.be/G1Rx8AAgp0E?si=IBNBatB7trXJUv3D", "https://youtu.be/8-NTxX55axw?si=XepvC0jnAd7lHdeg",
        "https://youtu.be/g0GN5ZeVoh8?si=3hDf8pxyFeBOKB41", "https://youtu.be/nypF3YqcVlk?si=mtSCHL8fkW-sQq8h",
        "https://youtu.be/0jV6UI7aHfI?si=pbxnh2Hig2cGxfJ3", "https://youtu.be/YipAd3VGLo0?si=RbRvbnFPUQWYfUeL",
        "https://youtu.be/L1_bvjIwK-s?si=E9YhM_QEYAtxyBKU", "https://youtu.be/RDpQyimXcFU?si=Jw7uzS1HtAJUVPhW",
        "https://youtu.be/AP8lcXvV6yQ?si=edv4K6MqjMIi2tzx", "https://youtu.be/nfcF4W63vBE?si=BPTTw1iqkB72Ux44",
        "https://youtu.be/UqcFJe7WWj0?si=mkgQQ0FEgxVVGWCi", "https://youtu.be/LKgfJbtNMqs?si=JfpPeyGlqcnGYelI",
        "https://youtu.be/bjZwDp7_frI?si=MA2NfoBNu6241jlh", "https://youtu.be/X2S3riEHLk4?si=TcF5NiEUDvIcQsGx",
        "https://youtu.be/P--C6hOmI9A?si=KoRsK5Au2G0DBNMz"
    )
    return urls.mapIndexed { index, url ->
        VocabLesson(id = "n4_grammar_${index + 1}", title = "Grammar Lesson ${index + 1}", youtubeUrl = url)
    }
}

// --- GRAMMAR PRACTICE QUESTIONS DATA ---
fun getN4GrammarPracticeLessons(): List<VocabLesson> {
    return listOf(
        VocabLesson("n4_gram_practice_1", "Grammar Practice", "https://www.youtube.com/watch?v=NZ5lN_cv9ew&list=PLwLWi85AM8x8B0syUoj0svy8rwAzeV2un")
    )
}

// --- ONE SHOT VIDEOS DATA ---
fun getN4OneShotLessons(): List<VocabLesson> {
    return listOf(
        VocabLesson("n4_one_shot_2", "One Shot Video 2", "https://youtu.be/5Yt6Eo40GQ4?si=poNkCHvyt1-RuL2f")
    )
}