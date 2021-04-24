package com.base.game.gameobjects;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * A test class to test the Enemy class
 *
 * @author Jason Truskowski
 */
public class EnemyTest {

    @Test
    public void EnemyTestOne() {

        final Enemy en = new Enemy(5, 2,1,0);
        assertEquals(50, en.getMaxHP());
        assertEquals(1, en.getDefense());
        assertEquals(2, en.getStrength());
        assertEquals(50, en.getAttackRange());
        en.setAttackRange(100);
        assertEquals(100, en.getAttackRange());
        assertEquals(0, en.getAttackPower());
        en.setAttackPower(10);
        assertEquals(10,en.getAttackPower());
        assertEquals(50,en.getExpWorth());

    }

    @Test
    public void EnemyTestTwo() {

        final Enemy en = new Enemy(1, 3,2,1);
        assertEquals(10, en.getMaxHP());
        assertEquals(3, en.getStrength());
        assertEquals(2, en.getDefense());

        assertEquals(50,en.getExpWorth());

    }
}
