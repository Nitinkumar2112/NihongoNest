package com.example.yourappname

// New, simple data class for items that are just links
data class LinkItem(
    val title: String,
    val youtubeUrl: String
)

// --- N5 LISTENING (START) DATA ---
fun getListeningStartLessons(): List<VocabLesson> {
    val urls = listOf(
        "https://youtu.be/yyx7uVQyx5M?si=AXxo4ipUXem2ybTY", "https://youtu.be/MI7nchXV_wY?si=5R2V37W-MGW9VZfL",
        "https://youtu.be/-N93OI6pNPQ?si=yp6h9rnfilltlNO3", "https://youtu.be/mnUrasDSMao?si=Fr6EIooPb07-zess",
        "https://youtu.be/tcg8KZHuDsY?si=yG4F2JOg_Q4YthPc", "https://youtu.be/w4wS7eI9FwM?si=PTTZXCWNq4FQaDmt",
        "https://youtu.be/NqFT72wRLpg?si=wCXZb_-_NRcPsfzm"
    )
    return urls.mapIndexed { index, url ->
        VocabLesson(id = "listen_start_${index + 1}", title = "Listening Practice ${index + 1}", youtubeUrl = url)
    }
}

// --- N5 LISTENING #2 DATA ---
fun getListeningPracticeLessons(): List<VocabLesson> {
    return listOf(
        VocabLesson("listen_practice_1", "N5 Listening #2", "https://youtube.com/playlist?list=PLkGU7DnOLgRMl-h4NxxrGbK-UdZHIXzKQ&si=U3tGIi79zyzicu4M")
    )
}

// --- BEST CHANNELS (LINKS ONLY) DATA ---
fun getListeningChannels(): List<LinkItem> {
    return listOf(
        LinkItem("Speak Japanese Naturally", "https://www.youtube.com/@SpeakJapaneseNaturally/videos"),
        LinkItem("Waku Waku Japanese", "https://www.youtube.com/@wakuwakujapanese/videos"),
        LinkItem("Konbini Confession", "https://www.youtube.com/@KONBINICONFESSIONS")
    )
}