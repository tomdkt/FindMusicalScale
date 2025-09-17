package com.music.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Chord {
    private final Note rootNote;
    private final String quality; // e.g., "m", "7", "maj7"
    private final Note bassNote;  // Can be null


    @Override
    public String toString() {
        if (bassNote != null) {
            return rootNote.getName() + quality + "/" + bassNote.getName();
        }
        return rootNote.getName() + quality;
    }
}