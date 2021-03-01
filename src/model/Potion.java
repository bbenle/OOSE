/***************************************************
* PURPOSE: This class contains the constructors and
* methods for Potion
*          
* DATE: 26 May 2020
****************************************************/

package src.model;

public class Potion implements Item
{
    // private class fields
    private String name;
    private int min;
    private int max;
    private int cost;
    private String potionEffect; // healing or damage potion

    // alternate constructor
    public Potion(String inName, int inMin, int inMax, 
                  int inCost, String inPotionEffect)
    {
        name = inName;
        min = inMin;
        max = inMax;
        cost = inCost;
        potionEffect = inPotionEffect;
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
               ", [Potion Type: " + potionEffect + "]";
    }

    // getters
    public String getPotionEffect()
    {
        return potionEffect; 
    }

    // setters
    public void setPotionEffect(String inPotionEffect)
    {
        potionEffect = inPotionEffect;
    }
}