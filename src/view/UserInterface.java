/***************************************************
* PURPOSE: This class is the user interface and 
* contains the options the player may select on the
* main screen and the methods that are used when the
* option is selected
*          
* DATE: 26 May 2020
****************************************************/

package src.view;

import java.util.*;
import src.model.*;
import src.model.Character;
import src.controller.*;

public class UserInterface
{
    public void gameMenu()
    {
        Character player = new Character();
        Shop shop = new Shop();
        int choice;
        boolean gameOver = false;

        List<Item> shopList = FileIO.readFileIntoListForShop(player); // reads text file for the shop
        
        // loops the menu options until player exits game or player dies
        do
        {
            choice = intInput("\n===============================\nSelect an option\n" +
                                "    1) Go to Shop\n" +
                                "    2) Choose Character Name\n" + 
                                "    3) Choose Weapon\n" +
                                "    4) Choose Armour\n" +
                                "    5) Start Battle\n" +
                                "    6) View Inventory\n" + 
                                "    7) Exit Game\n==============================", 1, 7);
            switch (choice)
            {
                case 1:  
                    shop.displayShop(player, shopList); // calls displayShop method from the class Shop
                    break;
                
                case 2:
                    assignName(player); // assigns the player a new name
                    break;

                case 3:
                    selectWeapon(player); // allows player to choose different weapons
                    break;

                case 4:
                    selectArmour(player); // allows the player to choose different armour
                    break;

                case 5:
                    Enemy enemy = new EnemyFactory().getEnemy(); // a new enemy is created when battle starts
                    gameOver = startBattle(player, enemy);
                    break;

                case 6:
                    System.out.println("\nInventory");
                    player.printInventory(); // prints out the players inventory
                    break;

                case 7:
                    System.out.println("\nGAME OVER. Thank you for playing!");
                    break;

                default:
                    System.out.println("Error. Enter a number between 1 and 7");
            } 
        } while (choice != 7 && gameOver == false);
    }

    // this method allows the player to change their name 
    public void assignName(Character player)
    {
        String playerName;

        playerName = stringInput("\nPlease enter your characters name");
        System.out.println("\nYour characters name is " + playerName);
        player.setName(playerName);
    }

    // this method allows the player to change their current equipped weapon
    public void selectWeapon(Character player)
    {
        int choice;
        Weapon currentWeapon = player.getWeapon();
        Weapon newWeapon = currentWeapon;
        int wepCount = 0;
    
        // if player has no weapons, they can't pick another weapon
        if (player.getWeaponCount() == 0)
        {
            System.out.println("\nYou have no other weapons to choose from!");
        }
        else
        {
            System.out.println("\nCurrent equipped weapon"); 
            System.out.println(currentWeapon); // displays current weapon

            System.out.println("\nCurrent weapons in your inventory");
            player.printInventoryWeapons(); // displays only the weapons in players inventory
            
            choice = intInput("\nChoose another weapon to equip", 1, player.getWeaponCount());

            // loops in the players inventory for each item there is
            for (Item weapon : player.getInventory())
            {
                // if the item is a Weapon, increment count
                if (weapon instanceof Weapon)
                {
                    wepCount++;
                    // if count is same as the players choice, assign weapon to newWeapon
                    if (wepCount == choice) 
                    {
                        newWeapon = (Weapon)weapon; 
                    }
                }
            }
            player.setWeapon(newWeapon); // assigns the player that newWeapon
            System.out.println("\nYou have equipped");
            System.out.println(newWeapon);
        }
        
    }

    // this method allows the user to change their current equipped armour
    public void selectArmour(Character player)
    {   
        int choice;
        Armour currentArmour = player.getArmour();
        Armour newArmour = currentArmour;
        int armourCount = 0;

        // if player has no armour, they can't pick another armour
        if (player.getArmourCount() == 0)
        {
            System.out.println("\nYou have no other armour to choose from!");
        }
        else
        {
            System.out.println("\nCurrent equipped armour");
            System.out.println(currentArmour); // displays current armour

            System.out.println("\nCurrent armour in your inventory");
            player.printInventoryArmour(); // displays only the weapons in players inventory

            choice = intInput("\nChoose another armour to equip", 1, player.getArmourCount());

            // loops in the players inventory for each item there is
            for (Item armour : player.getInventory())
            {
                // if the item is Armour, increment count
                if (armour instanceof Armour)
                {
                    armourCount++;
                    // if count is same as the players choice, assign weapon to newArmour
                    if (armourCount == choice)
                    {
                        newArmour = (Armour)armour;
                    }
                }
            }
            player.setArmour(newArmour); // assigns the player that newArmour
            System.out.println("\nYou have equipped");
            System.out.println(newArmour);
        }
    }

