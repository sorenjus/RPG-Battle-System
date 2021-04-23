package com.base.game.gameobjects;

import com.base.engine.GameObject;
import com.base.engine.Main;
import com.base.engine.Physics;
import com.base.engine.DeathScreen;
import com.base.game.Cooldown;
import com.base.game.Item.*;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;

/**
 * This class simulates the character and manages the stats and behavior
 *
 * @author Justin Sorensen, Jason Truskowski
 */
public class PlayerCharacter extends BattleObject {
    //String containing the characters name//
    private static transient final String name = "Lonk";

    /**
     * The PlayerCharacter's inventory
     */
    private transient final Inventory playerInventory;

    /**
     * Numeric values for the four cardinal directions the character can face
     */
    public static final int LOOK_UP = 0;
    public static final int LOOK_DOWN = 1;
    public static final int LOOK_LEFT = 2;
    public static final int LOOK_RIGHT = 3;

    /**
     * Numeric value for which way the character is currently facing
     */
    private transient int facing;
    private transient int attackRange;

    /**
     * How long the player has to wait between attacks
     */
    private transient final Cooldown attackCoolDown;

    /**
     * The size of the player
     */
    public static final float SIZE = 32;

    /**
     * This constructor creates a new character
     * @param xCoordinate location on x axis
     * @param yCoordinate location on y axis
     */
    public PlayerCharacter(final float xCoordinate, final float yCoordinate) {
        init(xCoordinate, yCoordinate, 0.1f, 1f, 0.25f, SIZE, SIZE, "Player" );
        stats = new Stats(0, 3, 1, 50, 0, true);
        playerInventory = new Inventory(10);
        facing = 0;
        attackRange = 69;
        attackCoolDown = new Cooldown(500);
        attackCoolDown.stop();
        /**
         * The items the PlayerCharacter has equipped
         **/
        Equipment equipment = new Equipment(playerInventory);
    }

    /**
     * Checks for important changes in character state (picking up an item, dying)
     */
    @Override
    public void update() {
        final ArrayList<GameObject> objects = Main.inFront(xCoordinate, yCoordinate, xCoordinate+SIZE, yCoordinate+SIZE);

        for (final GameObject go : objects)
        {
            if (go instanceof Item) {
                System.out.println("You picked up a " + ((Item)go).getItemName() + "!");
                    if(((Item)go).getItemName().equals("Sword"))
                    {
                        this.attackRange = this.attackRange + ((Sword)go).getItemRange();
                        stats.setStrength(getStrength()+((Sword)go).getStrIncrease());
                        System.out.println("Your Strength increased by " + ((Sword)go).getStrIncrease() + "!");
                    }
                    if(((Item)go).getItemName().equals("Chain Mail Pants"))
                    {
                        stats.setDefense(getDefense()+((ChainPants)go).getDefense());
                        System.out.println("Your Defense increased by " + ((ChainPants)go).getDefense() + "!");
                    }
                    if(((Item)go).getItemName().equals("Chain Mail")) {
                        stats.setDefense(getDefense()+((ChainMail)go).getDefense());
                        System.out.println("Your Defense increased by " + ((ChainMail)go).getDefense() + "!");
                    }
                    if(((Item)go).getItemName().equals("Cap"))
                    {
                        stats.setDefense(getDefense()+((Cap)go).getDefense());
                        System.out.println("Your Defense increased by " + ((Cap)go).getDefense() + "!");
                    }
                go.setDeleteTrue();
                pickUpItem((Item)go);
            }
        }

        if(stats.getHP() <= 0) {
            die();
            final DeathScreen screen = new DeathScreen();
        }
    }

    /**
     * Move the character and display character stats based on input key
     */
    public void returnInput() {
        if (Keyboard.isKeyDown(Keyboard.KEY_W))
        {
            move(0, 1);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_S))
        {
            move(0, -1);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_A))
        {
            move(-1, 0);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_D))
        {
            move(1, 0);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_SPACE) && attackCoolDown.isCooldownOver())
        {
            attack();
        }
    }

    /**
     * Moves the character and makes them face the desired direction
     *
     * @param xCoord Horizontal movement
     * @param yCoord Vertical movement
     */
    private void move(final float xCoord, final float yCoord) {
        if(xCoord == 0 && yCoord == 1)
        {
            facing = LOOK_UP;
        }
        if(xCoord == 0 && yCoord == -1)
        {
            facing = LOOK_DOWN;
        }
        if(xCoord == -1 && yCoord == 0)
        {
            facing = LOOK_LEFT;
        }
        if(xCoord == 1 && yCoord == 0)
        {
            facing = LOOK_RIGHT;
        }
        this.xCoordinate += getSpeed() * xCoord;
        this.yCoordinate += getSpeed() * yCoord;
    }

    /**
     * Default speed the character sprite moves on the map
     *
     * @return Player speed
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
     * @return Character name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Adds an item to the player's inventory
     *
     * @param item The item being picked up
     */
    public void pickUpItem( final Item item) {
        playerInventory.addItemToInventory(item);
    }

    /**
     * Makes the player attack
     */
    public void attack() {
        System.out.println("Attacking");
        ArrayList<GameObject> inRange = new ArrayList<>();

        // Determines which direction the attack collision detection box should be in
        if(facing == LOOK_UP) {
            inRange = Main.inFront(getX(), getY(), getX() + SIZE, getY() + attackRange);
        } else if(facing == LOOK_DOWN) {
            inRange = Main.inFront(getX(), getY() - attackRange + SIZE, getX() + SIZE, getY());
        } else if(facing == LOOK_LEFT) {
            inRange = Main.inFront(getX() - attackRange +SIZE, getY(), getX(), getY() + SIZE);
        } else if(facing == LOOK_RIGHT) {
            inRange = Main.inFront(getX(), getY(), getX() + attackRange, getY() + SIZE);
        }

        // Creates a list of enemies in range
        final ArrayList<Enemy> attackable = new ArrayList<>();

        for(final GameObject ob : inRange) {
            if(ob instanceof Enemy) {
                attackable.add((Enemy)ob);
            }
        }

        // Determines the closest enemy and attacks it
        if(attackable.size() > 0) {

            Enemy target = attackable.get(0);

            if(attackable.size() > 1) {
                for(final GameObject en : attackable) {
                    if(Physics.getDist(getX(), getY(), en.getX(), en.getY()) < Physics.getDist(getX(), getY(), target.getX(), target.getY())) {//NOPMD
                        target = (Enemy)en;
                    }
                }
            }
            target.damage(getStrength() - target.getDefense());//NOPMD
            System.out.println("Enemy Hit! Enemy health: " + target.getHP() + "/" + target.getMaxHP());//NOPMD

            if(target.getHP() <= 0) {//NOPMD
                System.out.println("Enemy Killed! Gained " + target.stats.getExpWorth() + " EXP");//NOPMD
                stats.setExperience(target.stats.getExpWorth());//NOPMD
            }
        } else {
            System.out.println("Missed!");
        }

        attackCoolDown.start();
    }
}