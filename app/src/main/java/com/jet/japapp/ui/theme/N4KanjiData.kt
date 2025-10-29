package com.example.yourappname

// We reuse the VocabLesson data class from other files.

// --- N-4 KANJI DATA ---
fun getN4KanjiLessons(): List<VocabLesson> {
    return listOf(
        VocabLesson(id = "n4_kanji_1", title = "N-4 Kanji", youtubeUrl = "https://www.youtube.com/watch?v=mzioPtNiJxQ&list=PLVanfR33flREa7PA7bwhozJH-WjRSixcr")
    )
}

// --- N-4 KANJI READING PRACTICE DATA ---
fun getN4KanjiReadingPractice(): List<VocabLesson> {
    return listOf(
        VocabLesson(id = "n4_kanji_reading_1", title = "N-4 Kanji Reading Practice", youtubeUrl = "https://www.youtube.com/watch?v=lAcOugXl5t8&list=PLwLWi85AM8x9EORyBb0bvOZlcDKpjFhk_")
    )
}

// --- N-4 KANJI PRACTICE TEST DATA ---
fun getN4KanjiPracticeTest(): List<VocabLesson> {
    return listOf(
        VocabLesson(id = "n4_kanji_test_1", title = "N-4 Kanji Practice Test", youtubeUrl = "https://www.youtube.com/watch?v=oFlEPzMGsu8&list=PLb2UCnI22u9mHavsoX5Q7NJ8EbDijimkH")
    )
}