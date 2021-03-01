/***************************************************
* PURPOSE: This class contains all the functionality 
* of the shop
*          
* DATE: 26 May 2020
****************************************************/

package src.controller;

import src.model.*;
import src.model.Character;
import java.util.*;

public class Shop
{    
    // method to display the options the player can choose from when accessing the shop
    // enchantments are hardcoded into this method
    public void displayShop(Character player, List<Item> list)
    {
        int shopChoice; 
        Item item;
        
        System.out.println("\nWelcome to the Shop!");
        player.printGold(); // prints players gold
             
        do
        {
            shopChoice = intInput("\nWhat would you like to do?\n" +
            "    1) Buy Items\n" +
            "    2) Add Enchantments\n" +
            "    3) Sell Items\n" + 
            "    4) Exit Shop\n==============================", 1, 4);

            switch (shopChoice)
            {        
                case 1:
                    int choice;

                    player.printGold(); 
                    printShop(list); // prints out the list of items in the shop
                    System.out.println("10) [Exit Shop]"); // 10th option will close the shop. Only works with 9 items in shop
                    choice = intInput("\nWhat would you like to purchase?", 1, 10);

                    if (choice == 10)
                    {
                        System.out.println("\nClosing shop");
                    }
                    else
                    {
                        item = list.get(choice-1); // item is choice-1 because arraylist starts at index 0
                        buyItem(player, item, list); // adds item to inventory, decrements the players gold 
                    }
                    break;

                case 2:
                    int enchantChoice;

                    printEnchantments(); // prints all enchantments available for purchase
                    enchantChoice = intInput("\nWhich enchantment do you want to purchase?", 1, 5);

                    // adds +2 damage to current weapon
                    if (enchantChoice == 1)
                    {
                        int cost = 5;
                        int playerGold = player.getGold();

                        // if player has less gold than the cost, they can't buy it
                        if (playerGold < cost)
                        {
                            System.out.println("\nYou can't afford this enchantment!");
                        }
                        else
                        {
                            // prints players gold, adds enchantment to the current weapon
                            // uses decorator pattern to achieve this
                            player.printGold();
                            System.out.println("\nAdding 2 damage to your current weapon");
                            Weapon currentWeapon = player.getWeapon();
                            Item enchantedWeapon = new Damage2(currentWeapon);
                            System.out.println(enchantedWeapon);
                            player.setGold(playerGold - cost); // decrements players gold by enchantment cost
                            player.printGold();
                        }
                    }
                    // adds +5 damage to current weapon
                    else if (enchantChoice == 2)
                    {
                        int cost = 10;
                        int playerGold = player.getGold();

                        if (playerGold < cost)
                        {
                            System.out.println("\nYou can't afford this enchantment!");
                        }
                        else
                        {
                            // prints players gold, adds enchantment to the current weapon
                            // uses decorator pattern to achieve this
                            player.printGold();
                            System.out.println("\nAdding 5 damage to your current weapon");
                            Weapon currentWeapon = player.getWeapon();
                            Item enchantedWeapon = new Damage5(currentWeapon);
                            System.out.println(enchantedWeapon);
                            player.setGold(playerGold - cost);
                            player.printGold();
                        }
                    }
                    // adds 5-10 damage to current weapon
                    else if (enchantChoice == 3)
                    {
                        int cost = 20;
                        int playerGold = player.getGold();

                        if (playerGold < cost)
                        {
                            System.out.println("\nYou can't afford this enchantment!");
                        }
                        else
                        {
                            // prints players gold, adds enchantment to the current weapon
                            // uses decorator pattern to achieve this
                            player.printGold();
                            System.out.println("Adding 5-10 damage to your current weapon");
                            Weapon currentWeapon = player.getWeapon();
                            Item enchantedWeapon = new FireDamage(currentWeapon);
                            System.out.println(enchantedWeapon);
                            player.setGold(playerGold - cost);
                            player.printGold();
                        }
                    }
                    // adds 1.1x damage to current weapon
                    else if (enchantChoice == 4)
                    {
                        int cost = 10;
                        int playerGold = player.getGold();

                        if (playerGold < cost)
                        {
                            System.out.println("\nYou can't afford this enchantment!");
                        }
                        else
                        {
                            // prints players gold, adds enchantment to the current weapon
                            // uses decorator pattern to achieve this
                            player.printGold();
                            System.out.println("\nMultiplying the attack of your weapon by 1.1x");
                            Weapon currentWeapon = player.getWeapon();
                            Item enchantedWeapon = new PowerUp(currentWeapon);
                            System.out.println(enchantedWeapon);
                            player.setGold(playerGold - cost);
                            player.printGold();
                        }
                    }
                    else if (enchantChoice == 5)
                    {
                        System.out.println("\nClosing enchantments");
                    }   
                    else
                    {
                        choice = intInput("Error. Enter a number between 1 and 5", 1, 5);
                    } 
                    break;            
                    
                case 3:
                    int sellChoice;

                    // can't sell items if there is nothing in inventory
                    if (player.getInventoryCount() == 0)
                    {
                        System.out.println("\nThere are no items in your inventory!");
                    }
                    else 
                    {
                        // displays items in inventory and prompts user to sell items
                        System.out.println("\nCurrently in your inventory");
                        player.printInventory();
                        sellChoice = intInput("\nWhat would you like to sell?", 1, player.getInventoryCount());
                        item = player.getInventory().get(sellChoice-1); // goes to inventory to get the index-1 of item to sell

                        // cant sell the players current equipped weapon
                        if (item == player.getWeapon())
                        {
                            System.out.println("\nYou can't sell your equipped weapon!");
                        }
                        // cant sell the players current equipped armour
                        else if (item == player.getArmour())
                        {
                            System.out.println("\nYou can't sell your equipped armour!");
                        }
                        else
                        {
                            // sells item and increments players gold by half the value of the item
                            sellItem(player, item, sellChoice); 
                        }
                    }
                    break;

                case 4:
                    System.out.println("\nThanks for shopping!");  
                    break;

                default:
                    System.out.println("Error. Enter a number between 1 and 4");
            }  
        } while (shopChoice != 4);
    }

