package com.music.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration test for the ChordTransposerFacade.
 * This test verifies that the facade correctly orchestrates the parsing and
 * transposition services to produce the expected output.
 */
class ChordTransposerFacadeTest {

    private ChordTransposerFacade transposer;

    @BeforeEach
    void setUp() {
        transposer = new ChordTransposerFacade();
    }

    @Test
    @DisplayName("Should transpose progression from A to F correctly (like in main)")
    void shouldTransposeProgressionLikeInMain() {
        // Arrange
        String originalProgression = "A G A7 D/E";
        String newKey = "F";
        String expectedProgression = "F Eb F7 Bb/C";

        // Act
        String actualProgression = transposer.transposeProgression(originalProgression, newKey);

        // Assert
        assertNotNull(actualProgression, "The result should not be null.");
        assertEquals(expectedProgression, actualProgression, "The transposed progression is incorrect.");
    }

    @Test
    @DisplayName("Should transpose progression from C to G correctly")
    void shouldTransposeProgressionFromCToG() {
        // Arrange
        String originalProgression = "C F G7 Am";
        String newKey = "G";
        String expectedProgression = "G C D7 Em";

        // Act
        String actualProgression = transposer.transposeProgression(originalProgression, newKey);

        // Assert
        assertEquals(expectedProgression, actualProgression);
    }

    @Test
    @DisplayName("Should handle progressions with sharps and flats")
    void shouldHandleSharpsAndFlats() {
        // Arrange
        String originalProgression = "Db Ab Bbm Gb";
        String newKey = "E";
        String expectedProgression = "E B C#m A";

        // Act
        String actualProgression = transposer.transposeProgression(originalProgression, newKey);

        // Assert
        assertEquals(expectedProgression, actualProgression);
    }

    @Test
    @DisplayName("Should throw an exception for invalid chord format")
    void shouldThrowExceptionForInvalidChord() {
        // Arrange
        String invalidProgression = "C G Zm F"; // 'Z' is not a valid note
        String newKey = "D";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () ->
            transposer.transposeProgression(invalidProgression, newKey),
            "An invalid chord should cause an IllegalArgumentException."
        );
    }
}