    // this method contains the battle aspect of the game
    public boolean startBattle(Character player, Enemy enemy)
    {
        int choice;
        boolean gameOver = false;

        System.out.println("\n==================\nPREPARE TO BATTLE\n==================");

        // prints player and enemy stats when game first starts
        player.displayStats();
        enemy.displayEnemy();
        enemy.displayStats();

        // loops this while the player and enemy are alive and game hasn't ended
        do
        {
            choice = intInput("\n==================\nSelect an option\n" +
                            "    1) Attack\n" +
                            "    2) Use Potion\n==================", 1, 2);
            
            switch (choice)
            {
                // attack
                case 1:        
                    // battle implements a strategy pattern, a new strategy is employed which will be a players attack
                    BattleContext battle = new BattleContext(new PlayerAttack());
                    battle.executeAttack(player, enemy); // the players attack is executed here

                    // after the player attacks, it checks if the enemy is dead
                    if (enemy.isDead() == true)
                    {
                        // if enemy dies, calls this method which prints out the death
                        printEnemyDeath(player, enemy);
                        // if the enemy was a Dragon, print out YOU WIN and ends the game
                        if (enemy instanceof Dragon)
                        {
                            System.out.println("\nYOU WIN!\n");
                            gameOver = true;
                        }
                    }

                    // after a player attacks, a new strategy is employed which is the enemy attack
                    battle = new BattleContext(new EnemyAttack());
                    battle.executeAttack(player, enemy); // enemy attack is executed

                    // after an enemy attacks, it checks if the player is dead
                    if (player.isDead() == true)
                    {
                        // if player dies, calls this method which prints out the player death and ends the game
                        printPlayerDeath(player, enemy);
                        gameOver = true;
                    }
                    break;

                // use potion
                case 2:
                    int potionChoice;
                    int potionCount = player.getPotionCount();
                    
                    // if there are no potions in inventory, print this statement
                    if (potionCount == 0)
                    {
                        System.out.println("\nYou have no potions to choose from!");
                    }
                    else
                    {
                        // displays potions in players inventory
                        System.out.println("\nCurrent potions in your inventory");
                        player.printInventoryPotion();
                        potionChoice = intInput("\nSelect a potion", 1, potionCount);

                        int tempCount = 0;
                        // uses an iterator here due to modofication error when trying to remove item in a for each loop
                        Iterator<Item> it = player.getInventory().iterator();

                        // loops through iterator
                        while (it.hasNext())
                        {
                            // assigns the iterated object to potion and checks if potion is of type Potion
                            Item potion = (Item)it.next();
                            if (potion instanceof Potion)
                            {
                                tempCount++;
                                // if the count matches the potionChoice, print the potion used
                                if (tempCount == potionChoice)
                                {
                                    System.out.println("\nYou have used " + potion.getName());

                                    // if the potion was a healing type, heal the player for a random number between two numbers
                                    // sets players current health to the heal amount
                                    if (((Potion) potion).getPotionEffect().equals("H"))
                                    {
                                        int healAmount = randInt(potion.getMin(), potion.getMax());

                                        System.out.println(player.getName() + " has healed " + healAmount + " health");
                                        player.setCurrentHp(player.getCurrentHp() + healAmount);
                                    }
                                    // else if the potion was a damage type, damage the enemy for a random number between two numbers
                                    // decrement enemies health by the damage amount
                                    else
                                    {
                                        int damageAmount = randInt(potion.getMin(), potion.getMax());
                        
                                        System.out.println(potion.getName() + " has done " + damageAmount + " damage to the enemy");
                                        enemy.setCurrentHp(enemy.getCurrentHp() - damageAmount);
                                    }
                                    it.remove(); // remove the potion from inventory
                                    potionCount--;  
                                }
                            }
                        }
                        // after a potion is used, checks if the enemy has died (only works for damage potion)
                        if (enemy.isDead() == true)
                        {
                            // if enemy is dead print enemy death
                            // if the enemy was a dragon, the player wins
                            printEnemyDeath(player, enemy);
                            if (enemy instanceof Dragon)
                            {
                                System.out.println("\nYOU WIN!\n");
                                gameOver = true;
                            }
                        }

                        // enemy attacks after the player drinks a potion
                        battle = new BattleContext(new EnemyAttack()); // employs the enemy attack with strategy pattern
                        battle.executeAttack(player, enemy); // executes the attack
                        
                        // checks if the player is dead
                        if (player.isDead() == true)
                        {
                            printPlayerDeath(player, enemy);
                            gameOver = true;
                        }     
                    }
                    break;
                
                default:
                    System.out.println("Enter a valid number between 1 and 2");
            } 
        } while ((player.getCurrentHp() > 0) && (enemy.getCurrentHp() > 0) && (gameOver == false));
        return gameOver;
    }

    // this method is used to print out the death of the player
    public void printPlayerDeath(Character player, Enemy enemy)
    {
        System.out.println("\n" + enemy.getName() + " has defeated " + player.getName() + "!");
        System.out.println("\nGAME OVER\n");
    }

    // this method is used to print out the death of the enemy, awards player gold and health
    public void printEnemyDeath(Character player, Enemy enemy)
    {   
        System.out.println("\n" + player.getName() + " has defeated the " + enemy.getName() + "!");
        System.out.println(enemy.getName() + " dropped " + enemy.getGoldAwarded() + " gold");
        System.out.println("\n" + player.getName() + " has healed some health");
        
        player.setGold(player.getGold() + enemy.getGoldAwarded());
        player.health();
        System.out.println("[Health]: " + player.getCurrentHp());
        System.out.println("[Gold]: " + player.getGold());
    }

    // this method is used for integer input from the user
    public static int intInput(String prompt, int min, int max)
    {
        int num = 0;
        Scanner sc = new Scanner(System.in);
        
        do
        {
            try
            {
                System.out.println(prompt);
                num = sc.nextInt();
                prompt = "Error. Enter a valid number between " + min + " and " + max;
            }
            catch (InputMismatchException e)
            {
                sc.nextLine();
                prompt = "Error. Must be an integer";
            }
        } while ((num < min) || (num > max));
        return num;
    }

    // this method is used for string input from the user
    public static String stringInput(String prompt)
    {
        String str;
        Scanner sc = new Scanner(System.in);

        System.out.println(prompt);
        str = sc.nextLine();

        return str;
    }

    // method to generate a random number between two numbers
    public static int randInt(int min, int max)
    {
        Random r = new Random();
        int result = r.nextInt((max - min) +1) + min;

        return result;
    }
}