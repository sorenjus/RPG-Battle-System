package com.base.game.gameobjects;

import com.base.game.GenericRedSquareOfDeath;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnemyTest {

    @Test
    public void Enemy1() {

        Enemy en = new Enemy(150, 200,1);
        assertEquals(10, en.getMaxHP());
        //assertEquals(2, en.attack());
    }
    @Test
    public void Enemy2() {

        Enemy en = new Enemy(175, 200,5);
        assertEquals(50, en.getMaxHP());
        //assertEquals(10, en.attack());
    }
}
