package com.example.yourappname

// We can reuse the VocabLesson data class for our Grammar lessons.

// --- JLPT N5 GRAMMAR DATA ---
fun getGrammarLessons(): List<VocabLesson> {
    val urls = listOf(
        "https://youtu.be/gi2AeYO-g8E?si=fYsN3Gjtg4-7dx6j", "https://youtu.be/9EfbkBkF2ag?si=EVKnuRDvmIY_BxUo",
        "https://youtu.be/CVFL1QHVQ0w?si=Nqq72Z0BWXVONkbn", "https://youtu.be/BQkKnypu8f0?si=rX1a90TloDPobabC",
        "https://youtu.be/QPOrt1BQm-g?si=s_Lr190m53LoRvlu", "https://youtu.be/Zocvund8ypA?si=hsrAfKb8UHSunE1e",
        "https://youtu.be/O47kv14SxDk?si=KDlnyBS5hpx375QZ", "https://youtu.be/5HKxjeyBsR8?si=y9bDep12B5ThC3Dh",
        "https://youtu.be/sGy7kONKYYY?si=cwkqGlGV66RS6ZsK", "https://youtu.be/rAccyp4k7hs?si=rdj4EeVBjxkG9DPZ",
        "https://youtu.be/eznaZWtbZCU?si=oWjwibYnrK4lBRnB", "https://youtu.be/9Flpshd24iQ?si=cujG6qLZd6VIzN98",
        "https://youtu.be/xb2fX6N8DZE?si=vMKBiVys86HCP3kh", "https://youtu.be/3Du66iGE494?si=Fm1w4lgnQqFrzITA",
        "https://youtu.be/V4WcIyAnXWc?si=FwwFrCakvMPd6kL_", "https://youtu.be/FQN_kcNrkFM?si=GLHJ3yVy4Lr2hTk_",
        "https://youtu.be/1mtwbsaGcqc?si=_B1vnvVh4TkzvQvk", "https://youtu.be/d3VDTwG6XVQ?si=Sce3f0ycp_-m5HrC",
        "https://youtu.be/YKrfN6F2lSM?si=n4CkQuRPFyU1tqIE", "https://youtu.be/ODMdedcDu-E?si=R6H6bbi5ks11Fc8d",
        "https://youtu.be/PvB2X-bif5w?si=8GJlbs4WalvwmDKr", "https://youtu.be/TDGQeL5P-Jo?si=M5nmFQCEl9BFwgDt",
        "https://youtu.be/n--9cPF0ris?si=Nl-Va2dKI5SH5S50", "https://youtu.be/h1L3TOXabMg?si=6K_PtWb5jpnLLVtM",
        "https://youtu.be/C7vvYM9JVMQ?si=2d1LWt181LDh_KlD"
    )
    return urls.mapIndexed { index, url ->
        VocabLesson(id = "grammar_lesson_${index + 1}", title = "Grammar Lesson ${index + 1}", youtubeUrl = url)
    }
}

// --- GRAMMAR PRACTICE QUESTIONS DATA ---
fun getGrammarPracticeLessons(): List<VocabLesson> {
    val urls = listOf(
        "https://youtu.be/cH7w2x1WiP0?si=EbE9FOesUve4efq0", "https://youtu.be/oPIHtN2aQkE?si=zxTr8etQBA4NlbXm",
        "https://youtu.be/WJeQiRBcaCU?si=00J5fZYbw4nRUWGW", "https://youtu.be/e5c8bGAb7rY?si=OkyEX1oSBjdm9xsC",
        "https://youtu.be/M-uM3yHOjIk?si=qMnbwGL4ExxNN6mg", "https://youtube.com/playlist?list=PLNvO44FzxiEc-2043fEulmb7IoCJvYlyo&si=CGchzmUBRS9iZuE7"
    )
    return urls.mapIndexed { index, url ->
        VocabLesson(id = "grammar_practice_${index + 1}", title = "Practice Questions ${index + 1}", youtubeUrl = url)
    }
}

// --- ONE SHOT VIDEOS DATA ---
fun getOneShotLessons(): List<VocabLesson> {
    return listOf(
        VocabLesson("one_shot_1", "One Shot Video 1", "https://youtu.be/MByHVq3D6hM?si=Ur5BZBe-3rL88gqk"),
        VocabLesson("one_shot_2", "One Shot Video 2", "https://youtu.be/_ojVS-KgDEg?si=T6V9xGd5S8DG7mXy")
    )
}