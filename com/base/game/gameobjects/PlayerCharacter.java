package com.base.game.gameobjects;

import com.base.engine.GameObject;
import com.base.game.Item.Item;
import org.lwjgl.input.Keyboard;

/**
 * This class simulates the character and manages the stats
 *
 * @author Justin Sorensen
 */
public class PlayerCharacter extends BattleObject {

    //String containing the characters name//
    private transient String name = "Greenie"; // temporary
    //Integer values containing various stats of the character//
    //private transient int strength, defense, experience, level, healthPoints;
    //Integer values representing the original HP, strength, and defense of the character//
    //private transient final int baseStrength, baseDefense, baseHP;
    //Integer of experience needed to reach the next level//
    //private transient int levelThreshold;

    private Inventory playerInventory;

    public static final float SIZE = 32;

    /**
     * /*
     * This constructor creates a new character
     */
    public PlayerCharacter(final float xCoordinate, final float yCoordinate) {
        init(xCoordinate, yCoordinate, 0.1f, 1f, 0.25f, SIZE, SIZE, 0);
        stats = new Stats(0, 5, 5, 50, true);
        playerInventory = new Inventory(10);
    }

    /**
     * Move the character and display character stats based on input key
     */
    public void returnInput() {
        if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
            move(0, 1);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
            move(0, -1);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
            move(-1, 0);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
            move(1, 0);
        }
        // TODO: Redo characterToString with new setup
//        if (Keyboard.isKeyDown(Keyboard.KEY_1)) {
//            System.out.println(this.characterToString());
//        }
    }

    private void move(final float magX, final float magY) {
        this.xCoordinate += getSpeed() * magX;
        this.yCoordinate += getSpeed() * magY;
    }

    /**
     * default speed the sprite moves on the map
     *
     * @return float
     */
    public float getSpeed() {
        return 4f;
    }

    // TODO: Redo with new setup
//    /**
//     * This constructor returns all of the details of the character
//     *
//     * @return String
//     */
//    public String characterToString() {
//        return "Name : " + this.name + "\nLevel : " + getLevel() + "\nHP : " + getHP() + "\nStrength : " + getStrength()
//                + "\nDefense : " + getDefense() + "\nTo Next Level : " + (this.levelThreshold - this.getExperience());
//    }

    /**
     * Function returning the character's name
     *
     * @return String
     */
    public String getName() {
        return this.name;
    }

    public void pickUpItem(Item item)
    {
        playerInventory.addItemToInventory(item);
    }
}

