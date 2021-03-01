/***************************************************
* PURPOSE: This class contains the constructors and
* methods for Dragon
*          
* DATE: 26 May 2020
****************************************************/

package src.model;

public class Dragon extends Enemy
{
    // default constructor
    public Dragon()
    {
        // name, max health, current health, min atk, max atk, min def, max def, gold awarded
        super("Dragon", 100, 100, 15, 30, 15, 20, 100);
    }

    // method that the dragon uses to attack
    public int attack()
    {
        // 35% chance of one of the following happening when it attacks
        // a) double damage inflicted (25% chance)
        // b) recover 10 health (10% chance)
        int damage = Enemy.randInt(15,30);
        int chance = Enemy.randInt(1, 100);

        // if chance is a number less than or equal to 25, attack will do double damage
        if (chance <= 25)
        {
            System.out.println("\nDragon has activated it's special ability!");
            System.out.println("It's attack will do double damage");
            damage = damage * 2;    
        }
        // else if chance is a number less than or equal to 35, it will heal 10
        else if (chance <= 35)
        {
            System.out.println("\nDragon has activated it's special ability!");
            System.out.println("It will heal 10 health");
            setCurrentHp(Math.min(getMaxHp(), getCurrentHp() +10));
            damage = 0;
        }
        return damage;
    }

    // the dragons defence is a random number between 15 and 20
    public int defence()
    {
        int defence = Enemy.randInt(15,20);
        return defence;
    }
}