    // this method buys items and decrements the players gold
    public void buyItem(Character player, Item item, List<Item> list)
    {
        int playerGold = player.getGold();
        int itemCost = item.getCost();
 
        // cant buy items if the inventory is full
        if (player.getInventoryCount() == 15)
        {
            System.out.println("\nUnable to purchase item. Your inventory is full!");
        }
        // cant buy items if player has less gold than cost of item
        else if (playerGold < itemCost)
        {
            System.out.println("\nYou can't afford this item!");
        }
        else
        {
            System.out.println("\nYou have purchased an item!");
            player.setGold(playerGold - itemCost); // decrement players gold by cost of item
            player.addItem(item); // adds an item to the players inventory
            System.out.println("\nItems in inventory"); 
            player.printInventory(); // prints out the players inventory
            player.printGold();
        }
    }

    // this method sells items and increments the players gold
    public void sellItem(Character player, Item item, int choice)
    {
        int playerGold = player.getGold();
        int itemCost = item.getCost();

        player.setGold(playerGold + (itemCost / 2)); // increments players gold by 50% cost of item
        System.out.println("\nYou have sold an item"); 
        player.removeItem(choice-1); // removes the item from inventory
        player.printGold();
        System.out.println("\nItems in inventory");
        player.printInventory(); 
    }

    // this method prints the items available in the shop 
    public void printShop(List<Item> list)
    {
        int ii = 0;

        for (Item item : list)
        {
            ii++;
            System.out.println(ii + ") " + item.toString());
        }
    }  

    // this method prints the enchantments available for purchase
    public void printEnchantments()
    {
        System.out.println("\n1) [Damage +2], [Cost: 5], [Effect: Add 2 to attack damage]");
        System.out.println("2) [Damage +5], [Cost: 10], [Effect: Add 5 to attack damage]");
        System.out.println("3) [Fire Damage], [Cost: 20], [Effect: Add 5-10 to attack damage]");
        System.out.println("4) [Power-Up], [Cost: 10], [Effect: Multiply attack damage by 1.1]");
        System.out.println("5) [Exit Shop]");
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
}