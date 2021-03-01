/********************************************************
* PURPOSE: This class is a context class which executes 
* the action of the Battle interface (Strategy Pattern)
*          
* DATE: 26 May 2020
*********************************************************/

package src.controller;

import src.model.Character;
import src.model.Enemy;

public class BattleContext
{
    // private class fields
    private Battle battle;

    public BattleContext(Battle battle)
    {
        this.battle = battle;
    }

    // this method executes an attack for either a player or an enemy
    public void executeAttack(Character player, Enemy enemy)
    {
        battle.attack(player, enemy);
    }
}