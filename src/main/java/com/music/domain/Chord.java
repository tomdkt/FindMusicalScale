package com.music.domain;

public class Chord {
    private final Note rootNote;
    private final String quality; // e.g., "m", "7", "maj7"
    private final Note bassNote;  // Can be null

    public Chord(Note rootNote, String quality, Note bassNote) {
        this.rootNote = rootNote;
        this.quality = quality;
        this.bassNote = bassNote;
    }

    public Note getRootNote() { return rootNote; }
    public String getQuality() { return quality; }
    public Note getBassNote() { return bassNote; }

    @Override
    public String toString() {
        if (bassNote != null) {
            return rootNote.getName() + quality + "/" + bassNote.getName();
        }
        return rootNote.getName() + quality;
    }
}