package com.music.parsing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.music.domain.Chord;
import com.music.domain.Note;
import com.music.service.MusicTheory;

public class ChordParser {
    // Regex to capture root note, quality, and optional bass note.
    private static final Pattern CHORD_PATTERN = Pattern.compile("([A-G][#b]?)([^/]*)(?:/([A-G][#b]?))?");

    public Chord parse(String chordString) {
        Matcher matcher = CHORD_PATTERN.matcher(chordString);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid chord format: " + chordString);
        }

        String rootName = matcher.group(1);
        String quality = matcher.group(2);
        String bassName = matcher.group(3);

        Note rootNote = MusicTheory.getNoteByName(rootName);
        Note bassNote = (bassName != null) ? MusicTheory.getNoteByName(bassName) : null;

        return new Chord(rootNote, quality, bassNote);
    }
}