/***************************************************
* PURPOSE: This class contains the constructors and
* methods for Enchantment
*          
* DATE: 26 May 2020
****************************************************/

package src.model;

public abstract class Enchantment implements Item
{
    // private class fields
    protected Item next;

    // alternate constructor
    public Enchantment(Item next)
    {
        this.next = next;
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