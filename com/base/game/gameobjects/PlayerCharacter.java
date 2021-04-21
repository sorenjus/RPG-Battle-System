package com.base.game.gameobjects;

import com.base.engine.GameObject;
import com.base.game.Item.Item;
import org.lwjgl.input.Keyboard;

/**
 * This class simulates the character and manages the stats
 *
 * @author Justin Sorensen
 */
public class PlayerCharacter extends GameObject {

    //String containing the characters name//
    private transient String name;
    //Integer values containing various stats of the character//
    private transient int strength, defense, experience, level, healthPoints;
    //Integer values representing the original HP, strength, and defense of the character//
    private transient final int baseStrength, baseDefense, baseHP;
    //Integer of experience needed to reach the next level//
    private transient int levelThreshold;

    private Inventory playerInventory;

    public static final float SIZE = 32;

    /**
     * /*
     * This constructor creates a new character
     */
    public PlayerCharacter(final float xCoordinate, final float yCoordinate) {
        init(xCoordinate, yCoordinate, 0.1f, 1f, 0.25f, SIZE, SIZE, 0);
        level = 1;
        baseStrength = 5;
        strength = baseStrength;
        baseHP = incHP();
        healthPoints = baseHP;
        baseDefense = 5;
        defense = baseDefense;
        experience = 0;
        levelThreshold = 50;
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
        if (Keyboard.isKeyDown(Keyboard.KEY_1)) {
            System.out.println(this.characterToString());
        }
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

    /**
     * This constructor returns all of the details of the character
     *
     * @return String
     */
    public String characterToString() {
        return "Name : " + this.name + "\nLevel : " + this.level + "\nHP : " + this.healthPoints + "\nStrength : " + this.strength
                + "\nDefense : " + this.defense + "\nTo Next Level : " + (this.levelThreshold - this.experience);
    }

    /**
     * Function returning the character's name
     *
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Function returning the character's HP
     *
     * @return int
     */
    public int getHP() {
        return this.healthPoints;
    }

    /**
     * Function returning the character's strength
     *
     * @return int
     */
    public int getStrength() {
        return this.strength;
    }

    /**
     * Function returning the character's defense
     *
     * @return int
     */
    public int getDefense() {
        return this.defense;
    }

    /**
     * Function returning the characters amount of experience
     *
     * @return int
     */
    public int getExperience() {
        return this.experience;
    }

    /**
     * This function raises the characters experience by the amount of experience gained
     * in battle. It then evaluates if the amount of experience meets the current level threshold.
     * If so the character levels up
     *
     * @param battleExp battle experience
     */
    public void setExperience(final int battleExp) {
        this.experience += battleExp;
        if (this.experience >= this.levelThreshold) {
            this.levelUp();
        }
    }

    /**
     * Function reducing the characters healthpoint
     */
    public void setHP(){
        this.healthPoints = this.healthPoints - 10;
    }

    /**
     * Function returning the characters experience threshold
     *
     * @return int
     */
    public int getThreshold() {
        return this.levelThreshold;
    }

    /**
     * Function returning the characters level
     *
     * @return int
     */
    public int getLevel() {
        return this.level;
    }

    /**
     * Function increases Character stats when threshold is met
     */
    private void levelUp() {
        this.level += 1;
        this.healthPoints = incHP();
        this.strength = incStat(this.baseStrength);
        this.defense = incStat(this.baseDefense);
        this.levelThreshold = returnThreshold() + 50;
    }

    /**
     * Level threshold is set based on character level
     *
     * @return int
     */
    private int returnThreshold() {
        return 25 * this.level * this.level - 25 * this.level;
    }

    /**
     * Increases Character stats
     *
     * @param stat Character stat
     * @return int
     */
    private int incStat(final int stat) {
        return (stat * this.level) / 2 + 2;
    }

    /**
     * Increase Character HP
     *
     * @return int
     */
    private int incHP() {
        return (this.getStrength() * (200 * this.getLevel())) / 100 + 30;
    }

    public void pickUpItem(Item item)
    {
        playerInventory.addItemToInventory(item);
    }
}

