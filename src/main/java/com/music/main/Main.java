package com.music.main;

import com.music.app.ChordTransposerFacade;

public class Main {
    public static void main(String[] args) {
        String originalProgression = "A G A7 D/E";
        String newKey = "F";

        ChordTransposerFacade transposer = new ChordTransposerFacade();
        String result = transposer.transposeProgression(originalProgression, newKey);

        System.out.println("Original: " + originalProgression);
        System.out.println("New Key: " + newKey);
        System.out.println("Transposed: " + result);
    }
}