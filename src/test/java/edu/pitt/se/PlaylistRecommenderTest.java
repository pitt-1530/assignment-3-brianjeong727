package edu.pitt.se;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class PlaylistRecommenderTest {

    // Test classifyEnergy()
    @Test
    public void testClassifyEnergyHigh() {
        assertEquals("HIGH", PlaylistRecommender.classifyEnergy(Arrays.asList(150, 145, 160)));
    }

    // Test isValidTrackTitle()
    @Test
    public void testValidTrackTitle() {
        assertTrue(PlaylistRecommender.isValidTrackTitle("Hello World"));
        assertFalse(PlaylistRecommender.isValidTrackTitle("Bad!Title"));
        assertFalse(PlaylistRecommender.isValidTrackTitle(null));
    }

    // Test normalizeVolume()
    @Test
    public void testNormalizeVolume() {
        assertEquals(100, PlaylistRecommender.normalizeVolume(150));   // clamp down
        assertEquals(0, PlaylistRecommender.normalizeVolume(-20));     // clamp up
        assertEquals(75, PlaylistRecommender.normalizeVolume(75));     // valid
    }

    // Extra edge-case test for Part 2 requirement
    @Test
    public void testClassifyEnergyRejectEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> PlaylistRecommender.classifyEnergy(Collections.emptyList()));
    }
}
