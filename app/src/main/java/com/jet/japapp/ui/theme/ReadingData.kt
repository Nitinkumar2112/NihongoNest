package com.example.yourappname

// We reuse the VocabLesson and LinkItem data classes from other files.

// --- N5 READING (ENGLISH) DATA ---
fun getReadingEnglishLessons(): List<VocabLesson> {
    return listOf(
        VocabLesson("read_eng_1", "Reading Lesson 1 (English)", "https://youtu.be/6wA_VFsA4NA?si=RFyt6SkeyRwLimo_"),
        VocabLesson("read_eng_2", "Reading Lesson 2 (English)", "https://youtu.be/Hb_QUwpy0WQ?si=cs2Wuf9j7id1gXQE"),
        VocabLesson("read_eng_3", "Reading Lesson 3 (English)", "https://youtu.be/IoHfjHBJcdE?si=57wqOw40CSk0oADG")
    )
}

// --- N5 READING (HINDI) DATA ---
fun getReadingHindiLessons(): List<VocabLesson> {
    val urls = listOf(
        "https://youtu.be/cfEMzuc2f2o?si=k2cggroy7wOEEJ4h", "https://youtu.be/a8mTnBx_Wrc?si=flW7oUUZlnUcOxIQ",
        "https://youtu.be/aUPOTcT_uDw?si=Xezzv2C8-wqoh6-o", "https://youtu.be/mKIX-g0ymCE?si=uF01SJr0Xucrki6O",
        "https://youtu.be/-D2B3PDbAls?si=cyZ7qnmSNEHdbCul", "https://youtu.be/eYSDQSnwTsk?si=_TFq4LZEUkgbrADe",
        "https://youtu.be/cfEMzuc2f2o?si=9IzPO1ydcZcSNPGb", "https://youtu.be/AVdNJYTmZMw?si=22O4FMmcRY0B7Dee",
        "https://youtu.be/fYNzMOIaIeg?si=8uYw0RfSJ_TYxRYt", "https://youtu.be/3X-ACDQRV1g?si=Dl1DmIK1V9VaNH_V"
    )
    return urls.mapIndexed { index, url ->
        VocabLesson(id = "read_hindi_${index + 1}", title = "Reading Lesson ${index + 1} (Hindi)", youtubeUrl = url)
    }
}

// --- PRACTICE WEBSITES (LINKS ONLY) DATA ---
fun getReadingWebsites(): List<LinkItem> {
    return listOf(
        LinkItem("Japanesetest4you", "https://japanesetest4you.com/category/jlpt-n5/jlpt-n5-reading-tests/"),
        LinkItem("jlptpro", "https://jlptpro.com/course/n5-reading-test-174-24"),
        LinkItem("japanesepage", "https://www.thejapanesepage.com/jlpt-n5-reading/")
    )
}