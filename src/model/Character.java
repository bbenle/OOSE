/***************************************************
* PURPOSE: This class contains the constructors and
* methods for Character
*          
* DATE: 26 May 2020
****************************************************/

package src.model;

import java.util.*;

public class Character
{
    // private class fields
    private String name;
    private int maxHp; // default 30
    private int currentHp; // default 30
    private Weapon weapon; 
    private Armour armour;
    private Potion potion;
    private int gold; // default 100
    private int damage;
    private int defence;
    private boolean dead;

    // inventory related class fields for the character
    private List<Item> inventory; // size of 15
    private int inventoryCount;
    private int weaponCount;
    private int armourCount;
    private int potionCount;

    // default constructor
    public Character()
    {
        name = "Cloud";
        maxHp = 30;
        currentHp = 30;
        inventory = new ArrayList<Item>(15);
        gold = 100;
    }

    // alternate constructor
    public Character(String inName, int inMaxHp, int inCurrentHp, int inGold)
    {
        name = inName;
        maxHp = inMaxHp;
        currentHp = inCurrentHp;
        gold = inGold;
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

    public List<Item> getInventory()
    {
        return inventory;
    }

    public Weapon getWeapon()
    {
        return weapon;
    }

    public Item getWeaponChoice(int choice)
    {
        return weapon;
    }

    public Armour getArmour()
    {
        return armour;
    }

    public Potion getPotion(int choice)
    {
        return potion;
    }

    public int getGold()
    {
        return gold;
    }

    // setters
    public void setName(String inName)
    {
        name = inName;
    }

    public void setCurrentHp(int inCurrentHp)
    {
        currentHp = inCurrentHp;
    }

    public void setWeapon(Weapon inWeapon)
    {
        weapon = inWeapon;
    }

    public void setArmour(Armour inArmour)
    {
        armour = inArmour;
    }

    public void setPotion(Potion inPotion)
    {
        potion = inPotion;
    }

    public void setGold(int inGold)
    {
        gold = inGold;
    }

    // method to print gold with a border around it
    public void printGold()
    {
        System.out.println("\n---------");
        System.out.println("Gold: " + getGold());
        System.out.println("---------\n");
    }

/***************************************************
* Inventory related methods that the character uses
****************************************************/

    // method to print out the inventory
    public void printInventory()
    {
        int ii = 0;

        // if there is nothing in the inventory, print this message
        if (getInventoryCount() == 0)
        {
            System.out.println("You have nothing in your inventory!");
        }
        else
        {
            // loops through the inventory and for each item, print it out
            for (Item item : inventory)
            {
                ii++;
                System.out.println(ii + ") " + item);
            }
        }
    }

     // method to add items to the players inventory
    public void addItem(Item addedItem)
    {    
        inventory.add(addedItem);
        inventoryCount++;

        // if the item is a Weapon, increment weaponCount
        if (addedItem instanceof Weapon)
        {
            weaponCount++;
        }
        // if the item is Armour, increment armourCount
        else if (addedItem instanceof Armour)
        {
            armourCount++;
        }
        // if the item is a Potion, increment potionCount
        else if (addedItem instanceof Potion)
        {
            potionCount++;
        }
    }
 
     // method to remove items from the players inventory
    public void removeItem(int index)
    {
        Item removedItem = inventory.get(index);
        inventory.remove(index);
        inventoryCount--;
 
        // if the item is a Weapon, decrement weaponCount
        if (removedItem instanceof Weapon)
        {
            weaponCount--;
        }
        // if the item is Armour, decrement armourCount
        else if (removedItem instanceof Armour)
        {
            armourCount--;
        }
        // if the item is a Potion, decrement potionCount
        else if (removedItem instanceof Potion)
        {
            potionCount--;
        }
    }

    // getters
    public int getInventoryCount()
    {
        return inventoryCount;
    }

    public int getWeaponCount()
    {
        return weaponCount;
    }

    public int getArmourCount()
    {
        return armourCount;
    }

    public int getPotionCount()
    {
        return potionCount;
    }

    // method to print only the weapons in the players inventory 
    public void printInventoryWeapons()
    {
        int ii = 0;

        // loops through the inventory and for each item, checks if the item is a Weapon
        // if it is a Weapon, it will print it out and increment the count
        for (Item item : inventory)
        {
            if (item instanceof Weapon)
            {
                ii++;
                weaponCount++;
                System.out.println(ii + ") " + item);
            }
        }
    }

    // method to print only the armour in the players inventory
    public void printInventoryArmour()
    {
        int ii = 0;

        // loops through the inventory and for each item, checks if the item is Armour
        // if it is Armour, it will print it out and increment the count
        for (Item item : inventory)
        {
            if (item instanceof Armour)
            {
                ii++;
                armourCount++;
                System.out.println(ii + ") " + item);
            }
        }
    }

    // method to print only the potions in the players inventory
    public void printInventoryPotion()
    {
        int ii = 0;

        // loops through the inventory and for each item, checks if the item is a Potion
        // if it is a Potion, it will print it out
        for (Item item : inventory)
        {
            if (item instanceof Potion)
            {
                ii++;
                System.out.println(ii + ") " + item);
            }
        }
    }

    // method to return a random number that the players current weapon deals
    public int attack()
    {
        // damage is a random number between min and max of the weapon
        damage = randInt(weapon.getMin(), weapon.getMax());
        return damage;
    }

    // method to return random number that the players current armour blocks
    public int defence()
    {
        // defence is a random number between min and max of the armour
        defence = randInt(armour.getMin(), armour.getMax());
        return defence;
    }

    // method to heal 1.5x the current health of the player once defeating an enemy
    public int health()
    {
        setCurrentHp(Math.min(getMaxHp(), (int)Math.round(getCurrentHp() *1.5)));
        return currentHp;
    }

    // method to display the players name, health and gold, used when a battle starts
    public void displayStats()
    {
        System.out.println("\n[Name]: " + getName());
        System.out.println("[Health]: " + getCurrentHp());
        System.out.println("[Gold]: " + getGold());
        System.out.println("[Current weapon]: " + getWeapon());
        System.out.println("[Current armour]: " + getArmour());
    }

    // method to generate a random number between two numbers
    public static int randInt(int min, int max)
    {
        Random r = new Random();
        int result = r.nextInt((max - min) +1) + min;

        return result;
    }

    // method to check when the player has died
    public boolean isDead()
    {
        // if players current health is greater than 0, they are alive
        // otherwise they are dead
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
}