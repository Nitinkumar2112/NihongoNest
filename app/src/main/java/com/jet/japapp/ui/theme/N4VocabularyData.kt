package com.example.yourappname

// We can reuse the VocabLesson data class from other files.

// --- JLPT N4 VOCAB DATA ---
fun getN4VocabLessons(): List<VocabLesson> {
    val urls = listOf(
        "https://youtu.be/1hTBL59rack?si=4d4S_AZYzq-nsgk1", "https://youtu.be/9Ux_O4xq6yk?si=hLtD--icSnT8Xf67",
        "https://youtu.be/62dGe7T9emE?si=bzl9s13q83Zg3OHI", "https://youtu.be/pQXMFsFOA8M?si=R-J5TqF-dpf8c-GX",
        "https://youtu.be/8BYKgP4VOk4?si=eZ0V3uYvQ8QQTSff", "https://youtu.be/PY69BlGlOp4?si=VtKaeU0bvFCAPb8-",
        "https://youtu.be/DB4ANcw1Pc4?si=_C0hqJvNOnEUs3Wa", "https://youtu.be/bYPcgA7DS6c?si=sui5ygSPmHCzNC4q",
        "https://youtu.be/ddYTP9FQBKA?si=Je1FvleSmPNoqdPz", "https://youtu.be/s7DoNo3dbrE?si=mR0lHJZWfbWSIygI",
        "https://youtu.be/aoXfuwwHIeE?si=kgyIs17lKh4v3cPM", "https://youtu.be/pQ7hwMrPA8U?si=r0NqD-eHkmE4qqJI",
        "https://youtu.be/_lbatkTmzBg?si=Tz0dGmlcOeWQwhfP", "https://youtu.be/L7TgnzRcbiw?si=X-CF3N68SjfOz47t",
        "https://youtu.be/sdzXz5xGeMc?si=Sv5Phbgtcq_KXh6w", "https://youtu.be/chKGz3CMmXs?si=YBd7j_-QI-Y3kRwP",
        "https://youtu.be/ndhfIcWvrKs?si=QLNt5EPKcSwiVY_x", "https://youtu.be/-svkOTzBQBw?si=ZPY4TsLAcJ8bOvNS",
        "https://youtu.be/FCXTpv6B91k?si=BRYyU9Weq6bCqdbH", "https://youtu.be/LE63ErHkaOY?si=GOpZJlqMemEVPyb6",
        "https://youtu.be/heRro8EYoAI?si=kLObP1gmbKAvx9Vq", "https://youtu.be/6bvunzqH898?si=6n7R89Bqg8c2XErL",
        "https://youtu.be/3hs2N0oZRLw?si=LBtp5Eq7ld35P7Kh", "https://youtu.be/qYV1okKHOpI?si=eNucMHUtFAqqQDIK",
        "https://youtu.be/XCTFEUL-abo?si=ITIbu5t8zVWRBD2Q"
    )
    return urls.mapIndexed { index, url ->
        VocabLesson(id = "n4_vocab_${index + 1}", title = "N4 Vocabulary ${index + 1}", youtubeUrl = url)
    }
}

// --- N4 VERB PRACTICE DATA ---
fun getN4VerbLessons(): List<VocabLesson> {
    val urls = listOf(
        "https://youtu.be/eHzwIcpCt4s?si=Bq5mdUUzSZWDUO5a", "https://youtu.be/dJK3xxuhn50?si=LKhViQU5IB-j4viq",
        "https://youtu.be/HmSMRODH1hs?si=4IEY1z3XwCHr0a6W", "https://youtu.be/bwAcylF6NAo?si=ljjzxrPOGXIly6pH",
        "https://youtu.be/xqwdvoWLjqo?si=Lvw0K6OUaOEXtxpc", "https://youtu.be/Rouhbhvr-2A?si=yNa8sd2wIM3JD-KC",
        "https://youtu.be/wdqrU06EQmE?si=j6cpPOAyu_NMyTNG", "https://youtu.be/_SWRfDUQ2VE?si=RZ-YL6q6P8P9jMoZ"
    )
    return urls.mapIndexed { index, url ->
        VocabLesson(id = "n4_verb_${index + 1}", title = "Verb Practice ${index + 1}", youtubeUrl = url)
    }
}

// --- N4 NOUN PRACTICE DATA ---
fun getN4NounLessons(): List<VocabLesson> {
    val urls = listOf(
        "https://youtu.be/TBxprKBpLKM?si=6FaS-qYkD6qEcYyX", "https://youtu.be/-Wn4kDWa_Zc?si=3uCOKCD_5N3z_933",
        "https://youtu.be/KPUSo0R4ukY?si=kxTb2IgYK48COwpp", "https://youtu.be/Vc8Ce00lkxM?si=PVmQLHdU3Lsqfu31",
        "https://youtu.be/vP_dE45o3xY?si=SseLsgpH2xghMaG4", "https://youtu.be/xWgEOMAPTB4?si=ziLjtR3h5aa_5-3c",
        "https://youtu.be/2b5eht6wK1c?si=VDtkAp4w_yaQVzjk", "https://youtu.be/VbhhX1M0Vc0?si=4jMLVQB_p3R5iK1U",
        "https://youtu.be/vJD3zWjcjxM?si=2a8Qyewq7yyGy7Y8", "https://youtu.be/eQTPCO_2sWM?si=cSTQkwLO5tc2OqnI",
        "https://youtu.be/x5jF2gSdzA?si=0wUtoWjgHSEe1pd4", "https://youtu.be/3L1wlDTawfk?si=lu83NXxB7zvWE4Gu",
        "https://youtu.be/lA7z5i2Qc7g?si=X5gNNa1cNcEvthMb"
    )
    return urls.mapIndexed { index, url ->
        VocabLesson(id = "n4_noun_${index + 1}", title = "Noun Practice ${index + 1}", youtubeUrl = url)
    }
}

// --- N4 ADJECTIVE PRACTICE DATA ---
fun getN4AdjectiveLessons(): List<VocabLesson> {
    return listOf(
        VocabLesson("n4_adj_1", "Adjective Practice 1", "https://youtu.be/0YW5qHA4oxA?si=qM3GQ3cRF5_u-jc5"),
        VocabLesson("n4_adj_2", "Adjective Practice 2", "https://youtu.be/jJbmbe6MeKo?si=1yXTqtJP6bRTlMbQ")
    )
}