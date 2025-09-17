package com.music.app;

// package com.music.app;

import java.util.Arrays;
import java.util.stream.Collectors;
 import com.music.domain.Chord;
 import com.music.domain.Note;
 import com.music.parsing.ChordParser;
 import com.music.service.MusicTheory;
 import com.music.service.TranspositionService;


public class ChordTransposerFacade {
    // These are the dependencies of the facade.
    private final ChordParser parser;
    private final TranspositionService service;

    public ChordTransposerFacade() {
        this.parser = new ChordParser();
        this.service = new TranspositionService();
    }

    public String transposeProgression(String progression, String newKeyName) {
        String[] chordStrings = progression.trim().split("\\s+");

        // 1. Determine the original key and new key as Note objects.
        Chord firstChord = parser.parse(chordStrings[0]);
        Note originalKey = firstChord.getRootNote();
        Note newKey = MusicTheory.getNoteByName(newKeyName);

        // 2. Use the service to calculate the interval.
        int interval = service.calculateInterval(originalKey, newKey);
        boolean useFlats = MusicTheory.shouldUseFlats(newKey.getName());

        // 3. Map each chord string to its transposed version.
        return Arrays.stream(chordStrings)
            .map(chordStr -> {
                Chord originalChord = parser.parse(chordStr);
                Chord transposedChord = service.transposeChord(originalChord, interval, useFlats);
                return transposedChord.toString();
            })
            .collect(Collectors.joining(" "));
    }
}