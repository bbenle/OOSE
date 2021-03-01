/***************************************************
* PURPOSE: This class contains the constructors and
* methods for the enchantment FireDamage
*          
* DATE: 26 May 2020
****************************************************/

package src.model;

import java.util.Random;

public class FireDamage extends Enchantment
{
    // private class fields
    private Random random = new Random();
    private int randomNum = random.nextInt(10-5) + 5;

    // constructor that adds a random 5-10 extra damage to the wrapped object and costs 20 gold
    public FireDamage(Item next)
    {
        super(next);
        next.setMin(next.getMin() +randomNum);
        next.setMax(next.getMax() +randomNum);
        next.setCost(next.getCost() +20);
        next.setName(next.getName() + " +" + randomNum + "dmg");
    }

    @Override
    public String getName()
    {
        return next.getName();
    }

    @Override
    public int getMin()
    {
        return next.getMin();
    }

    @Override
    public int getMax()
    {
        return next.getMax();
    }

    @Override
    public int getCost()
    {
        return next.getCost();
    }

    @Override
    public void setName(String inName)
    {
        next.setName(inName);  
    }

    @Override
    public void setMin(int inMin)
    {
        next.setMin(inMin); 
    }

    @Override
    public void setMax(int inMax)
    {
        next.setMax(inMax); 
    }

    @Override
    public void setCost(int inCost)
    {
        next.setCost(inCost); 
    } 

    @Override
    public String toString()
    {
        return next.toString();
    }
}