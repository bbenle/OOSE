/********************************************************
* PURPOSE: This class is one of the concrete strategy
* classes that implement the Battle strategy interface
*          
* DATE: 26 May 2020
*********************************************************/

package src.controller;

import src.model.Character;
import src.model.*;

public class EnemyAttack implements Battle
{
    @Override
    public void attack(Character player, Enemy enemy) 
    {
        // enemy can only attack if they're alive (health above 0)
        if (enemy.getCurrentHp() > 0)
        {
            int enemyDamage = enemy.attack();
            int playerDefence = player.defence();
            int enemyDmgDealt = Math.max(0, enemyDamage-playerDefence);

            // print statements to show the events of the battle
            // the players health is also decremented here depending on enemy damage dealt
            System.out.println("\n" + enemy.getName() + " attacked " + player.getName() + 
            " dealing " + enemyDamage + " damage");
            System.out.println(player.getName() + " blocked " + playerDefence + " damage and loses " + enemyDmgDealt + " health");
            player.setCurrentHp(player.getCurrentHp() - enemyDmgDealt);
            System.out.println("\n[Name]: " + player.getName());
            System.out.println("[Health]: " + player.getCurrentHp());
            System.out.println("\n[Name]: " + enemy.getName());
            System.out.println("[Health]: " + enemy.getCurrentHp());
        }
    }
}