/***************************************************
* PURPOSE: This class contains the constructors and
* methods for Goblin
*          
* DATE: 26 May 2020
****************************************************/

package src.model;

public class Goblin extends Enemy
{
    // default constructor
    public Goblin()
    {
        // name, max health, current health, min atk, max atk, min def, max def, gold awarded
        super("Goblin", 30, 30, 3, 8, 4, 8, 20);
    }

    // method that the goblin uses to attack
    public int attack()
    {
        // 50% chance that its attack will have 3 extra damage
        int damage = Enemy.randInt(3,8);
        int chance = Enemy.randInt(1,2);

        // if chance is 1, goblin will do 3 extra damage
        if (chance == 1)
        {
            System.out.println("\nGoblin has activated it's special ability!");
            System.out.println("It's attack will do an extra 3 damage");
            damage = damage + 3;
        }
        return damage;
    }

    // the goblins defence is a random number between 4 and 8
    public int defence()
    {
        int defence = Enemy.randInt(4,8);
        return defence;
    }
}