package org.afinn

/**
 * LANGUAGE_FILE_MAP is a constant map that associates language codes with their respective dictionary filenames.
 * It is used in the sentiment analysis tool for loading dictionaries based on the specified language.
 */
val LANGUAGE_FILE_MAP = mapOf(
    "da" to "da.txt",
    "en" to "en.txt",
    "emoticons" to "emoticons.txt",
    "emojis" to "emojis.txt"
)
