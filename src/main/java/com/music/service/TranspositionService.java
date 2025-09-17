package com.music.service;

import com.music.domain.Chord;
import com.music.domain.Note;

public class TranspositionService {

    public int calculateInterval(Note fromNote, Note toNote) {
        return toNote.getValue() - fromNote.getValue();
    }

    public Note transposeNote(Note originalNote, int interval, boolean useFlats) {
        int newValue = (originalNote.getValue() + interval + 12) % 12;
        return MusicTheory.getNoteByValue(newValue, useFlats);
    }

    public Chord transposeChord(Chord originalChord, int interval, boolean useFlats) {
        Note newRoot = transposeNote(originalChord.getRootNote(), interval, useFlats);

        Note newBass = null;
        if (originalChord.getBassNote() != null) {
            newBass = transposeNote(originalChord.getBassNote(), interval, useFlats);
        }

        return new Chord(newRoot, originalChord.getQuality(), newBass);
    }
}