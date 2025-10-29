package com.example.yourappname

// We reuse the VocabLesson data class from our shared DataModels.kt file.

// --- N4 LISTENING (START) DATA ---
fun getN4ListeningStartLessons(): List<VocabLesson> {
    val urls = listOf(
        "https://youtu.be/Xh3uMWQxJjM?si=LVSht2Fk5U2tj8N0", "https://youtu.be/44Ji5DXEO5o?si=zrzROLcM66DHMKuV",
        "https://youtu.be/KqhQnZH8p2s?si=KZONnV0LwJ6Xmtv8", "https://youtu.be/FUfWknafyac?si=FEUtCP57_vO1Xwpy",
        "https://youtu.be/J2ZD4tjO2gc?si=6WccLUF8-tMt_5Id", "https://youtu.be/iJTLyUfuyw8?si=8gBLG4govxTKQZZP",

    )
    return urls.mapIndexed { index, url ->
        VocabLesson(id = "n4_listen_start_${index + 1}", title = "Listening Practice ${index + 1}", youtubeUrl = url)
    }
}

// --- N4 LISTENING #2 DATA ---
fun getN4ListeningPracticeLessons(): List<VocabLesson> {
    return listOf(
        VocabLesson("n4_listen_practice_1", "N4 Listening #2", "https://www.youtube.com/watch?v=v38qUhLDFTM&list=PLkGU7DnOLgRPxTNFRc7utpuwhWSQC35wC")
    )
}