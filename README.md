NihongoNest - JLPT Study App 🇯🇵

NihongoNest is a comprehensive, all-in-one Android application designed for mastering the Japanese Language Proficiency Test (JLPT), from N5 to N1. It's a "pocket sensei" that combines progress tracking, interactive quizzes, flashcards, and a real-time dictionary into one seamless experience.

This app was built from scratch as a personal portfolio project, demonstrating modern Android development techniques, a scalable architecture, and a complete implementation of a hybrid monetization model.

✨ Core Features

Multi-Level Selection: A beautiful, animated level selection screen (N5-N1) that greets the user on their first launch.

Persistent User Choice: The app remembers the user's selected level, taking them directly to their study hub on subsequent launches.

Dynamic Study Hub: A central StudyScreen that dynamically displays all content (playlists, study materials) relevant to the user's chosen level.

Change Level Option: Users can easily switch their study level at any time from the navigation drawer.

Comprehensive Progress Trackers: Dedicated screens for Vocabulary, Kanji, Grammar, Listening, and Reading for each level. These feature checklists with integrated video links and save the user's progress locally.

Interactive Flashcard System: A full-featured, Quizlet-style flashcard module for N5 and N4. It includes smooth flip animations, "I Know" / "Don't Know" tracking, and score persistence.

Timed MCQ Quizzes: Multiple sets of N5 and N4 Kanji quizzes with a built-in timer to simulate exam conditions. Scores are saved to track improvement.

Real-time Japanese Dictionary: An integrated dictionary that uses the Jisho.org REST API to search for any Japanese word, kanji, or phrase instantly without leaving the app.

Monetization Model:

Banner Ads: A non-intrusive banner ad (via Google AdMob) is placed on the main study screens.

Rewarded Ads: A user-friendly model where premium content (e.g., quizzes 5-10, flashcard lessons 11-25) is locked. Users can unlock this content permanently by choosing to watch a rewarded video ad.

Polished UI/UX:

Built 100% with Jetpack Compose.

Full support for light and dark modes with a custom color theme.

Smooth, modern animations and a horizontal pager for playlist navigation.

🚀 Technologies & Architecture

This project was built using a modern Android tech stack, following best practices.

Language: Kotlin (100%)

UI: Jetpack Compose (for the entire UI)

Architecture: MVVM (Model-View-ViewModel)

State Management: ViewModel and MutableStateFlow to manage and observe UI state.

Navigation: A custom state-based navigation system managing the flow between composable screens.

Networking: Ktor Client for making asynchronous calls to the Jisho REST API.

Data Persistence: SharedPreferences for storing all user progress, including selected level, quiz scores, checklist progress, and unlocked ad-based content.

Monetization: Google AdMob SDK (Banner & Rewarded Ads).

🛠️ Future Scope

The scalable architecture of this app is designed for easy expansion. Future plans include:

N3-N1 Content: Adding the complete data for the remaining JLPT levels.

Gamification: Implementing daily streaks, XP points, and achievement badges to increase user engagement.

Firebase Integration: Adding Firebase Authentication for user accounts and using Firestore to sync user progress across multiple devices.

This app was built as a personal portfolio project by Nitin Kumar.
