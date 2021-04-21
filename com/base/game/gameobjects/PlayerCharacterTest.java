package com.base.game.gameobjects;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerCharacterTest {

    @Test
    public void CharacterConstructor() {

        final PlayerCharacter player = new PlayerCharacter(384.0F, 284.0f);
        assertEquals(1, player.getLevel());
        assertEquals(5, player.getStrength());
        assertEquals(40, player.getHP());
        assertEquals(5, player.getDefense());
        assertEquals(0, player.getExperience());
        assertEquals(50, player.getThreshold());
    }

    @Test
    public void levelUp() {
        final PlayerCharacter player = new PlayerCharacter(384.0F, 284.0f);
        player.setExperience(50);
        assertEquals(2, player.getLevel());
        assertEquals(7, player.getStrength());
        assertEquals(50, player.getHP());
        assertEquals(7, player.getDefense());
        assertEquals(50, player.getExperience());
        assertEquals(100, player.getThreshold());

        player.setExperience(50);
        assertEquals(3, player.getLevel());
        assertEquals(9, player.getStrength());
        assertEquals(72, player.getHP());
        assertEquals(9, player.getDefense());
        assertEquals(100, player.getExperience());
        assertEquals(200, player.getThreshold());
    }
}