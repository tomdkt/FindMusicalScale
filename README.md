# Java Chord Transposer

A robust Java library for transposing musical chord progressions. It correctly handles complex chords (e.g., m7, 7, slash chords), sharps, and flats, following music theory rules.

## Features

- Transposes chord progressions to any of the 12 musical keys.
- Correctly handles sharps (`#`) and flats (`b`).
- Parses complex chord qualities (e.g., `m7`, `dim`, `aug`).
- Supports slash chords (e.g., `G/B`).
- Built with modern Java and managed with Maven.
- Well-tested with JUnit 5.

## Quick Start

Using the `ChordTransposerFacade` is straightforward.

```java
import com.music.app.ChordTransposerFacade;

public class Example {
    public static void main(String[] args) {
        ChordTransposerFacade transposer = new ChordTransposerFacade();

        String originalProgression = "A G A7 D/E";
        String newKey = "F";

        String result = transposer.transposeProgression(originalProgression, newKey);

        // Expected output: "F Eb F7 Bb/C"
        System.out.println(result);
    }
}
```

## Building from Source

This project uses Apache Maven. To build the project and run the tests, execute the following command from the project's root directory:

```bash
mvn clean install
```