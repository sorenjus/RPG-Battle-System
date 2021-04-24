package com.base.game.gameobjects;

import com.base.game.item.Sword;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import static com.base.engine.Main.initGame;

/**
 * A test class for PlayerCharacter class
 *
 * @author Justin Soreen
 */
public class PlayerCharacterTest {

    /**
     * Test the constructor of player and all attributes and player position
     */
    @Test
    public void characterConstructor() {

        initGame();

        final PlayerCharacter player = new PlayerCharacter(384.0F, 284.0f);
        final Sword sword = new Sword(390.0F,280.0F);
        assertEquals(1, player.getLevel());
        assertEquals(3, player.getStrength());
        assertEquals(10, player.getHP());
        assertEquals(1, player.getDefense());
        assertEquals(0, player.getExperience());
        assertEquals("Lonk", player.getName());
        assertEquals(384, player.getX());
        assertEquals(284, player.getY());



    }

    /**
     * Test the level up mechanic
     */
    @Test
    public void levelUp() {

        final PlayerCharacter player = new PlayerCharacter(384.0F, 284.0f);
        player.stats.setExperience(50);//NOPMD
        assertEquals(2, player.getLevel());
        assertEquals(5, player.getStrength());
        assertEquals(20, player.getHP());
        assertEquals(1, player.getDefense());
        assertEquals(50, player.getExperience());
        assertEquals(100, player.stats.getThreshold());//NOPMD

        player.stats.setExperience(50);//NOPMD
        assertEquals(3, player.getLevel());
        assertEquals(6, player.getStrength());
        assertEquals(30, player.getHP());
        assertEquals(1, player.getDefense());
        assertEquals(100, player.getExperience());
        assertEquals(200, player.stats.getThreshold());//NOPMD

    }

    /**
     * Test the death mechanic
     *
     */
    @Test
    public void die() {

        initGame();

        final PlayerCharacter player = new PlayerCharacter(384.0F, 284.0f);
        player.stats.setHP(0);//NOPMD
        player.update();
        assertTrue(player.getDelete()); //check if player gets deleted after HP reaching 0
    }
}