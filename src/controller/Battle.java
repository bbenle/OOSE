/********************************************************
* PURPOSE: This class is an interface which defines an 
* attack with concrete strategy classes implementing it
*          
* DATE: 26 May 2020
*********************************************************/

package src.controller;

import src.model.Enemy;
import src.model.Character;

public interface Battle
{
    public void attack(Character player, Enemy enemy); // both the player and enemy can attack
}