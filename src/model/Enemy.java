/***************************************************
* PURPOSE: This class contains the constructors and
* methods for Enemy
*          
* DATE: 26 May 2020
****************************************************/

package src.model;

import java.util.Random;

public abstract class Enemy
{
    // private class fields
    private String name;
    private int maxHp; 
    private int currentHp; 
    private int minAtk;
    private int maxAtk;
    private int minDef;
    private int maxDef;
    private int goldAwarded;
    private boolean dead;

    // alternate constructor
    public Enemy(String inName, int inMaxHp, int inCurrentHp, 
                 int inMinAtk, int inMaxAtk, int inMinDef, int inMaxDef, int inGoldAwarded)
    {
        name = inName;
        maxHp = inMaxHp;
        currentHp = inCurrentHp;
        minAtk = inMinAtk;
        maxAtk = inMaxAtk;
        minDef = inMinDef;
        maxDef = inMaxDef;
        goldAwarded = inGoldAwarded;
    }

    // getters
    public String getName()
    {
        return name;
    }

    public int getMaxHp()
    {
        return maxHp;
    }

    public int getCurrentHp()
    {
        return currentHp;
    }

    public int getMinAtk()
    {
        return minAtk;
    }

    public int getMaxAtk()
    {
        return maxAtk;
    }

    public int getMinDef()
    {
        return minDef;
    }

    public int getMaxDef()
    {
        return maxDef;
    }

    public int getGoldAwarded()
    {
        return goldAwarded;
    }

    // setters
    public void setName(String inName)
    {
        name = inName;
    }

    public void setMaxHp(int inMaxHp)
    {
        maxHp = inMaxHp;
    }

    public void setCurrentHp(int inCurrentHp)
    {
        currentHp = inCurrentHp;
    }

    public void setMinDef(int inMinDef)
    {
        minDef = inMinDef;
    }

    public void setMaxDef(int inMaxDef)
    {
        maxDef = inMaxDef;
    }

    public void setGoldAwarded(int inGoldAwarded)
    {
        goldAwarded = inGoldAwarded;
    }

    // method to display name and health of the enemy
    public void displayStats()
    {
        System.out.println("[Health]: " + getCurrentHp());
        System.out.println("[Damage]: " + getMinAtk() + "-" + getMaxAtk());
        System.out.println("[Defence]: " + getMinDef() + "-" + getMaxDef());
    }

    // method that displays which enemy has appeared
    public void displayEnemy()
    {
        System.out.println("\n" + getName() + " has appeared!");
    }

    // method that chooses a random number between two numbers
    public static int randInt(int min, int max)
    {
        Random r = new Random();
        int result = r.nextInt((max - min) +1) + min;

        return result;
    }

    public boolean isDead()
    {
        if (getCurrentHp() > 0)
        {
            dead = false;
        }
        else
        {
            dead = true;
        }
        return dead;
    }

    public abstract int attack();

    public abstract int defence();
}