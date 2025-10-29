package com.example.yourappname

// We reuse the LinkItem data class from our shared DataModels.kt file.

// --- N4 READING PRACTICE WEBSITES DATA ---
fun getN4ReadingWebsites(): List<LinkItem> {
    return listOf(
        LinkItem("Japanesetest4you", "https://japanesetest4you.com/category/jlpt-n4/jlpt-n4-reading-test/"),
        LinkItem("jlptpro", "https://jlptpro.com/course/n4-reading-test-180-26"),
        LinkItem("japanesepage", "https://www.thejapanesepage.com/jlptn4/")
    )
}