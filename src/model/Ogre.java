/***************************************************
* PURPOSE: This class contains the constructors and
* methods for Ogre
*          
* DATE: 26 May 2020
****************************************************/

package src.model;

public class Ogre extends Enemy
{
    // default constructor
    public Ogre()
    {
        // name, max health, current health, min atk, max atk, min def, max def, gold awarded
        super("Ogre", 40, 40, 5, 10, 6, 12, 40);
    }

    // method that the ogre uses to attack
    public int attack()
    {
        // 20% chance that the ogre will attack twice in a row
        int damage = Enemy.randInt(5,10);
        int chance = Enemy.randInt(1,5);

        // if chance is 1, ogre will attack twice in a row
        if (chance == 1)
        {
            int secondAttack = Enemy.randInt(5,10);
            damage += secondAttack;
            System.out.println("\nOgre has activated it's special ability!");
            System.out.println("It will attack twice");
        }
        return damage;
    }

    // the ogres defence is a random number between 6 and 12
    public int defence()
    {
        int defence = Enemy.randInt(6,12);
        return defence;
    }
}