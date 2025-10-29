package com.example.yourappname

// We can reuse the VocabLesson data class for our Kanji lessons
// No need to redefine it if it's in the same package.

// --- N-5 KANJI (HINDI) DATA ---
fun getKanjiHindiLessons(): List<VocabLesson> {
    val urls = listOf(
        "https://youtu.be/z99u0eOkyRE?si=0E_WHx76h3i2UIK2", "https://youtu.be/EhHkA7qVa58?si=TYnvGJg-byRNIK1X",
        "https://youtu.be/QM6iMgBLhic?si=C10kFJCtHBlyOidz", "https://youtu.be/c1_XkZpDP7c?si=E-2jHTv0KO24kMUp",
        "https://youtu.be/G7SDYj2X-8I?si=e6pISrOl_Ba9lOLk", "https://youtu.be/sz9rkeQZrV4?si=YRp5fpu2jTxZGNUO",
        "https://youtu.be/LRsC1MugLfM?si=74N4B5RZugz-v9s2", "https://youtu.be/f6oIzfKfOVs?si=zHAogpdVCGugyVgq",
        "https://youtu.be/fzpYkgNt87s?si=sjLeQV0M-Sit_Oc_", "https://youtu.be/LJpWfr5RIoY?si=SBTzF0o5ZRDZ1itP"
    )
    return urls.mapIndexed { index, url ->
        VocabLesson(id = "kanji_hindi_${index + 1}", title = "Kanji Lesson ${index + 1}", youtubeUrl = url)
    }
}

// --- N-5 KANJI (ENGLISH) DATA ---
fun getKanjiEnglishLessons(): List<VocabLesson> {
    return listOf(
        VocabLesson("kanji_eng_1", "Kanji Lesson 1", "https://youtu.be/LUfezJD1t8Q?si=6HLHF6OOw7MJITKb"),
        VocabLesson("kanji_eng_2", "Kanji Lesson 2", "https://youtu.be/tj8ejNPEBJ4?si=ghFtrkUoxtmWvUbJ")
    )
}

// --- N-5 KANJI PRACTICE TEST DATA ---
fun getKanjiPracticeLessons(): List<VocabLesson> {
    val urls = listOf(
        "https://youtu.be/JOMZPPz05dI?si=ye_gSp3qbEaDvJoD", "https://youtu.be/J5gMd11DmXI?si=IsUivWchugSAwM8p",
        "https://youtu.be/F3q6huYxekY?si=hF8sdJeNj3k_h0hB", "https://youtu.be/8YOV5G442Co?si=2f_sk3UhDTvjjA_A",
        "https://youtu.be/66eu9kbuFGw?si=VtjXxSOlKTg_yDdB", "https://youtu.be/B8CCwTGsnQY?si=bCOLkfwwkx2-2GFl"
    )
    return urls.mapIndexed { index, url ->
        VocabLesson(id = "kanji_practice_${index + 1}", title = "Practice Test ${index + 1}", youtubeUrl = url)
    }
}