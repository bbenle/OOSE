/***************************************************
* PURPOSE: This class contains the constructors and
* methods for Slime
*          
* DATE: 26 May 2020
****************************************************/

package src.model;

public class Slime extends Enemy
{
    // default constructor
    public Slime()
    {
        // name, max health, current health, min atk, max atk, min def, max def, gold awarded
        super("Slime", 10, 10, 3, 5, 0, 2, 10);
    }

    // method that the slime uses to attack
    public int attack()
    {
        // 20% chance that its attack will have no damage
        int damage = Enemy.randInt(3,5);
        int chance = Enemy.randInt(1,5);
        
        // if chance is 1, slime will do 0 damage 
        if (chance == 1)
        {
            System.out.println("\nSlime has activated it's special ability!");
            System.out.println("It's attack will do 0 damage");
            damage = 0;
        }
        return damage;
    }

    // the slimes defence is a random number between 0 and 2
    public int defence()
    {
        int defence = Enemy.randInt(0,2);
        return defence;
    }
}