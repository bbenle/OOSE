/***************************************************
* PURPOSE: This class contains the constructors and
* methods for the enchantment Damage5
*          
* DATE: 26 May 2020
****************************************************/

package src.model;

public class Damage5 extends Enchantment
{
    // constructor that adds 5 extra damage to the wrapped object and and costs 10 gold
    public Damage5(Item next)
    {
        super(next);
        next.setMin(next.getMin() +5);
        next.setMax(next.getMax() +5);
        next.setCost(next.getCost() +10);
        next.setName(next.getName() + " + 5dmg");
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