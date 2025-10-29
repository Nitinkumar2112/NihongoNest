package com.example.yourappname

// This data class is now used for all checklist items
data class VocabLesson(
    val id: String, // Changed to String to be more flexible
    val title: String,
    val youtubeUrl: String
)

// --- MINNA NO NIHONGO DATA ---
fun getMinnaNoNihongoLessons(): List<VocabLesson> {
    val urls = listOf(
        "https://youtu.be/wDpsF90DoeI?si=GM8zUNxnTpXYbOJh", "https://youtu.be/Y13YOdclzMA?si=jDVVkzWTyvOdfK5K",
        "https://youtu.be/ngeRgzef5vs?si=7wlosfsRX7-1YaD-", "https://youtu.be/VdqddfTSNC0?si=igEGU5g0RsQtVVfS",
        "https://youtu.be/1asNdTdCme8?si=GDkUZrLb9zDKtrXz", "https://youtu.be/79xmA0Qd6q4?si=KRWfZP7Qw7r81qDZ",
        "https://youtu.be/RlqS7KW2p8k?si=LtMe_nDUipKWHzuM", "https://youtu.be/cfla_C4KJMg?si=xnw5Q9fZhyU0rGc3",
        "https://youtu.be/7hsqJiF2p_c?si=bHXErT8pO6EXtx_o", "https://youtu.be/xdGCZosnEII?si=u8bBC2n1wfCqftWK",
        "https://youtu.be/JdaoVZ57GbI?si=ktCc-G-fFtDf4Cll", "https://youtu.be/Zx7OT3uLgfo?si=Uhzzj706aG5WYfBZ",
        "https://youtu.be/f1TfjQ3GYgA?si=duiyICD7K7Ozyy7O", "https://youtu.be/3Du66iGE494?si=N-grty47TiPLDWtP",
        "https://youtu.be/CzZJYEam1Oc?si=KCXVMhLmaQ6e3TJf", "https://youtu.be/jOgxIIqeTH4?si=hzmrxTy24o8v4x2D",
        "https://youtu.be/FU4WCJupEQ0?si=pOeA_2jRjj6XmYo9", "https://youtu.be/eR4uzqLmr4I?si=-atKPYssOiFMx6mi",
        "https://youtu.be/YbpUnQeKHAE?si=pzEb4e4M6CPlbjhb", "https://youtu.be/jYn7fAvXI4c?si=jU8Cwgsq_tZK019Y",
        "https://youtu.be/SiUwpKKx-Yg?si=4yMteeRK0kpqqQQL", "https://youtu.be/aRIQL8h-og4?si=VF7Od4oVFREHEOQE",
        "https://youtu.be/tmlqaZY3IPM?si=gRc-laEeuv6qJW8Z", "https://youtu.be/o0tlYEkJhg0?si=ZTYwUei0gw9gwDfB",
        "https://youtu.be/UbzpBQbKN7w?si=ZiUbEv6vmZ_wPNw0"
    )
    return (1..25).map { index ->
        VocabLesson(id = "minna_$index", title = "Minna no Nihongo L$index Vocab", youtubeUrl = urls[index - 1])
    }
}

// --- NEW: VERB PRACTICE DATA ---
fun getVerbPracticeLessons(): List<VocabLesson> {
    return listOf(
        VocabLesson("verb_1", "Verb Practice 1", "https://youtu.be/Qfygc9N9-9I?si=pp1Q2KmcLDl_XlG4"),
        VocabLesson("verb_2", "Verb Practice 2", "https://youtu.be/Je8SaJgzg6I?si=nQFTBcJKUBcCoFa_"),
        VocabLesson("verb_3", "Verb Practice 3", "https://youtu.be/3258PUojTRc?si=seLq-Snxmhbg0kkB"),
        VocabLesson("verb_4", "Verb Practice 4", "https://youtu.be/aYTmnro-3bs?si=LVcxhS5W2KWC0jZM")
    )
}

// --- NEW: NOUN PRACTICE DATA ---
fun getNounPracticeLessons(): List<VocabLesson> {
    return listOf(
        VocabLesson("noun_1", "Noun Practice 1", "https://youtu.be/d-mGicpHC78?si=svcV7kSDXh94nhX7"),
        VocabLesson("noun_2", "Noun Practice 2", "https://youtu.be/NoQSs7KFbpM?si=qepg3_E_dZIAP7eK"),
        VocabLesson("noun_3", "Noun Practice 3", "https://youtu.be/gKwoU3kKrUc?si=oWRXfpMMrPPq6VHQ"),
        VocabLesson("noun_4", "Noun Practice 4", "https://youtu.be/Pba_dZZlKG0?si=hQVeCvKpYjd2Sk6e")
    )
}

// --- NEW: FLASHCARD DATA ---
fun getFlashcardLessons(): List<VocabLesson> {
    return listOf(
        VocabLesson("flash_1", "N5 Flashcards 1", "https://youtu.be/NP8jt6K_uFc?si=RTsAlLMEwP5inR0S"),
        VocabLesson("flash_2", "N5 Flashcards 2", "https://youtu.be/rbwoMGPIXHQ?si=GJsbit_gD0O79bxP"),
        VocabLesson("flash_3", "N5 Flashcards 3", "https://youtu.be/JW_5cx0sP4Q?si=-EDXLF9DEaC7Pl6I"),
        VocabLesson("flash_4", "N5 Flashcards 4", "https://youtu.be/43gMFM2WJqE?si=vqDWzc29mGyKaJm2"),
        VocabLesson("flash_5", "N5 Flashcards 5", "https://youtu.be/jX7va0hcfFE?si=qAQXErFmJfQjgAN_")
    )
}