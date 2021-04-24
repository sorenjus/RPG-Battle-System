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

        final Enemy enemy = new Enemy(5, 2,1,0);
        assertEquals(50, enemy.getMaxHP());
        assertEquals(1, enemy.getDefense());
        assertEquals(2, enemy.getStrength());
        assertEquals(50, enemy.getAttackRange());
        enemy.setAttackRange(100);
        assertEquals(100, enemy.getAttackRange());
        assertEquals(0, enemy.getAttackPower());
        enemy.setAttackPower(10);
        assertEquals(10,enemy.getAttackPower());
        assertEquals(50,enemy.getExpWorth());

    }

    @Test
    public void EnemyTestTwo() {

        final Enemy enemy = new Enemy(1, 3,2,1);
        assertEquals(10, enemy.getMaxHP());
        assertEquals(3, enemy.getStrength());
        assertEquals(2, enemy.getDefense());

        assertEquals(50,enemy.getExpWorth());

    }
}
