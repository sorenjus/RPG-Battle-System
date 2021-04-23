package com.base.game.gameobjects;

import com.base.engine.GameObject;
import com.base.engine.Main;
import com.base.engine.Physics;
import com.base.engine.DeathScreen;
import com.base.game.Cooldown;
import com.base.game.Game;
import com.base.game.Item.Equipment;
import com.base.game.Item.Item;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;

/**
 * This class simulates the character and manages the stats and behavior
 *
 * @author Justin Sorensen, Jason Truskowski
 */
public class PlayerCharacter extends BattleObject {
    //String containing the characters name//
    private transient String name = "Lonk";

    /**
     * The PlayerCharacter's inventory
     */
    private final Inventory playerInventory;
    /**
     * The items the PlayerCharacter has equipped
     */
    private final Equipment equipment;

    /**
     * Numeric values for the four cardinal directions the character can face
     */
    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;

    /**
     * Numeric value for which way the character is currently facing
     */
    private int facing;

    /**
     * How far away the player can reach enemies to attack
     */
    private final int attackRange;

    /**
     * How long the player has to wait between attacks
     */
    private final Cooldown attackCoolDown;

    /**
     * The size of the player
     */
    public static final float SIZE = 32;

    /**
     * This constructor creates a new character
     */
    public PlayerCharacter(final float xCoordinate, final float yCoordinate) {
        init(xCoordinate, yCoordinate, 0.1f, 1f, 0.25f, SIZE, SIZE, "Player" );
        stats = new Stats(0, 3, 1, 50, 0, true);
        playerInventory = new Inventory(10);
        facing = 0;
        attackRange = 69;
        attackCoolDown = new Cooldown(500);
        attackCoolDown.stop();
        equipment = new Equipment(playerInventory);
    }

    /**
     * Checks for important changes in character state (picking up an item, dying)
     */
    @Override
    public void update() {
        ArrayList<GameObject> objects = Main.inFront(xCoordinate, yCoordinate, xCoordinate+SIZE, yCoordinate+SIZE);

        for (GameObject go : objects)
        {
            if (go instanceof Item) {
                System.out.println("you picked up a " + ((Item)go).getItemName() + "!");
                go.setDeleteTrue();
                pickUpItem((Item)go);
            }
        }

        if(stats.getHP() <= 0) {
            die();
            DeathScreen s = new DeathScreen();
        }
    }

    /**
     * Move the character and display character stats based on input key
     */
    public void returnInput() {
        if (Keyboard.isKeyDown(Keyboard.KEY_W))
            move(0, 1);
        if (Keyboard.isKeyDown(Keyboard.KEY_S))
            move(0, -1);
        if (Keyboard.isKeyDown(Keyboard.KEY_A))
            move(-1, 0);
        if (Keyboard.isKeyDown(Keyboard.KEY_D))
            move(1, 0);
        if (Keyboard.isKeyDown(Keyboard.KEY_SPACE) && attackCoolDown.isCooldownOver())
            attack();
        // TODO: Redo characterToString with new setup
//        if (Keyboard.isKeyDown(Keyboard.KEY_1)) {
//            System.out.println(this.characterToString());
//        }
    }

    /**
     * Moves the character and makes them face the desired direction
     *
     * @param x Horizontal movement
     * @param y Vertical movement
     */
    private void move(final float x, final float y) {
        if(x == 0 && y == 1)
            facing = UP;
        if(x == 0 && y == -1)
            facing = DOWN;
        if(x == -1 && y == 0)
            facing = LEFT;
        if(x == 1 && y == 0)
            facing = RIGHT;

        this.xCoordinate += getSpeed() * x;
        this.yCoordinate += getSpeed() * y;
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
    public void pickUpItem(Item item) {
        playerInventory.addItemToInventory(item);
    }

    /**
     * Makes the player attack
     */
    public void attack() {
        System.out.println("Attacking");
        ArrayList<GameObject> inRange = new ArrayList<>();

        // Determines which direction the attack collision detection box should be in
        if(facing == UP) {
            inRange = Main.inFront(getX(), getY(), getX() + SIZE, getY() + attackRange);
        } else if(facing == DOWN) {
            inRange = Main.inFront(getX(), getY() - attackRange + SIZE, getX() + SIZE, getY());
        } else if(facing == LEFT) {
            inRange = Main.inFront(getX() - attackRange +SIZE, getY(), getX(), getY() + SIZE);
        } else if(facing == RIGHT) {
            inRange = Main.inFront(getX(), getY(), getX() + attackRange, getY() + SIZE);
        }

        // Creates a list of enemies in range
        ArrayList<Enemy> attackable = new ArrayList<>();

        for(GameObject ob : inRange) {
            if(ob instanceof Enemy) {
                attackable.add((Enemy)ob);
            }
        }

        // Determines the closest enemy and attacks it
        if(attackable.size() > 0) {

            Enemy target = attackable.get(0);

            if(attackable.size() > 1) {
                for(GameObject en : attackable) {
                    if(Physics.getDist(getX(), getY(), en.getX(), en.getY()) < Physics.getDist(getX(), getY(), target.getX(), target.getY())) {
                        target = (Enemy)en;
                    }
                }
            }
            target.damage(getStrength() - target.getDefense());
            System.out.println("Enemy Hit! Enemy health: " + target.getHP() + "/" + target.getMaxHP());

            if(target.getHP() <= 0) {
                System.out.println("Enemy Killed! Gained " + target.stats.getExpWorth() + " EXP");
                stats.setExperience(target.stats.getExpWorth());
            }
        } else {
            System.out.println("Missed!");
        }

        attackCoolDown.start();
    }
}