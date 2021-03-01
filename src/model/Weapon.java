/***************************************************
* PURPOSE: This class contains the constructors and
* methods for Weapon
*          
* DATE: 26 May 2020
****************************************************/

package src.model;

public class Weapon implements Item
{
    // private class fields
    private String name;
    private int min;
    private int max;
    private int cost;
    private String damageType;
    private String weaponType;

    // alternate constructor
    public Weapon(String inName, int inMin, int inMax, 
                  int inCost, String inDamageType, String inWeaponType)
    {
        name = inName;
        min = inMin;
        max = inMax;
        cost = inCost;
        damageType = inDamageType;
        weaponType = inWeaponType;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public int getMin()
    {
        return min;
    }

    @Override
    public int getMax()
    {
        return max;
    }

    @Override
    public int getCost()
    {
        return cost;
    }

    @Override
    public void setName(String inName)
    {
        name = inName;
    }

    @Override
    public void setMin(int inMin)
    {
        min = inMin;
    }

    @Override
    public void setMax(int inMax)
    {
        max = inMax;
    }

    @Override
    public void setCost(int inCost)
    {
        cost = inCost;
    }   

    @Override
    public String toString()
    {
        return "[" + name + "]" + ", [Stats: " + min + "-" + max + "]" + ", [Cost: " + cost + "]" +
               ", [Dmg Type: " + damageType + "]" + ", [Weapon Type: " + weaponType + "]";
    }
    
    // getters
    public String getDamageType()
    {
        return damageType;
    }

    public String getWeaponType()
    {
        return weaponType;
    }

    // setters
    public void setDamageType(String inDamageType)
    {
        damageType = inDamageType;
    }

    public void setWeaponType(String inWeaponType)
    {
        weaponType = inWeaponType;
    }
}
