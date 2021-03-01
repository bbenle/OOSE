/***************************************************
* PURPOSE: This class contains the constructors and
* methods for the enchantment Damage2
*          
* DATE: 26 May 2020
****************************************************/

package src.model;

public class Damage2 extends Enchantment
{
    // constructor that adds 2 extra damage to the wrapped object and costs 5 gold
    public Damage2(Item next)
    {
        super(next);
        next.setMin(next.getMin() +2);
        next.setMax(next.getMax() +2);
        next.setCost(next.getCost() +5);
        next.setName(next.getName() + " + 2dmg");
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