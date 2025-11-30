package edu.pitt.se;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class PlaylistRecommenderTest {

    @Test
     public void testClassifyEnergyHigh() {
        assertEquals("HIGH", PlaylistRecommender.classifyEnergy(List.of(150, 145, 160)), "For values 150, 145, and 160, it must return HIGH");
    }

     @Test
    public void testClassifyEnergyMedium() {
        assertEquals("MEDIUM", PlaylistRecommender.classifyEnergy(List.of(120, 110, 130)), "For values 120, 110, and 130, it must return MEDIUM");
    }

    @Test
    public void testClassifyEnergyLow() {
        assertEquals("LOW", PlaylistRecommender.classifyEnergy(List.of(80, 90, 70)), "For values 80, 90, and 70, it must return LOW");
    }

    // @Test
    // public void testClassifyEnergyEmptyList() {
    //     assertThrows(IllegalArgumentException.class, () -> PlaylistRecommender.classifyEnergy(Collections.emptyList()), "For empty list it must throw exception");
    // }

    @Test
    public void testIsValidTrackTitleValid() {
        assertTrue(PlaylistRecommender.isValidTrackTitle("Favorite Song"));
    }

    @Test
    public void testIsValidTrackTitleNull() {
        assertFalse(PlaylistRecommender.isValidTrackTitle(null));
    }

    @Test
    public void testNormalizeVolumeWithinRange() {
        assertEquals(50, PlaylistRecommender.normalizeVolume(50));
    }

    @Test
    public void testNormalizeVolumeAboveMax() {
        assertEquals(100, PlaylistRecommender.normalizeVolume(120));
    }

}
