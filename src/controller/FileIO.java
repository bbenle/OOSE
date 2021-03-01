/********************************************************
* PURPOSE: This class is used to read in a text file
* for the shop to sell items and to also set the 
* cheapest weapon and armour for the player
*          
* DATE: 26 May 2020
*********************************************************/

package src.controller;

import src.model.*;
import src.model.Character;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class FileIO
{
    // this method reads in the file and adds items to a list for the shop
    public static List<Item> readFileIntoListForShop(Character player)
    {
        FileInputStream fileStrm = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        Weapon cheapestWeapon = null;
        Armour cheapestArmour = null;

        String line;
        List<Item> shopList = new ArrayList<Item>(); // list for the shop
        ItemFactory itemFactory = new ItemFactory(); // factory that creates item objects
        String[] lineArray; // array used to store line.split(", ")

        try
        {
            fileStrm = new FileInputStream("shop.txt");
            rdr = new InputStreamReader(fileStrm);
            bufRdr = new BufferedReader(rdr);

            line = bufRdr.readLine(); // reads a line of the text file 
        
            // if the line in text file is not null, continue looping
            while (line != null)
            {  
                lineArray = line.split(", "); // splits where ", " is and stores in lineArray

                // checks for cheapest weapon, if first element in array is a weapon
                if (lineArray[0].equals("W"))
                {
                    Item cheapestItem = itemFactory.getItem(lineArray); // newItem will be a newly created item

                    if (cheapestWeapon == null)
                    {
                        cheapestWeapon = (Weapon)cheapestItem; 
                        
                    }
                    else
                    {
                        // if cost of current cheapest weapon is greater than cost of new item
                        if (cheapestWeapon.getCost() > cheapestItem.getCost())
                        {
                            cheapestWeapon = (Weapon)cheapestItem; // change cheapest weapon to the new item
                        }
                    }
                }

                // checks for cheapest armour, if first element in array is armour
                if (lineArray[0].equals("A"))
                {
                    Item cheapestItem = itemFactory.getItem(lineArray); // newItem will be a newly created item

                    if (cheapestArmour == null)
                    {
                        cheapestArmour = (Armour)cheapestItem;
                    }
                    else
                    {
                        // if cost of current cheapest armour is greater than cost of new item
                        if (cheapestArmour.getCost() > cheapestItem.getCost())
                        {
                            cheapestArmour = (Armour)cheapestItem; // change cheapest armour to new item
                        }
                    }
                }
                Item newItem = itemFactory.getItem(lineArray); // newItem will be a newly created item
                shopList.add(newItem); // adds items to the list for the shop
                line = bufRdr.readLine();
            }
            player.addItem(cheapestWeapon); // adds the cheapest weapon to the players inventory
            player.addItem(cheapestArmour); // adds the cheapest armour to the players inventory
            player.setWeapon(cheapestWeapon); // sets players weapon to cheapest weapon
            player.setArmour(cheapestArmour); // sets players armour to cheapest armour
            fileStrm.close(); 
        }
        catch (IOException e)
        {
            if (fileStrm != null)
            {
                try
                {
                    fileStrm.close();
                }
                catch (IOException ex2)
                {
                }
            }
            System.out.println("Error in file processing " + e.getMessage());
        }
        return shopList;
    } 
}