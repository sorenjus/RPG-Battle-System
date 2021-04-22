package com.base.game.gameobjects;

import com.base.engine.GameObject;
import com.base.engine.Main;
import com.base.engine.Physics;
import com.base.game.Cooldown;
import com.base.game.Item.Item;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;

/**
 * This class simulates the character and manages the stats
 *
 * @author Justin Sorensen
 */
public class PlayerCharacter extends BattleObject {

    //String containing the characters name//
    private transient String name = "Lonk"; // temporary

    private Inventory playerInventory;
    private int facing;
    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;
    private int attackRange;
    private Cooldown attackCoolDown;

    public static final float SIZE = 32;

    /**
     * /*
     * This constructor creates a new character
     */
    public PlayerCharacter(final float xCoordinate, final float yCoordinate) {
        init(xCoordinate, yCoordinate, 0.1f, 1f, 0.25f, SIZE, SIZE, 0);
        stats = new Stats(0, 5, 5, 50, true);
        playerInventory = new Inventory(10);
        facing = 0;
        attackRange = 69;
        attackCoolDown = new Cooldown(500);
        attackCoolDown.stop();
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
        if (Keyboard.isKeyDown(Keyboard.KEY_SPACE) && attackCoolDown.isCooldownOver()) {
            attack();
        }
        // TODO: Redo characterToString with new setup
//        if (Keyboard.isKeyDown(Keyboard.KEY_1)) {
//            System.out.println(this.characterToString());
//        }
    }

    private void move(final float magX, final float magY) {
        if(magX == 0 && magY == 1) {
            facing = UP;
        }
        if(magX == 0 && magY == -1) {
            facing = DOWN;
        }
        if(magX == -1 && magY == 0) {
            facing = LEFT;
        }
        if(magX == 1 && magY == 0) {
            facing = RIGHT;
        }

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

    public void attack() {
        System.out.println("Attack");
        ArrayList<GameObject> attackable = new ArrayList<GameObject>();

        if(facing == UP) {
            attackable = Main.inFront(getX(), getY(), getX() + SIZE, getY() + attackRange);
        } else if(facing == DOWN) {
            attackable = Main.inFront(getX(), getY(), getX() + SIZE, getY() - attackRange);
        } else if(facing == LEFT) {
            attackable = Main.inFront(getX(), getY(), getX() - attackRange, getY() + SIZE);
        } else if(facing == RIGHT) {
            attackable = Main.inFront(getX(), getY(), getX() + attackRange, getY() + SIZE);
        }

        for(GameObject ob : attackable) {
            if(!(ob instanceof Enemy)) {
                attackable.remove(ob);
            }
        }

        if(attackable.size() > 0) {
            Enemy target = (Enemy)attackable.get(0);

            if(attackable.size() > 1) {
                for(GameObject en : attackable) {
                    if(Physics.getDist(getX(), getY(), en.getX(), en.getY()) < Physics.getDist(getX(), getY(), target.getX(), target.getY())) {
                        target = (Enemy)en;
                    }
                }
            }
            target.damage(getStrength());
            System.out.println("Enemy Hit! " + target.getHP() + "/" + target.getMaxHP());
        } else {
            System.out.println("Miss");
        }

        attackCoolDown.start();
    }
}

