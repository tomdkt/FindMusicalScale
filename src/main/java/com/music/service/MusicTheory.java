package com.music.service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.music.domain.Note;

public class MusicTheory {
    public static final List<String> SHARP_NOTES = List.of("C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B");
    public static final List<String> FLAT_NOTES = List.of("C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab", "A", "Bb", "B");
    private static final List<String> FLAT_KEYS = List.of("F", "Bb", "Eb", "Ab", "Db", "Gb", "Cb");
    private static final Map<String, Integer> NOTE_VALUES = new HashMap<>();

    static {
        for (int i = 0; i < 12; i++) {
            NOTE_VALUES.put(SHARP_NOTES.get(i), i);
            NOTE_VALUES.put(FLAT_NOTES.get(i), i);
        }
    }

    public static Note getNoteByName(String name) {
        if (!NOTE_VALUES.containsKey(name)) {
            throw new IllegalArgumentException("Unknown note name: " + name);
        }
        return new Note(name, NOTE_VALUES.get(name));
    }

    public static Note getNoteByValue(int value, boolean useFlats) {
        String name = useFlats ? FLAT_NOTES.get(value) : SHARP_NOTES.get(value);
        return new Note(name, value);
    }

    public static boolean shouldUseFlats(String keyName) {
        return FLAT_KEYS.contains(keyName);
    }
}