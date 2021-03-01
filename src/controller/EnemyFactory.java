/***************************************************
* PURPOSE: This class is used to create the enemies
* and alter their spawn rates
*          
* DATE: 26 May 2020
****************************************************/

package src.controller;

import src.model.*;

public class EnemyFactory
{
    private static int spawnSlime = 50; // spawn rate of Slime starts off at 50
    private static int spawnGoblin = 30; // spawn rate of Goblin stats off at 30
    private static int spawnOgre = 20; // spawn rate of Ogre starts off at 20

    public Enemy getEnemy()
    {
        int num = Enemy.randInt(1, 100); // picks a random number from 1 and 100
        Enemy enemy = null;

        if (num < 0)
        {
            return null;
        }
        // battle1|battle2|battle3|battle4
        else if (num <= spawnSlime) // if the random number is less than 50, spawn a slime
        {
            enemy = new Slime(); // 50|45|40|35
      
        }
        else if (num <= spawnGoblin + spawnSlime) // if the random number is less than 80, spawn a goblin
        {
            enemy = new Goblin(); // 80|70|60|50
            
        } 
        else if (num <= spawnOgre + spawnSlime + spawnGoblin) // if the random number is less than 80, spawn an ogre
        {
            enemy = new Ogre(); // 100|85|70|55
           
        }
        else // spawns a dragon
        {
            enemy = new Dragon(); // 0|85|75|55
            
        } 
        updateSpawnRate();
        return enemy; 
    }

    // method to update the spawn rate of the enemies
    // decreases slime, goblin and ogre spawn rate by 5 each time a battle is won unless it takes it below 5%
    public void updateSpawnRate()
    {
        if (spawnSlime >= 10)
        {   
            spawnSlime -= 5;
        }
        
        if (spawnGoblin >= 10)
        {
            spawnGoblin -= 5;
        }

        if (spawnOgre >= 10)
        {
            spawnOgre -=5;
        }
    }
}