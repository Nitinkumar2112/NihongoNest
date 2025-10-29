package com.example.yourappname

import android.annotation.SuppressLint
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

// Data classes that match the structure of the Jisho API's JSON response
@SuppressLint("UnsafeOptInUsageError")
@Serializable
data class JishoResponse(val data: List<JishoResult>)

@SuppressLint("UnsafeOptInUsageError")
@Serializable
data class JishoResult(
    val slug: String,
    val japanese: List<JapaneseWord>,
    val senses: List<Sense>
)

@SuppressLint("UnsafeOptInUsageError")
@Serializable
data class JapaneseWord(
    val word: String? = null,
    val reading: String? = null
)

@SuppressLint("UnsafeOptInUsageError")
@Serializable
data class Sense(
    @SerialName("english_definitions")
    val englishDefinitions: List<String>,
    @SerialName("parts_of_speech") // Added for correct JSON mapping
    val partsOfSpeech: List<String> = emptyList() // This makes the field optional
)


// This object handles the actual API call
object DictionaryService {
    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true // The API has more fields than we need
            })
        }
    }

    suspend fun searchWord(query: String): List<JishoResult> {
        try {
            val response: JishoResponse = client.get("https://jisho.org/api/v1/search/words") {
                parameter("keyword", query)
            }.body()
            return response.data
        } catch (e: Exception) {
            e.printStackTrace()
            return emptyList() // Return an empty list if there's an error
        }
    }
}