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
    private final ChordParser parser;
    private final TranspositionService service;

    public ChordTransposerFacade() {
        this.parser = new ChordParser();
        this.service = new TranspositionService();
    }

    public String transposeProgression(String progression, String newKeyName) {
        String[] chordStrings = progression.trim().split("\\s+");

        Chord firstChord = parser.parse(chordStrings[0]);
        Note originalKey = firstChord.getRootNote();
        Note newKey = MusicTheory.getNoteByName(newKeyName);

        int interval = service.calculateInterval(originalKey, newKey);
        boolean useFlats = MusicTheory.shouldUseFlats(newKey.getName());

        return Arrays.stream(chordStrings)
            .map(chordStr -> {
                Chord originalChord = parser.parse(chordStr);
                Chord transposedChord = service.transposeChord(originalChord, interval, useFlats);
                return transposedChord.toString();
            })
            .collect(Collectors.joining(" "));
    }
}