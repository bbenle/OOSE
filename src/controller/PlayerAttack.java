/********************************************************
* PURPOSE: This class is one of the concrete strategy
* classes that implement the Battle strategy interface
*          
* DATE: 26 May 2020
*********************************************************/

package src.controller;

import src.model.Character;
import src.model.*;

public class PlayerAttack implements Battle
{
    @Override
    public void attack(Character player, Enemy enemy)
    {
        // enemy can only attack if they're alive (health above 0)
        if (player.getCurrentHp() > 0)
        {
            int playerDamage = player.attack();
            int enemyDefence = enemy.defence();
            int playerDmgDealt = Math.max(0, playerDamage-enemyDefence);

            // print statements to show the events of the battle
            // the enemies health is also decremented here depending on player damage dealt
            System.out.println("\n" + player.getName() + " attacked the " + enemy.getName() + 
            " dealing " + playerDamage + " damage");
            System.out.println(enemy.getName() + " blocked " + enemyDefence + " damage and loses " + playerDmgDealt + " health");
            enemy.setCurrentHp(enemy.getCurrentHp() - playerDmgDealt);
        }
    }
}