/***************************************************
* PURPOSE: This class is used to create the weapon
* armour and potion objects as they are read in from 
* the file
*          
* DATE: 26 May 2020
****************************************************/

package src.controller;

import src.model.*;

public class ItemFactory
{
    // method to create the items (weapon, armour, potion)
    public Item getItem(String[] lineArray)
    {   
        Item newItem = null;
        String name;
        int min;
        int max;
        int cost;
        String dmgType;
        String wepType;
        String material;
        String potionEffect;
        
        name = lineArray[1]; // index 1 of the array is the name of the item
        min = Integer.parseInt(lineArray[2]); // typecast from an integer to a String
        max = Integer.parseInt(lineArray[3]); // typecast from an integer to a String
        cost = Integer.parseInt(lineArray[4]); // typecast from an integer to a String
    
        // creates the objects 
        if (lineArray[0].equals("W")) // if index 0 of the array is W, it is a weapon
        {
            dmgType = lineArray[5]; 
            wepType = lineArray[6];
            newItem = new Weapon(name, min, max, cost, dmgType, wepType);
        }
        else if (lineArray[0].equals("A")) // if index 0 of the array is A, it is armour
        {
            material = lineArray[5];
            newItem = new Armour(name, min, max, cost, material);
        }
        else if (lineArray[0].equals("P")) // if index 0 of the array is P, it is a potion
        {
            potionEffect = lineArray[5];
            newItem = new Potion(name, min, max, cost, potionEffect);
        }
        return newItem;
    }  
}