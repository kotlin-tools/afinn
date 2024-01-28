# Afinn

Sentiment analysis in Kotlin.

Dictionaries included:
- English Language 🇬🇧
- Danish Language 🇩🇰
- Emoticons :) :/ :(
- Emojis 🤣 🤤 👿

## Installation

### Gradle

Add this line to your project's dependencies:

```kotlin
implementation("org.afinn:afinn:1.0.0")
```

### Maven

Add the following dependency to your pom.xml file:

```xml
<dependency>
    <groupId>org.afinn</groupId>
    <artifactId>afinn</artifactId>
    <version>1.0.0</version>
</dependency>
```

Or install it yourself as:

    $ mvn install org.afinn:afinn:1.0.0

## Usage

```kotlin
import org.afinn.Afinn

val afinn = Afinn(language = "da", emoticons = true)
println(afinn.score("Hvis ikke det er det mest afskyelige flueknepperi..."))
// Output: -8.0

val afinnEnglish = Afinn(language = "en")
println(afinnEnglish.scoreToWords("I had a slow puncture that needed attending to and they took care of it very well. Friendly and efficient staff and a clean and tidy work area. Happy to recommend them and will use them in the future."))
// Output: "Positive"
```

## Dictionaries

The dictionaries used in this repository are from a project by Finn Årup Nielsen:
https://github.com/fnielsen/afinn/tree/master/afinn/data

For more information visit:
http://corpustext.com/reference/sentiment_afinn.html

Paper with supplement: http://www2.imm.dtu.dk/pubdb/views/edoc_download.php/6006/pdf/imm6006.pdf

## Similar libraries in other programming languages

* https://github.com/fnielsen/afinn - Sentiment analysis in Python with AFINN word list
* https://github.com/darenr/afinn - Sentiment analysis in JavaScript with AFINN word list
* https://github.com/prograils/afinn - Sentiment analysis in Ruby with AFINN word list
* https://github.com/kupolak/afinn - Sentiment analysis in Elixir with AFINN word list

## Contributing

Bug reports and pull requests are welcome on GitHub at Afinn GitHub Repository.