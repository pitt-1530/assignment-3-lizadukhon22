package edu.pitt.se;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class PlaylistRecommenderTest {

    @Test
     public void testClassifyEnergyHigh() {
        PlaylistRecommender playlistRecommender = new PlaylistRecommender();
        assertEquals("HIGH", playlistRecommender.classifyEnergy(List.of(150, 145, 160)), "For values 150, 145, and 160, it must return HIGH");
    }

     @Test
    public void testClassifyEnergyMedium() {
        PlaylistRecommender playlistRecommender = new PlaylistRecommender();
        assertEquals("MEDIUM", playlistRecommender.classifyEnergy(List.of(120, 110, 130)), "For values 120, 110, and 130, it must return MEDIUM");
    }

    @Test
    public void testClassifyEnergyLow() {
        PlaylistRecommender playlistRecommender = new PlaylistRecommender();
        assertEquals("LOW", playlistRecommender.classifyEnergy(List.of(80, 90, 70)), "For values 80, 90, and 70, it must return LOW");
    }

    @Test
    public void testClassifyEnergyEmptyList() {
        PlaylistRecommender playlistRecommender = new PlaylistRecommender();
        assertThrows(IllegalArgumentException.class, () -> playlistRecommender.classifyEnergy(Collections.emptyList()), "For empty list it must throw exception");
    }

    @Test
    public void testIsValidTrackTitleValid() {
        PlaylistRecommender playlistRecommender = new PlaylistRecommender();
        assertTrue(playlistRecommender.isValidTrackTitle("Favorite Song"));
    }

    @Test
    public void testIsValidTrackTitleNull() {
        PlaylistRecommender playlistRecommender = new PlaylistRecommender();
        assertFalse(playlistRecommender.isValidTrackTitle(null));
    }

    @Test
    public void testNormalizeVolumeWithinRange() {
        PlaylistRecommender playlistRecommender = new PlaylistRecommender();
        assertEquals(50, playlistRecommender.normalizeVolume(50));
    }

    @Test
    public void testNormalizeVolumeAboveMax() {
        PlaylistRecommender playlistRecommender = new PlaylistRecommender();
        assertEquals(100, playlistRecommender.normalizeVolume(120));
    }

}
